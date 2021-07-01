package com.ejemplo.dateapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateApp {
	
	public void verificar(int version) {
		
		if(version==7) {
			
			//Desde Java 1.7 para atras.
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			
			fecha1.set(1991, 0, 21);
			
			System.out.println(fecha1.after(fecha2));
		}else if(version ==8) {
			
			//Desde Java 1.8.
			LocalDate fecha1 = LocalDate.of(1991, 01, 21);
			LocalDate fecha2 = LocalDate.now();
			
			System.out.println(fecha1.isAfter(fecha2));
			

			LocalTime hora1 = LocalTime.of(22, 30, 50);
			LocalTime hora2 = LocalTime.now();
			
			System.out.println(hora1.isBefore(hora2));


			LocalDateTime fechaHora1 = LocalDateTime.of(1991, 01, 21, 22, 30, 50);
			LocalDateTime fechaHora2 = LocalDateTime.now();
			
			System.out.println(fechaHora1.isAfter(fechaHora2));

		}
	}
	
	public void medirTiempo(int version) throws InterruptedException {
		
		if(version == 7) {
			
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			System.out.println(fin - ini);
		}else if(version == 8) {
			
			//Desde Java 1.8.
			Instant ini = Instant.now();
			Thread.sleep(1000);
			Instant fin = Instant.now();
			System.out.println(Duration.between(ini, fin).toMillis());
		}
	}
	
	public void periodoEntreFechas(int version) {
		
		if(version == 7) {
			
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual = Calendar.getInstance();
			
			nacimiento.set(1991, 0, 21);
			actual.set(2021, 5, 14);
			
			int anios = 0;
			
			while(nacimiento.before(actual)) {
				
				nacimiento.add(Calendar.YEAR, 1);
				
				if(nacimiento.before(actual)) {
					
					anios++;
				}
			}
			
			System.out.println(anios);

		}else if(version == 8) {
			
			LocalDate nacimiento = LocalDate.of(1991, 1, 21);
			LocalDate actual = LocalDate.now();
			
			Period periodo = Period.between(nacimiento, actual);
			
			System.out.println("Han pasado " + periodo.getDays() + " dias " + periodo.getMonths()
			 + " meses " + periodo.getYears() + " años desde " + nacimiento + " hasta " + actual);
		}
	}
	
	//Saca fecha en modo texto:
	public void convertir(int version) throws ParseException {
		
		if(version == 7) {
			
			String fecha = "21/01/1991";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaConvertida = formateador.parse(fecha);
			
			System.out.println(fechaConvertida);
			
			Date fechaActual = Calendar.getInstance().getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena = formateador.format(fechaActual);
			
			System.out.println(fechaCadena);

		}else if(version == 8) {

			String fecha = "21/01/1991";
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
			
			System.out.println(fechaLocal);
			System.out.println(formateador.format(fechaLocal));
			formateador = DateTimeFormatter.ofPattern("dd/MM/yy");
			System.out.println(formateador.format(fechaLocal));
		}
	}

	public static void main(String[] args){
		
		DateApp app = new DateApp();
		
		System.out.println("Verificar Java 1.7:");
		app.verificar(7);
		System.out.println("Verificar Java 1.8:");
		app.verificar(8);

		try {
			System.out.println("Medir tiempo Java 1.7:");
			app.medirTiempo(7);
			System.out.println("Medir tiempo Java 1.8:");
			app.medirTiempo(8);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("Periodo entre fechas Java 1.7:");
		app.periodoEntreFechas(7);
		System.out.println("Periodo entre fechas 1.8:");
		app.periodoEntreFechas(8);

		try {
			System.out.println("Fecha convertida 1.7:");
			app.convertir(7);
			System.out.println("Fecha convertida 1.8:");
			app.convertir(8);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

}
