package com.example.acsha.junittest.chapter17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSets {
	String setupDataSet() default "/empty.xml";

	String assertDataSet() default "";
}
