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

/**
 * Servlet implementation class ControladorAdmin
 */
@WebServlet("/ControladorAdmin")
public class ControladorAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// instancia de clase
	MedicamentoDB medicamentoDB = new MedicamentoDB();

	// Variable listado
	List listadoMedicamentos;
       
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
		String idusuario = request.getParameter("id");
		HttpSession sesion = request.getSession();

		System.out.println("id usuario :" + idusuario);
		System.out.println("accion :" + accion);
		System.out.println("menu :" + menu);

		// variables capturadas del formulario gestion
		
		//*******************//

		// variable para enviar mensajes de error al jsp
		String mensaje = "";

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
			listadoMedicamentos = medicamentoDB.listarMedicamentos(); //ejecuto consulta listar medicamentos DB y almaceno
			// envio los datos a la vista de tabla
			request.setAttribute("medicamentos", listadoMedicamentos); //nombre enviado y datos se envian
			request.getRequestDispatcher("medicamentosadmin.jsp").forward(request, response);
		}
		switch (accion) {
		case "agregar":
			
			break;
		case "modificar":
			
			break;
		case "eliminar":
			
			break;

		default:
			break;
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
