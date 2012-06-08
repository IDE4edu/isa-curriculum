package src.test;

import java.lang.annotation.RetentionPolicy.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD)
public @interface Repeat {  
     int value() default 10;  
}  