package Patterns.pattern_Proxy;

public class EmployeeDAOProxy implements EmployeeDAO{

    private EmployeeDAO employeeDAO;
    private String currentUser;

    EmployeeDAOProxy(EmployeeDAO employeeDAO, String currentUser){
        this.employeeDAO = employeeDAO;
        this.currentUser = currentUser;
    }

    private boolean isAdmin(){
        return "Admin".equalsIgnoreCase(currentUser);
    }

    @Override
    public void delete(){
        if(isAdmin()){
            System.out.println("Proxy : Admin access granted, Deleting.");
            employeeDAO.delete();
        }else{
            System.out.println("Proxy: Not Admin. Can't delete.");
        }
    }

    @Override
    public void get(){
        if(isAdmin()){
            System.out.println("Proxy : Admin access granted, Getting.");
            employeeDAO.get();
        }else{
            System.out.println("Proxy: Not Admin. Can't Get.");
        }
    }

    @Override
    public void add(){
        if(isAdmin()){
            System.out.println("Proxy : Admin access granted, Adding.");
            employeeDAO.add();
        }else{
            System.out.println("Proxy: Not Admin. Can't add.");
        }
    }
}
