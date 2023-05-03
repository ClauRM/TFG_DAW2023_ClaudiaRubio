package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controladorDB.MedicamentoDB;
import modelo.Medicamento;
import utilidades.Utilidades;

/**
 * Servlet implementation class ControladorAdmin
 */
@WebServlet("/ControladorAdmin")
public class ControladorAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// instancia de clase
	MedicamentoDB medicamentoDB = new MedicamentoDB();
	Medicamento obMedicamento = new Medicamento();

	// Variable listado
	List listadoMedicamentos;
	
	int idMedicamento = 0;//variable global idMedicamento
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// metodo que se ejecuta tras recibir datos por metodo get
		// getRequestDispatcher("ControladorAdmin?accion=Acceso&menu=xxx&id=xxx")

		String menu = request.getParameter("menu"); // parametro recibido al hacer submit para llamar al servlet
		String accion = request.getParameter("accion");

		HttpSession sesion = request.getSession();

		System.out.println("menu : " + menu);
		System.out.println("accion : " + accion);

		// variables capturadas del formulario gestion
		String medicamento, buscartexto;

		// variable para enviar mensajes de error al jsp
		String mensaje = "";
		String mensajeOk = "";

		// distribucion en funcion de que valor trae la clave menu del
		// ejemplo, href="Controlador?menu=home"

		if (menu.equalsIgnoreCase("Acceso")) {
			request.setAttribute("sesion", sesion); //envio datos de la sesion
			// si hay acceso redirige a la ventana principal
			request.getRequestDispatcher("principaladmin.jsp").forward(request, response);
		}

		if (menu.equalsIgnoreCase("home")) {
			request.setAttribute("sesion", sesion); //envio datos de la sesion
			request.getRequestDispatcher("homeadmin.jsp").forward(request, response);
		}
		
		if (menu.equalsIgnoreCase("medicamentos")) {
			switch (accion) {
			case "listar":
				//ejecuto consulta listar de la BD y almaceno
				listadoMedicamentos = medicamentoDB.listarMedicamentos();
				//envio los datos a la vista de tabla
				request.setAttribute("medicamentos", listadoMedicamentos); //nombre y datos se envian al jsp
				request.setAttribute("sesion", sesion);
				request.getRequestDispatcher("medicamentosadmin.jsp").forward(request, response);
				break;
			case "agregar":
				if (request.getParameter("medicamento") == "" ) {
					mensaje = "Debes rellenar nombre y composición del medicamento";
				} else {
					medicamento = request.getParameter("medicamento"); //capturo valores del formulario
					obMedicamento.setMedicamento(medicamento); //agrego datos al objeto
					mensaje = Utilidades.validaMedicamento(obMedicamento); //valido medicamento
					
					if(mensaje.contentEquals("") || mensaje == null) { //si no hay errores
						medicamentoDB.aniadirMedicamento(medicamento); //aniade a BD
						mensajeOk = "Medicamento agregado correctamente.";
					}
				}
				request.setAttribute("sesion", sesion); //envio datos de la sesion
				request.setAttribute("mensaje", mensaje); //envio el mensaje al jsp
				request.setAttribute("mensajeOk", mensajeOk);
				//actualizo de nuevo la tabla
				request.getRequestDispatcher("ControladorAdmin?menu=medicamentos&accion=listar").forward(request, response);
				break;
			case "modificar":
				// capturo el id del medicamento seleccionado
				idMedicamento = Integer.parseInt(request.getParameter("idmedicamento")); //indicado en el href boton
				obMedicamento = medicamentoDB.unMedicamento(idMedicamento); //localizo medicamento por su id
				request.setAttribute("medicamento", obMedicamento); //envio objeto medicamento al formulario
				request.setAttribute("sesion", sesion); //envio sesion de usuario
				//actualizo vista de la tabla
				request.getRequestDispatcher("ControladorAdmin?menu=medicamentos&accion=listar").forward(request, response);
				break;
			case "actualizar":
				System.out.println("Evaluando si hay idtratamiento para actualizar = " + idMedicamento);
				if (idMedicamento == 0) {
					System.out.println("No se puede actualizar. El usuario no ha seleccionado medicamento");
					mensaje = "No has seleccionado ningún medicamento para modificar";
				} else if (request.getParameter("medicamento")==""){
					mensaje = "Debes seleccionar un medicamento para modificar";
				} else {
					//capturo del formulario
					idMedicamento = Integer.parseInt(request.getParameter("idmedicamento"));
					medicamento = request.getParameter("medicamento");
					//agrego estos datos al objeto
					obMedicamento.setIdmedicamento(idMedicamento);
					obMedicamento.setMedicamento(medicamento);
					//evaluo si hay errores tras la validacion
					mensaje = Utilidades.validaMedicamento(obMedicamento);
					
					if(mensaje.contentEquals("") || mensaje == null) { //si no hay errores
						medicamentoDB.modificarMedicamento(obMedicamento); //modifica tratamiento en la BD
						System.out.println("Medicamento modificado en DB");
						mensajeOk = "Medicamento modificado correctamente.";
					}
									
				}
				request.setAttribute("sesion", sesion); // envio datos de la sesion
				request.setAttribute("mensaje", mensaje); // envio el mensaje al jsp
				request.setAttribute("mensajeOk", mensajeOk);
				// actualizo de nuevo la tabla
				request.getRequestDispatcher("ControladorAdmin?menu=medicamentos&accion=listar").forward(request, response);
				break;
			case "eliminar":
				//capturo el id del tratamiento seleccionado
				idMedicamento = Integer.parseInt(request.getParameter("idmedicamento")); //indicado en el href boton
				medicamentoDB.eliminarMedicamento(idMedicamento); //finalizo el tratamiento
				mensajeOk = "Medicamento eliminado correctamente.";
				request.setAttribute("sesion", sesion); //envio datos de la sesion
				request.setAttribute("mensaje", mensaje); // envio el mensaje al jsp
				request.setAttribute("mensajeOk", mensajeOk);
				// actualizo de nuevo la tabla
				request.getRequestDispatcher("ControladorAdmin?menu=medicamentos&accion=listar").forward(request, response);
				break;
			case "buscar":
				//capturo del formulario
				buscartexto = request.getParameter("buscar");
				//ejecuto consulta listar de la BD y almaceno
				listadoMedicamentos = medicamentoDB.buscarMedicamento(buscartexto);
				//envio los datos a la vista de tabla
				request.setAttribute("medicamentos", listadoMedicamentos); //nombre y datos se envian al jsp
				request.setAttribute("sesion", sesion);
				request.getRequestDispatcher("medicamentosadmin.jsp").forward(request, response);
				break;
			default:
				System.out.println("Error opción switch del menú 'medicamentos admin'");
				throw new AssertionError();
			}
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
