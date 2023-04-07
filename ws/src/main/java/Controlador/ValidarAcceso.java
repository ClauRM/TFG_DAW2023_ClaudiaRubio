package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ControladorDB.UsuarioDB;
import Modelo.Usuario;

/**
 * Servlet implementation class ValidarAcceso
 */
@WebServlet("/ValidarAcceso")
public class ValidarAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// instanciar los objetos UusarioDB y Usuario
	UsuarioDB usuarioDB = new UsuarioDB();
	Usuario user = new Usuario();

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
		String usuario = request.getParameter("usuario"); // nombre de la variable del formulario
		String email = request.getParameter("email"); // nombre de la variable del formulario
		String pass = request.getParameter("pass");

		UsuarioDB usuarioDB = new UsuarioDB(); // usuario que sera agregado a la DB

		if (accion.equalsIgnoreCase("Login")) { // si la accion es value="Login"
			user = usuarioDB.validarUsuario(usuario, pass); // metodo para validar si el usuario esta en la tabla

			if (user.getNombre() != null && user.getNombre() != "") { // si el nombre es diferente de null
				// envio el nombre del usuario a la ventana principal
				request.setAttribute("usuario", user); // setAttribute(nombre, objeto que queremos almacenar)
				sesion.setAttribute("usuario", usuario);
				// envio los datos al controlador.java que dara el acceso a la ventana principal
				request.getRequestDispatcher("Controlador?menu=Acceso").forward(request, response);
			} else {
				// en caso contrario redireccionar a la misma pagina
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} else if (accion.equalsIgnoreCase("Registro")) { // si la accion es value="Registro",

			// si esta ok, llamar a conexion metodo insertar
			// paso los valores al metodo insertar en db
			usuarioDB.insertarUsuario(new Usuario(usuario, email, pass));
			// redirecciona a la ventana del login tras la insercion
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {// en caso de que no presione el boton de Login o la accion recibida sea Salir,
				// se redirecciona a la pagina de index
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
