package hu.dpc.edu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Created by vrg on 2016. 11. 09..
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Component
public @interface RestResource {
}
