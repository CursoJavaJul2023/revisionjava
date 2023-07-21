package cursojava.funcionalidad.fechas;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class EmpleoDeFechas {
	
	public static void main(String[] args) throws ParseException {
		
		// empleoDeFechasClasico();
		
		// java.time
		
		Temporal tipoBase;
		
		// Sólo fecha
		
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaConcreta = LocalDate.of(2022, 10, 1);
		
		// Sólo hora
		
		LocalTime horaActual = LocalTime.now();
		LocalTime horaConcreta = LocalTime.of(10, 30, 0);
		
		// Fecha + hora
		
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		LocalDateTime fechaHoraConcreta = LocalDateTime.of(2023, 10, 5, 10, 10, 10);
		
		// Fecha + hora + zona
		
		ZonedDateTime fechaHoraConZonaActual = ZonedDateTime.now();
		ZonedDateTime.of(fechaHoraConcreta, ZoneId.of("Europe/Paris"));
		
		// Clases auxiliares
		
		YearMonth mesDeUnAño = YearMonth.of(2023, 10);
		MonthDay diaDeUnMes = MonthDay.of(10, 3);
		
		/////////////////////////////////////////////////////////////////////////
		
		// operaciones
		
		LocalDateTime doceDeHoy = fechaActual.atStartOfDay();
		LocalDateTime cincoDeHoy = fechaActual.atTime(17, 0, 0);
		
		LocalDate hoyMasCincoDias = fechaActual.plus(5, ChronoUnit.DAYS);
		LocalDate hoyMenosDosSemanas = fechaActual.minusWeeks(2);
		
		// formateo
		
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate fechaLeida = LocalDate.parse("01/10/2023", formateador);
		String fechaFormateada = fechaActual.format(formateador);
		
		// conversión entre zonas horarias
		
		ZonedDateTime despegueDesdeParis = ZonedDateTime.of(2023, 7, 20, 10, 0, 0, 0, ZoneId.of("Europe/Paris"));
		ZonedDateTime aterrizajeEnTokyo = despegueDesdeParis.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(10);
		
		System.out.printf("Salimos de Paris: %s - Llegamos a Tokyo: %s%n", despegueDesdeParis, aterrizajeEnTokyo);	
		
	}

	public static void empleoDeFechasClasico() throws ParseException {
		// Clase para representar fecha+hora por defecto
		
		Date fechaHoraActual = new Date();
		
		Date fechaFin = java.sql.Date.valueOf("2023-08-09");
		
		Date fechaHoraCalendario = Timestamp.valueOf("2023-07-24 09:00:00.0");
		
		System.out.println(fechaHoraActual);
		
		// Para emplear base de datos podemos querer emplear columnas
		// con los tipos SQL TIME, TIMESTAMP, DATE
		
		// Sólo componentes de fecha
		java.sql.Date fechaSDate = java.sql.Date.valueOf("2023-07-20"); 
		
		// Sólo componentes de hora
		Time horaFinal = Time.valueOf("15:00:00");
		
		// Todas las componentes
		Timestamp fechaHoraConcreta = Timestamp.valueOf("2023-07-24 09:00:00.0");
		
		//////////////////////////////////////////////
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(fechaHoraCalendario));
		
		Date fechaProcesada = sdf.parse("10/03/2023");
		System.out.println(fechaProcesada);
	}

}
