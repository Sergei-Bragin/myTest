package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

import java.io.UnsupportedEncodingException;


/**
 * Created by on 18.04.16.
 */
public class ImageValidCheck extends AbstractAnnotationCheck<ImageValid> {

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) throws OValException {

        try {
            String name = new String((byte[]) valueToValidate, "UTF-8");
            System.out.println(name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

}
