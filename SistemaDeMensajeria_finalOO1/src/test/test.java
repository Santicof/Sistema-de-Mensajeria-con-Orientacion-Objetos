package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modulo.OperadorMovil;
import modulo.Sitema;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sitema sis = new Sitema();
		OperadorMovil personal = new OperadorMovil(1, "Personal");
		OperadorMovil claro = new OperadorMovil(2, "Claro");
		OperadorMovil movistar = new OperadorMovil(3, "Movistar");
		// --------------------------------------------------------------------------------------------------------
		System.out.println("\n1-1");
		try {
			sis.agregarSMS(LocalDate.of(2020, 12, 11), LocalTime.of(17, 37), 1523456780, 156543210,
					"voy a llegar mas tarde", personal, claro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//------------------------------------------------------------------------------------------------------------------
		System.out.println("\n1-2");
		try {
			sis.agregarSMS(LocalDate.of(2020, 12, 11), LocalTime.of(17, 37), 1523456780, 1565432109,
					"voy a llegar mas tarde", personal, claro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//--------------------------------------------------------------------------------------------------------------------
		System.out.println("\n1-3");

		try {
			sis.agregarEmail(LocalDate.of(2020, 12, 13), LocalTime.of(15, 16), "informacion@unla.gob.ar", "alumno.com",
					"informacion", "Estimado alumno,le enviamos el protocolo para rendir examen virtual");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// -------------------------------------------------------------------------------------------------------------
		System.out.println("\n1-4");

		try {
			sis.agregarEmail(LocalDate.of(2020, 12, 13), LocalTime.of(15, 16), "informacion@unla.gob.ar",
					"alumno@gmail.com", "informacion",
					"Estimado alumno,le enviamos el protocolo para rendir examen virtual");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//-------------------------------------------------------------------------------------------------------------------------
		System.out.println("\n2-1");
		sis.traerMensaje(1).cambiarDeEstado(true);
		System.out.println(sis.traerMensaje(1));
		try {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//-------------------------------------------------------------------------------------------------------------------------
		System.out.println("\n2-2");

		try {
			sis.traerMensaje(2).cambiarDeEstado(true);
			System.out.println(sis.traerMensaje(2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//---------------------------------------------------------------------------------------------------------------------------------
		System.out.println("\n3");

		try {
			sis.agregarSMS(LocalDate.of(2020, 11, 15), LocalTime.of(12, 03), 1523456780, 1598760883, "RECIBIDO OK",
					movistar, claro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sis.agregarSMS(LocalDate.of(2020, 12, 10), LocalTime.of(13, 16), 1523456780, 1598768250, "GRACIAS",
					personal, movistar);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sis.agregarEmail(LocalDate.of(2020, 11, 8), LocalTime.of(17, 15), "oo1@unla.gob.ar", "alumno@gmail.com",
					"Orientacion a objetos unla", "grilla de finales de diciembre");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sis.agregarEmail(LocalDate.of(2020, 12, 10), LocalTime.of(8, 19), "informacion@unla.gob.ar",
					"cliente@gmail.com", "Ofertas", "Aproveche nuestras ofertas");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(sis.getLstMensajes());

		//---------------------------------------------------------------------------------------------------------------------------------
		System.out.println("\n4-1");

		try {
			System.out.println(sis.traerMensaje("Personal"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//---------------------------------------------------------------------------------------------------------------------------------
		System.out.println("\n4-2");

		try {
			System.out.println(sis.traerMensaje(LocalDate.of(2020, 12, 10), LocalTime.of(8, 0), LocalTime.of(14, 0)));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//---------------------------------------------------------------------------------------------------------------------------------
		System.out.println("\n4-3");
		try {
			System.out.println(
					sis.traerMensaje(LocalDate.of(2020, 11, 15), LocalTime.of(12, 0), LocalTime.of(13, 0), "Movistar"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
