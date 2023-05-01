package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controladorDB.*;
import modelo.*;
import utilidades.*;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// instancias de clases
	Tratamiento tratamiento = new Tratamiento();
	TratamientoDB tratamientoDB = new TratamientoDB();
	MedicamentoDB medicamentoDB = new MedicamentoDB();

	// Variable listado
	List listadoTratamientos, listadoMedicamentos, tratamientoXhoras;

	// Otras variables
	int idTratamiento;

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
		String idusuario = request.getParameter("id");
		HttpSession sesion = request.getSession();

		System.out.println("id usuario :" + idusuario);
		System.out.println("accion :" + accion);
		System.out.println("menu :" + menu);

		// variables capturadas del formulario gestion
		String paciente, inicio, observaciones, tratamientoSt;
		int fidusuario, fidmedicamento, dosis, horas, duracion;

		// variable para enviar mensajes de error al jsp
		String mensaje = "";

		// distribucion en funcion de que valor trae la clave menu del
		// ejemplo, href="Controlador?menu=home"

		if (menu.equalsIgnoreCase("Acceso")) {
			request.setAttribute("sesion", sesion); // envio datos de la sesion
			// si hay acceso redirige a la ventana principal
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}

		if (menu.equalsIgnoreCase("home")) {
			request.setAttribute("sesion", sesion); // envio datos de la sesion
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

		if (menu.equalsIgnoreCase("medicamentos")) {
			listadoMedicamentos = medicamentoDB.listarMedicamentos(); // ejecuto consulta listar medicamentos DB y
																		// almaceno
			// envio los datos a la vista de tabla
			request.setAttribute("medicamentos", listadoMedicamentos); // nombre con el que se envia y que datos se
																		// envian
			request.getRequestDispatcher("medicamentos.jsp").forward(request, response);
		}

		if (menu.equalsIgnoreCase("enCurso")) {
			// en el menu gestion se encuentra el CRUD completo
			switch (accion) {
			case "listar":
				// ejecuto consulta listar tratamientos de la BD y almaceno
				listadoTratamientos = tratamientoDB.listarTratamientos(Integer.parseInt(idusuario),false);
				// ejecuto consulta listar medicamentos de la BD y almaceno
				listadoMedicamentos = medicamentoDB.listarMedicamentos();
				// envio los datos a la vista de tabla
				request.setAttribute("tratamientos", listadoTratamientos); // nommbre y datos se envian al jsp
				request.setAttribute("medicamentos", listadoMedicamentos); // nommbre y datos se envian al jsp
				request.setAttribute("sesion", sesion);
				request.getRequestDispatcher("tratamientosencurso.jsp").forward(request, response);
				break;
			case "agregar":
				fidusuario = Integer.parseInt(request.getParameter("id"));// capturo del href para listar tabla

				if (request.getParameter("paciente") == "" | request.getParameter("dosis") == ""
						| request.getParameter("horas") == "" | request.getParameter("duracion") == "") {
					mensaje = "Debes rellenar todos los campos del formulario para agregar un nuevo tratamiento";
				} else {
					// capturo los valores marcados en el formulario
					// requiero: fidusuario, fidmedicamento, paciente, dosis, horas, duracion, inicio,
					// tratamiento, observaciones, activo
					fidmedicamento = Integer.parseInt(request.getParameter("idmedicamento"));
					paciente = request.getParameter("paciente");
					dosis = Integer.parseInt(request.getParameter("dosis"));
					horas = Integer.parseInt(request.getParameter("horas"));
					duracion = Integer.parseInt(request.getParameter("duracion"));
					inicio = Utilidades.getFechaActual(); //hora y fecha del equipo
					tratamientoSt = Utilidades.calcularTratamiento(inicio, horas, duracion); // metodo encargado del
																							// calculo en
																							// funcion de horas y pauta
					observaciones = request.getParameter("observaciones");
					// agrego estos datos al objeto tratamiento
					tratamiento.setFidusuario(fidusuario);
					tratamiento.setFidmedicamento(fidmedicamento);
					tratamiento.setPaciente(paciente);
					tratamiento.setDosis(dosis);
					tratamiento.setHoras(horas);
					tratamiento.setDuracion(duracion);
					tratamiento.setInicio(inicio);
					tratamiento.setTratamiento(tratamientoSt);
					tratamiento.setObservaciones(observaciones);
					tratamiento.setActivo(1);

					// evaluo si hay errores tras la validacion del tratamiento
					mensaje = Utilidades.validaTratamiento(tratamiento);
					
					if(mensaje.contentEquals("") || mensaje == null) { // si no hay errores
						tratamientoDB.aniadir(tratamiento); // lo aniade a la bd
					} 
				}
				request.setAttribute("sesion", sesion); // envio datos de la sesion
				request.setAttribute("mensaje", mensaje); // envio el mensaje al jsp
				// actualizo de nuevo la tabla
				request.getRequestDispatcher("Controlador?menu=enCurso&accion=listar&id=" + fidusuario).forward(request,
						response);
				break;
			case "modificar":
				// capturo el id del tratamiento seleccionado
				idTratamiento = Integer.parseInt(request.getParameter("idTratamiento")); // indicado en el href del
																							// boton
				// utilizo metodo unTratamiento para localizarlo con su id
				tratamiento = tratamientoDB.unTratamiento(idTratamiento);
				// envio los datos del tratamiento al formulario
				request.setAttribute("tratamiento", tratamiento);
				// actualizo de nuevo la tabla
				request.setAttribute("sesion", sesion);
				request.getRequestDispatcher("Controlador?menu=enCurso&accion=listar").forward(request, response);
				break;
			case "actualizar":
				System.out.println("Evaluando si hay idtratamiento para actualizar = " + idTratamiento);
				if (idTratamiento == 0) {
					System.out.println("No se puede modificar. El usuario no ha seleccionado tratamiento previamente");
					mensaje = "No has seleccionado ningún tratamiento para modificar";
				} else if (request.getParameter("dosis")=="" || request.getParameter("horas")=="" || request.getParameter("duracion")==""){
					mensaje = "Debes seleccionar un tratamiento para modificar";
				} else {
					// requiero: fidusuario, fidmedicamento, paciente, dosis, horas, tratamiento,
					// observaciones, activo, idtratamiento
					fidusuario = Integer.parseInt(request.getParameter("id"));
					fidmedicamento = Integer.parseInt(request.getParameter("idmedicamento"));
					paciente = request.getParameter("paciente");
					dosis = Integer.parseInt(request.getParameter("dosis"));
					horas = Integer.parseInt(request.getParameter("horas"));
					duracion = Integer.parseInt(request.getParameter("duracion"));
					// metodo encargado del calculo en funcion de horas y pauta
					tratamientoSt = Utilidades.calcularTratamiento(request.getParameter("inicio"), horas, duracion); 
					observaciones = request.getParameter("observaciones");
					// agrego estos datos al objeto tratamiento
					tratamiento.setFidusuario(fidusuario);
					tratamiento.setFidmedicamento(fidmedicamento);
					tratamiento.setPaciente(paciente);
					tratamiento.setDosis(dosis);
					tratamiento.setHoras(horas);
					tratamiento.setDuracion(duracion);
					tratamiento.setTratamiento(tratamientoSt);
					tratamiento.setObservaciones(observaciones);
					tratamiento.setActivo(1);
					tratamiento.setIdtratamiento(idTratamiento); // capturado en el modificar y enviado en href
					
					// evaluo si hay errores tras la validacion del tratamiento
					mensaje = Utilidades.validaTratamiento(tratamiento);
					
					if(mensaje.contentEquals("") || mensaje == null) { // si no hay errores
						tratamientoDB.modificar(tratamiento); // modifica tratamiento en la BD
						System.out.println("Tratamiento modificado en DB");
					}
									
				}
				request.setAttribute("sesion", sesion); // envio datos de la sesion
				request.setAttribute("mensaje", mensaje); // envio el mensaje al jsp
				// actualizo de nuevo la tabla
				request.getRequestDispatcher("Controlador?menu=enCurso&accion=listar").forward(request, response);
				break;
			case "finalizar":
				// capturo el id del tratamiento seleccionado
				idTratamiento = Integer.parseInt(request.getParameter("idTratamiento")); // indicado en el href del
																							// boton
				tratamientoDB.finalizar(idTratamiento); // finalizo el tratamiento
				request.setAttribute("sesion", sesion); //envio datos de la sesion
				// actualizo de nuevo la tabla
				request.getRequestDispatcher("Controlador?menu=enCurso&accion=listar").forward(request, response);
				break;
			default:
				System.out.println("Error opción switch del menú 'en gestion'");
				throw new AssertionError();
			}
		}

		if (menu.equalsIgnoreCase("recetas")) {
			// obtener el listado de tratamientos asociado al usuario
			listadoTratamientos = tratamientoDB.listarTratamientos(Integer.parseInt(idusuario),false);
			// obtener un nuevo listadoXhoras de esos tratamientos
			tratamientoXhoras = Utilidades.listarTratamientosxHoras(listadoTratamientos);
			// envio los datos a la vista de tabla
			request.setAttribute("tratamientos", tratamientoXhoras); // nommbre y datos se envian al jsp			
			request.setAttribute("sesion", sesion);// envio datos de la sesion
			request.getRequestDispatcher("recetas.jsp").forward(request, response);			
		}

		if (menu.equalsIgnoreCase("finalizados")) {
			switch (accion) {
			case "listar":
				// ejecuto consulta listar tratamientos de la BD y almaceno
				listadoTratamientos = tratamientoDB.listarTratamientos(Integer.parseInt(idusuario),true);
				// ejecuto consulta listar medicamentos de la BD y almaceno
				listadoMedicamentos = medicamentoDB.listarMedicamentos();
				// envio los datos a la vista de tabla
				request.setAttribute("tratamientos", listadoTratamientos); // nommbre y datos se envian al jsp
				request.setAttribute("medicamentos", listadoMedicamentos); // nommbre y datos se envian al jsp
				request.setAttribute("sesion", sesion); // envio datos de la sesion
				request.getRequestDispatcher("tratamientosfinalizados.jsp").forward(request, response);
				break;
			case "finalizar":
				// capturo el id del tratamiento seleccionado
				idTratamiento = Integer.parseInt(request.getParameter("idTratamiento")); // indicado en el href del
																							// boton
				tratamientoDB.eliminar(idTratamiento); // finalizo el tratamiento
				mensaje = "Tratamiento eliminado correctamente.";
				request.setAttribute("sesion", sesion); //envio datos de la sesion
				request.setAttribute("mensaje", mensaje); // envio el mensaje al jsp
				// actualizo de nuevo la tabla
				request.getRequestDispatcher("Controlador?menu=finalizados&accion=listar").forward(request, response);
				break;
			default:
				System.out.println("Error opción switch del menú 'finalizados'");
				throw new AssertionError();
			}
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
