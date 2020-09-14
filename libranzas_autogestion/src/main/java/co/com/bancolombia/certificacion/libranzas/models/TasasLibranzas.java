package co.com.bancolombia.certificacion.libranzas.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TasasLibranzas {
	private static double tasaMesVencida, tasaNominalAnualMV, tasaEfectivaAnual, tasaMora, tasaDTF, puntosTa;;

	public static double getTasaMesVencida() {
		return tasaMesVencida;
	}

	public static double getTasaNominalAnualMV() {
		return tasaNominalAnualMV;
	}

	public static double getTasaEfectivaAnual() {
		return tasaEfectivaAnual;
	}

	public static double getTasaMora() {
		return tasaMora;
	}

	public static double getTasaDTF() {
		return tasaDTF;
	}

	public static double getPuntosTa() {
		return puntosTa;
	}

	public TasasLibranzas(ResultSet rs, int plazoHasta, int montoDesembolsado) throws SQLException {
		while (rs.next()) {

			if (rs.getInt(4) == plazoHasta && montoDesembolsado >= rs.getInt(5) && montoDesembolsado <= rs.getInt(6)) {

				TasasLibranzas.tasaMesVencida = ((rs.getDouble(8) * 10)) / 10;
				TasasLibranzas.tasaNominalAnualMV = rs.getDouble(9) * 100;
				TasasLibranzas.tasaEfectivaAnual = (rs.getDouble(10) * 10000) / 100;
				TasasLibranzas.tasaMora = rs.getDouble(1);
				TasasLibranzas.tasaDTF = rs.getDouble(2);
				TasasLibranzas.puntosTa = rs.getDouble(7);
			}

		}

	}

	public static TasasLibranzas consultar(ResultSet rs, int plazoHasta, int montoDesembolsado) throws SQLException {
		return new TasasLibranzas(rs, plazoHasta, montoDesembolsado);
	}

}
