package test.exception;

import net.sf.oval.ConstraintViolation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by on 07.04.16.
 */
public class ValidException extends Exception {

    private Map<String , String> map = new HashMap<>();

    public ValidException(Map<String,String> map){
        this.map=map;
    }

    public Map<String, String> getMap() {
        return map;
    }

}
