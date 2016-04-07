package test.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by on 07.04.16.
 */
public class ValidException extends Exception {

    private Map<String , String> mapError = new HashMap<>();

    public ValidException(Map<String,String> mapError){
        this.mapError = mapError;
    }

    public Map<String, String> getMapError() {
        return mapError;
    }
}
