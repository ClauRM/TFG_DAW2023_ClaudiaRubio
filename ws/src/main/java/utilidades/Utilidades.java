package utilidades;

import modelo.Usuario;

public class Utilidades {

	public String calcularTratamiento(int dosis, int horas, int duracion) {
		// TODO desarrollar tratamiento
		return "Aquí irá el tratamiento separado por comas";
	}

	public static String validaUsuarioRegistro(Usuario usuarioTemporal) {
		String errores = "";
		String nombre, email, pass;

		// valores de las variables
		nombre = usuarioTemporal.getNombre();
		email = usuarioTemporal.getEmail();
		pass = usuarioTemporal.getPassword();

		// validaciones de nombre
		errores = validaNombre(nombre, 20);

		// validaciones de email
		errores = validaEmail(email);

		// validaciones de la logitud del password
		errores = validaPassword(pass, 6);

		return errores;
	}

	// validaciones del nombre
	private static String validaNombre(String nombre, int longitudMax) {
		String errores = "";
		int i = 0; // posicion de un caracter del string
		char caracter;
		boolean caracterInv = false;

		// 1. que no este vacio
		if (nombre.length() == 0) {
			errores = "Debe escribir un nombre de usuario. \n";
		}

		// 2. longitud maxima de 20 caracteres
		if (nombre.length() > longitudMax) {
			errores = "El nombre de usuario debe tener máximo 20 caracteres. \n";
		}

		// 3. no puede contener espacios
		if (nombre.contains(" ")) {
			errores = "El nombre de usuario no puede contener espacios.\n";
		}

		// 4. no debe contener caracteres invalidos
		// recorro la cadena

		do {
			char c = nombre.charAt(i);
			// Si no está entre a y z, ni entre A y Z, ni es un espacio
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
				errores = "El nombre de usuario puede contener caracteres inválidos. \n";
				caracterInv = true;
			}
			i++;
		} while (caracterInv && i < nombre.length());

		return errores;
	}

	// validaciones del email
	private static String validaEmail(String email) {
		String errores = "";

		// LONGITUD MINIMA 6 CARACTERES x@y.zz
		if (email.length() < 6) {
			errores = "Longitud de email no válida. \n";
		}

		// CONTIENE ARROBA @
		if (!email.contains("@")) {
			errores = "El email no contiene @. \n";
		}

		// @ DEBE ESTAR ENTRE POSICION 1 Y LONGITUD-5
		if (email.indexOf('@') < 1 || email.indexOf('@') > (email.length() - 5)) {
			errores = "La posición de la @ en el campo email es incorrecta. \n";
		}

		// DESPUES DE LA @ DEBE HABER UN .
		if (email.contains(".")) {
			if (!(email.indexOf('.') > email.indexOf('@'))) {
				errores = "El . del email está en posición incorrecta. \n";
			} else {
				errores = "El email no contiene punto. \n";
			}

			// EL . DEBE ESTAR EN POSICION .xx o .xxx
			if (!(email.indexOf(".") != (email.length() - 3) && email.indexOf(".") != (email.length() - 4))) {
				errores = "Dominio del email incorrecto. \n";
			}

			// EMPEZAR EN LETRA
			if (email.toUpperCase().charAt(0) < 65 || email.toUpperCase().charAt(0) > 90) {
				errores = "El email debe empezar por una letra. \n";
			}

			// TERMINAR EN LETRA
			if (email.toUpperCase().charAt(email.length() - 1) < 65
					|| email.toUpperCase().charAt(email.length() - 1) > 90) {
				errores = "El email debe terminar en letra";
			}

		}
		return errores;
	}

	// validaciones del password
	private static String validaPassword(String pass, int longitud) {
		String errores = "";

		// 1. que no este vacio
		if (pass.length() == 0) {
			errores = "Debe escribir una contraseña para su acceso. \n";
		}

		// 2. longitud exacta
		if (pass.length() < longitud || pass.length() > longitud) {
			errores = "La contraseña debe ser de 6 caracteres. \n";
		}

		return errores;
	}

}
