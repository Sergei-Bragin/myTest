package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by on 11.04.16.
 */
public class EnglishLettersCheck extends AbstractAnnotationCheck<EnglishLetters> {

    private static final String NAME_PARENT = "^[a-zA-Z0-9_]+$";

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) throws OValException {
        if(chekName(valueToValidate.toString())){
            return true;
        }else
            return false;
    }

    public static boolean chekName(String name){
        Pattern pattern = Pattern.compile(NAME_PARENT);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
