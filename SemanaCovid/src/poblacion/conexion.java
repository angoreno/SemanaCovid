package poblacion;

import java.sql.*;

public class conexion {

	String user;
	String pass;
	String url;

	Connection conex;

	Statement stm;

	public conexion() {

		user = "poblacion";
		pass = "fruna";
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		conex = null;
		stm = null;

	}

	public void conectar() {
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			conex = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion Exitosa");
		} catch (Exception e) {
			System.out.println("Conexion NO REALIZADA");

		}
	}

	public int leerDB(int año) {

		try {
			stm = conex.createStatement();
		} catch (Exception e) {
			System.out.println("error de conexion");
		}
		String cadSql = "";
		try {
			System.out.println("hola");
			cadSql = "SELECT * FROM tbl_poblacion WHERE (cmp_ano = " + año + ") AND (tbl_pais_cmp_codpais = 'EST')";
			ResultSet rs = stm.executeQuery(cadSql);
			int datos = 0;

			while (rs.next()) {
				datos += (rs.getInt(4));
			}

			return datos;

		} catch (Exception e) {

			System.out.println(e);
			return 0;

		}

	}

}
