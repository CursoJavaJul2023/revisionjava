package cursojava.funcionalidad.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ProbarEmpleoDeStreams {
	
	public static void main(String[] args) {
		
		// Streams SON USO UNICO
		
		// Origines de streams
		
		// Colecciones
		
		// Stream.of(10, 20, 30);
		
		List.of(10, 20, 30, 40)
			.stream()
			.filter(
				n -> n >= 20 && n <= 30
			)
			.map(
				n -> n * n
			)
			.forEach(System.out::println);
		
		
		boolean sonTodosPares = Stream.of(10, 20, 30, 40).allMatch( n -> n % 2 == 0);
		
		Set<Integer> datos = Stream.of(10, 20, 30, 40).map( n -> n + 10).collect(Collectors.toSet());
		
		
		// Streams para tipos primitivos
		
		LongStream datosLong = LongStream.of(10, 20, 30, 50);
		DoubleStream datosDouble = DoubleStream.of(10.0, 20.0, 30.0, 40.0);
		
		IntStream serie1 = IntStream.range(1, 1000); // 1 ... 999
		IntStream serie2 = IntStream.rangeClosed(1, 1000); // 1 ... 10000
		
		IntStream serie3 = IntStream.iterate(1, n -> n + 5).limit(1000);
		IntStream serie4 = IntStream.generate( () -> (int)(Math.random() * 100000)).limit(1000);
		
		// Operaciones para Streams numéricos
		
		int sumaSerie1 = serie1.sum();
						// serie1.average();
						// serie1.max();
		
		IntSummaryStatistics estadisticas = serie3.summaryStatistics();
		System.out.println(estadisticas);
		
			
		
	}

}



