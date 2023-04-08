package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ControladorDB.TratamientoDB;
import Modelo.Tratamiento;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//instancias de clases
	Tratamiento tratamiento = new Tratamiento();
	TratamientoDB tratamientoDB = new TratamientoDB();
	
	//Variable listado
	List listado;

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
		// getRequestDispatcher("Controlador?accion=Acceso")

		String menu = request.getParameter("menu"); // parametro que se recibe cuando se hace submit para llamar al
													// servlet
		String accion = request.getParameter("accion");

		// distribucion en funcion de que valor trae la clave menu del
		// ejemplo, href="Controlador?menu=home"

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
			// en el menu gestion se encuentra el CRUD completo
			switch (accion) {
			case "listar":
				// almaceno en el listado el resultado de ejecutar la consulta listar
				listado = tratamientoDB.listar(); 
				// envio los datos a la vista de tabla
				request.setAttribute("tratamientos", listado); //nommbre con el que se envia y que datos se envian
				request.getRequestDispatcher("tratamientosencurso.jsp").forward(request, response);
				break;
			case "aniadir":
				break;
			case "modificar":
				break;
			case "eliminar":
				break;
			default:
				throw new AssertionError();
			}

			//request.getRequestDispatcher("tratamientosencurso.jsp").forward(request, response);

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
