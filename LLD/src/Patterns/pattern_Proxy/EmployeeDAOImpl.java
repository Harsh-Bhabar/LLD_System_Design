package Patterns.pattern_Proxy;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void delete(){
        System.out.println("Delete called.");
    }

    @Override
    public void get(){
        System.out.println("Get called.");
    }

    @Override
    public void add(){
        System.out.println("Add called.");
    }
}
