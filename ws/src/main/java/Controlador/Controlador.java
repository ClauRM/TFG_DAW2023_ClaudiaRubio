package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// metodo que se ejecuta tras recibir datos por metodo get
		// getRequestDispatcher("Controlador?menu=Acceso")

		String menu = request.getParameter("menu"); // parametro que se recibe cuando hay un usuario en el servlet

		String accion = request.getParameter("accion"); // parametro que se recibe cuando hay un usuario en el servlet
		// validarUsuario

		// distribucion en funcion de que valor trae la clave menu del
		// getRequestDispatcher()
		// dentro de cada menu se evalua la accion del getRequestDispatcher()
		if (menu.equalsIgnoreCase("Acceso")) {
			// si hay acceso redirige a la ventana principal
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}

		if (menu.equalsIgnoreCase("home")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		if (menu.equalsIgnoreCase("medicamentos")) {
			request.getRequestDispatcher("medicamentos.jsp").forward(request, response);
		}
		
		if (menu.equalsIgnoreCase("enCurso")) {
			request.getRequestDispatcher("tratamientosencurso.jsp").forward(request, response);
		
		}
		
		if (menu.equalsIgnoreCase("finalizados")) {
			request.getRequestDispatcher("tratamientosfinalizados.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// muestra lo que se recibe por el metodo doGet como resultado (pagina web)
		doGet(request, response);
	}

}
