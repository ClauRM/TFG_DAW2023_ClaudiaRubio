package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladorDB.*;
import modelo.*;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//instancias de clases
	Tratamiento tratamiento = new Tratamiento();
	TratamientoDB tratamientoDB = new TratamientoDB();
	MedicamentoDB medicamentoDB = new MedicamentoDB();
	
	//Variable listado
	List listadoTratamientos, listadoMedicamentos;

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

		String menu = request.getParameter("menu"); // parametro recibido al hacer submit para llamar al servlet
		String accion = request.getParameter("accion");
		
		//variables capturadas del formulario gestion
		String medicamento,paciente,observaciones;
		int idmedicamento,dosis,horas;
		

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
			listadoMedicamentos = medicamentoDB.listar(); // ejecuto consulta listar medicamentos DB y almaceno
			// envio los datos a la vista de tabla
			request.setAttribute("medicamentos", listadoMedicamentos); //nombre con el que se envia y que datos se envian
			request.getRequestDispatcher("medicamentos.jsp").forward(request, response);
		}

		if (menu.equalsIgnoreCase("enCurso")) {
			// en el menu gestion se encuentra el CRUD completo
			switch (accion) {
			case "listar":
				// ejecuto consulta listar tratamientos de la BD y almaceno
				listadoTratamientos = tratamientoDB.listar();
				// ejecuto consulta listar medicamentos de la BD y almaceno
				listadoMedicamentos = medicamentoDB.listar();
				// envio los datos a la vista de tabla
				request.setAttribute("tratamientos", listadoTratamientos); //nommbre con el que se envia y que datos se envian
				request.setAttribute("medicamentos", listadoMedicamentos);
				request.getRequestDispatcher("tratamientosencurso.jsp").forward(request, response);
				break;
			case "aniadir":
				//capturo los valores marcados en el formulario
				
				// requiero: fidusuario, fidmedicamento, paciente, dosis, horas, tratamiento, observaciones, activo
				// fidusuario
				
				idmedicamento = Integer.parseInt(request.getParameter("idmedicamento")); //parseo los datos de tipo int
				paciente = request.getParameter("paciente");
				dosis = Integer.parseInt(request.getParameter("dosis"));
				horas = Integer.parseInt(request.getParameter("horas"));
				// tratamiento ------- desarrollar clase java --------
				observaciones = request.getParameter("observaciones");
				// activo = 1 por defecto
				
				
				
				
				
				
				
				
				
				//agrego estos datos al objeto tratamiento
				
				//utilizo el metodo que lo aniade a la bd
				tratamientoDB.aniadir(tratamiento);
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
