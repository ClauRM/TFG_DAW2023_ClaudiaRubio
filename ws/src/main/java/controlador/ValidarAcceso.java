package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controladorDB.UsuarioDB;
import modelo.Usuario;
import utilidades.Utilidades;

/**
 * Servlet implementation class ValidarAcceso
 */
@WebServlet("/ValidarAcceso")
public class ValidarAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// instanciar los objetos UusarioDB y Usuario
	UsuarioDB usuarioDB = new UsuarioDB();
	Usuario user = new Usuario();
	private Usuario userTemporal = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidarAcceso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();
		String accion = request.getParameter("accion"); // nombre del boton que realiza la accion

		// valores capturador del formulario
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email"); // nombre de la variable del formulario
		String pass = request.getParameter("pass");

		String mensaje, hayErrores = "";

		UsuarioDB usuarioDB = new UsuarioDB(); // usuario que sera agregado a la DB

		if (accion.equalsIgnoreCase("Login")) {

			// controlar que los campos de acceso no son vacios
			if (!(email.equalsIgnoreCase("") || pass.equalsIgnoreCase(""))) {
				// si la accion es value="Login"
				user = usuarioDB.validarUsuario(email, pass); // metodo para validar si el usuario esta en la tabla

				if (user.getEmail() != null && user.getEmail() != "") { // si el nombre es diferente de null
					// envio datos de la sesion de usuario a la ventana principal
					sesion.setAttribute("usuario", user); // envio los datos a la web (nombre, objeto que envio)
					request.setAttribute("sesion", sesion);// almaceno los datos del usuario en la sesion
					request.setAttribute("usuario", usuario);// almaceno los datos del usuario en la sesion

					// comprobar si el usuario es admin
					if (user.getAdmin() == 1) {
						request.getRequestDispatcher("ControladorAdmin?menu=Acceso&id=" + user.getIdusuario())
						.forward(request, response);
					} else {
						// envio los datos al controlador.java que dara el acceso a la ventana principal
						request.getRequestDispatcher("Controlador?menu=Acceso&id=" + user.getIdusuario())
								.forward(request, response);
					}
				} else {
					// si no lo localiza el usuario en la DB
					mensaje = email + " no está registrado en CronoMed. Accede desde Nuevo Registro.";
					request.setAttribute("mensaje", mensaje); // envio el mensaje al jsp
					request.getRequestDispatcher("index.jsp").forward(request, response);// redirijo a la ventana de
																							// login
				}

			} else {
				// si no se ha marcado email y/o password
				mensaje = "Debe teclear email y contraseña para acceder";
				request.setAttribute("mensaje", mensaje); // envio el mensaje al jsp
				request.getRequestDispatcher("index.jsp").forward(request, response); // redirijo a la ventana de login

			}

		} else if (accion.equalsIgnoreCase("Registro")) { // si la accion es value="Registro",

			userTemporal = new Usuario(usuario, email, pass);
			hayErrores = Utilidades.validaUsuarioRegistro(userTemporal); // verifico errores tras validar el usuario
																			// temporal

			// if(!email.equalsIgnoreCase("") && !pass.equalsIgnoreCase("")&&
			// !usuario.equalsIgnoreCase("")) {
			if (hayErrores.contentEquals("") || hayErrores == null) { // si no hay errores
				// si esta ok, llamar a conexion metodo insertar
				// paso los valores al metodo insertar en db
				usuarioDB.insertarUsuario(userTemporal);
				// redirecciona a la ventana del principal tras la insercion
				mensaje = "Usuario registrado correctamente. Inicie sesión para acceder.";
				request.setAttribute("mensajeOk", mensaje); // envio el mensaje al jsp
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				// si hay errores
				request.setAttribute("mensaje", hayErrores); // envio los mensajes de error a la web
				// redirecciona a la misma ventana de registro
				request.getRequestDispatcher("registro.jsp").forward(request, response);

			}

		} else {// en caso de que no presione el boton de Login o la accion recibida sea Salir,
				// se redirecciona a la pagina de index
			sesion.invalidate(); // eliminar la sesion
			System.out.println("Cerrando sesión del usuario: " + sesion);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
