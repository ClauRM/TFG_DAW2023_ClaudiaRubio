package utilidades;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controladorDB.UsuarioDB;
import modelo.Tratamiento;
import modelo.Usuario;

public class Utilidades {

	public String calcularTratamiento(String inicio, int horas, int duracion) {
		int repeticiones = 24/horas * duracion;
		List<String> listado = new ArrayList<String>(); // variable arrayList
		LocalDateTime fechaDate;
		String fechaString;
		
		//aniadir la hora de inicio al arraylist
		listado.add(inicio);

		// convertir String a fecha para poder operar con ella
		fechaDate = convertirStringDate(inicio);		

		// iteracion bucle for con longitud = repeticiones 
		for (int i = 1; i < repeticiones; i++) {
			//en cada vuelta sumar el n de horas a la fecha
			fechaDate = fechaDate.plusHours(horas);
			
			//convertir LocalDate a String
			fechaString = fechaDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			//aniadir fechaString al arraylist
			listado.add(fechaString);
			}

		// imprimir array list
		System.out.println(listado.toString());

		// devolver el string con las horas del tratamiento
		return listado.toString();
	}

	public static LocalDateTime convertirStringDate(String fecha) {
		LocalDateTime fechaDate = null;
		try {
			//definir el formato
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			//parsear la fecha de String a LocalDate con el formato indicado
			fechaDate = LocalDateTime.parse(fecha,formato);

			//para visualizarla
			System.out.println(fechaDate); 

		} catch (Exception e) {
			System.out.println("Error al convertir fecha String a Date: "+ e.getMessage());
		}
		
		return fechaDate;
	}

	public static String validaUsuarioRegistro(Usuario usuarioTemporal) {
		String errores = "";
		String nombre, email, pass;

		// valores de las variables
		nombre = usuarioTemporal.getNombre();
		email = usuarioTemporal.getEmail();
		pass = usuarioTemporal.getPassword();

		// 1. evaluar que los campos no sean vacios
		if (nombre.length() == 0 || email.length() == 0 || pass.length() == 0) {
			errores = errores + "Debe completar todos los campos del formulario. \n";
		} else {
			// validaciones de nombre
			errores = errores + validaNombre(nombre, 20);

			// validaciones de email
			errores = errores + validaEmail(email);

			// validaciones de la logitud del password
			errores = errores + validaPassword(pass, 6);
		}

		System.out.println("Validaciones de registro: " + errores);
		return errores;
	}

	public static String validaTratamiento(Tratamiento tratamientoTemporal) {
		String errores = "";
		String paciente;
		int dosis, horas, duracion;

		// valores de las variables
		paciente = tratamientoTemporal.getPaciente();
		dosis = tratamientoTemporal.getDosis();
		horas = tratamientoTemporal.getHoras();
		duracion = tratamientoTemporal.getDuracion();

		return errores;
	}

	public static String getFechaActual() {
		String fecha = "";
		// zona horaria y formato de fecha
		fecha = ZonedDateTime.now(ZoneId.of("Europe/Paris")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println(fecha);

		return fecha;
	}

	// validaciones del nombre
	private static String validaNombre(String nombre, int longitudMax) {
		String errores = "";
		int i = 0; // posicion de un caracter del string
		char caracter;
		boolean caracterInv = false;

		nombre = nombre.trim(); // limpio espacios

		// 2. longitud maxima de 20 caracteres
		if (nombre.length() > longitudMax) {
			errores = errores + "El nombre de usuario debe tener máximo 20 caracteres. \n";
		}

		// 3. no puede contener espacios
		if (nombre.contains(" ")) {
			errores = errores + "El nombre de usuario no puede contener espacios.\n";
		}

		// 4. no debe contener caracteres invalidos
		// recorro la cadena

		do {
			caracter = nombre.charAt(i);
			// Si no está entre a y z, ni entre A y Z, ni es un espacio
			if (!((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z'))) {
				errores = errores + "El nombre de usuario no puede contener caracteres inválidos. \n";
				caracterInv = true;
			}
			i++;
		} while (caracterInv && i < nombre.length());

		return errores;
	}

	// validaciones del email
	private static String validaEmail(String email) {
		String errores = "";
		UsuarioDB usuariodb = new UsuarioDB(); // instancia de clase para usar metodo validar

		email = email.trim(); // limpio espacios

		// Compruebo si el email ya esta incluido previamente en la bd
		errores = usuariodb.validarUsuario(email);

		// si hay errores es porque el usuario ya esta incluido en la bd
		if (errores == "") { // si no hay errores, entonces continuar validaciones
			// LONGITUD MINIMA 6 CARACTERES x@y.zz
			if (email.length() < 6) {
				errores = errores + "Longitud de email no válida. \n";
			}

			// CONTIENE ARROBA @
			if (!email.contains("@")) {
				errores = errores + "El email no contiene @. \n";
			}

			// @ DEBE ESTAR ENTRE POSICION 1 Y LONGITUD-5
			if (email.indexOf('@') < 1 || email.indexOf('@') > (email.length() - 5)) {
				errores = errores + "La posición de la @ en el campo email es incorrecta. \n";
			}

			// DESPUES DE LA @ DEBE HABER UN .
			if (email.contains(".")) {
				if (!(email.indexOf('.') > email.indexOf('@'))) {
					errores = errores + "El . del email está en posición incorrecta. \n";
				} else {
					errores = errores + "El email no contiene punto. \n";
				}

				// EL . DEBE ESTAR EN POSICION .xx o .xxx
				if (!(email.indexOf(".") != (email.length() - 3) && email.indexOf(".") != (email.length() - 4))) {
					errores = errores + "Dominio del email incorrecto. \n";
				}

				// EMPEZAR EN LETRA
				if (email.toUpperCase().charAt(0) < 65 || email.toUpperCase().charAt(0) > 90) {
					errores = errores + "El email debe empezar por una letra. \n";
				}

				// TERMINAR EN LETRA
				if (email.toUpperCase().charAt(email.length() - 1) < 65
						|| email.toUpperCase().charAt(email.length() - 1) > 90) {
					errores = errores + "El email debe terminar en letra";
				}
			}
		}

		return errores;
	}

	// validaciones del password
	private static String validaPassword(String pass, int longitud) {
		String errores = "";

		pass = pass.trim(); // limpio espacios

		// 2. longitud exacta
		if (pass.length() < longitud || pass.length() > longitud) {
			errores = errores + "La contraseña debe ser de 6 caracteres. \n";
		}

		// 3. no puede contener espacios
		if (pass.contains(" ")) {
			errores = errores + "La contraseña no puede contener espacios.\n";
		}

		return errores;
	}

}
