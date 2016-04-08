package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import java.sql.SQLException;

/**
 * Created by on 08.04.16.
 */
public class UniqueNameDepCheck  extends AbstractAnnotationCheck<UniqueNameDep>{

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public boolean isSatisfied(Object validatedObject, Object value,
                               OValContext context, Validator validator) throws OValException {
        try
        {
            Department validate = (Department) value;
            Department dep = departmentService.getByName(value.toString());
            String name = dep.getName();
            if(dep.getId()==null){
                return true;
            }
            else if(!value.toString().equals(name))
            {
                return true;
            }
            return  false;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return true;
        }

    }
}
