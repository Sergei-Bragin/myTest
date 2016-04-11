package test.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by on 04.04.16.
 */
public class ControllerFactory {

    private Map<String, InternalController> controllerMap = new HashMap<>();

    private InternalController defaultController = new DepartmentsShowAllController();

    {
        controllerMap.put("/", defaultController);
        controllerMap.put("/delDep", new DepartmentsDelController());
        controllerMap.put("/addDep", new DepartmentCreateAddPageController());
        controllerMap.put("/saveDep", new DepartmentAddController());
        controllerMap.put("/showDepEmpl", new DepartmentShowEmplList());
        controllerMap.put("/addEmpl", new EmployeeCreateAddPageController());
        controllerMap.put("/saveEmpl", new EmployeeAddController());
        controllerMap.put("/delEmpl", new EmployeeDelController());
        controllerMap.put("/error", new ErrorShowPage());


    }

    public InternalController getControllerByName(String name){
        return controllerMap.get(name);
    }

    public InternalController getDefaultController(){
        return defaultController;
    }


}
