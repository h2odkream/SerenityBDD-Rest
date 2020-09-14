package co.com.bancolombia.certificacion.libranzas.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CapturarFecha {
	private static Date fechaActual = new Date();
	private static DateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
	public static final String FECHA_ACTUAL_SISTEMA = formatoFecha.format(fechaActual);

	private CapturarFecha() {
		throw new IllegalStateException("Utility class");
	}

}
