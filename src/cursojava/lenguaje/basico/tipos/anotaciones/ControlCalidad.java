package cursojava.lenguaje.basico.tipos.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.TYPE )
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControlCalidad {
	
	/**
	 * Indica la versión con formato mayor.menor.revision
	 * 
	 * @return El valor de la versión xx.yy.zz
	 * 
	 */
	String value() default "1.0.0";
	
	/**
	 * Indica el resultado de ejecución de pruebas
	 * 
	 * @return <strong>true</strong> si las pruebas se pasarón o false si no
	 */
	boolean testOk() default false;

}

