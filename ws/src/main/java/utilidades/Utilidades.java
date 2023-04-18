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

		email = email.trim(); // limpio espacios

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
