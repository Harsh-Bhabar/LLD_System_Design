package Patterns.pattern_Proxy;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO realDAO = new EmployeeDAOImpl();
        // admin
        System.out.println("Admin user");
        EmployeeDAO adminProxy = new EmployeeDAOProxy(realDAO, "admin");
        adminProxy.delete();
        adminProxy.add();
        adminProxy.get();
        // non-admin
        System.out.println("Admin user");
        EmployeeDAO userProxy = new EmployeeDAOProxy(realDAO, "user");
        userProxy.delete();
        userProxy.add();
        userProxy.get();
    }
}
