package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Usuario;
import Modelo.UsuarioDB;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("login"); // nombre del boton que realiza la accion

		// valores capturador del formulario
		String usuario = request.getParameter("usuario"); // nombre de la variable del formulario
		String pass = request.getParameter("pass");

		if (accion.equalsIgnoreCase("Login")) { // si la accion es value="Login"
			user = usuarioDB.validarUsuario(usuario, pass); // metodo para validar si el usuario esta en la tabla

			if (user.getNombre() != null && user.getNombre() != "") { // si el nombre es diferente de null
				// envio el nombre del usuario a la ventana principal
				request.setAttribute("usuario", user); //setAttribute(nombre, objeto que queremos almacenar) 
				// envio los datos al controlador.java que dara el acceso a la ventana principal
				request.getRequestDispatcher("Controlador?accion=Acceso").forward(request, response);
			} else {
				// en caso contrario redireccionar a la misma pagina
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} else {
			// en caso de que no presione el boton redireccionar a la misma pagina
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
