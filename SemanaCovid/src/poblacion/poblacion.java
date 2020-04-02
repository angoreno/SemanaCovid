package poblacion;

import java.util.*;

public class poblacion {

	public static void main(String[] args) {

		int month1 = 0;
		int month2 = 0;
		String country1;
		String country2;

		conexion conexion=new conexion();
		Scanner leo = new Scanner(System.in);
		

		System.out.println("Ingrese el rango de años a consultar:");
		while (month1 == 0) {
			System.out.println("Año de inicio:");
			month1 = leo.nextInt();

			if (evalan(month1) == true) {
				month1 = month1;
			} else {

				System.out.println("el año ingresado no es valido");
				System.out.println("intentar nuevamente");
				month1 = 0;
			}
		}

		while (month2 == 0) {
			System.out.println("Año de termino:");
			month2 = leo.nextInt();
			if (evalan(month2) == true) {
				month2 = month2;
			} else {

				System.out.println("el año ingresado no es valido");
				System.out.println("intentar nuevamente");
				month2 = 0;
			}
		}
		
		conexion.conectar();
		System.out.println(conexion.leerDB(month1));
		

	}

	public static boolean evalan(int an) {

		String a = an + "";
		int aa = an;
		int coe1 = 0;
		int coe2 = 0;
		boolean resp = false;

		a.length();

		if (a.length() == 4) {
			coe1 = 1;
		} else {
			coe1 = 0;
		}

		if (aa < 2019 && aa > 1959) {
			coe2=1;
		}else {
			coe2=0;
		}
		
		if ((coe1+coe2) == 2) {
			resp=true;
		}else {
			resp=false;
		}

		return resp;

	}

}
