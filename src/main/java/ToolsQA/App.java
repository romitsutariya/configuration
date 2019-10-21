package ToolsQA;

/**
 * Hello world!
 *
 */


 import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;


public class App 
{
    public List<Employee> getEmployeeList(){
 
        Session session = null;
        session = HibernateUtil.getSession();
       // String queryStr = "select emp from Employee emp";
        Query query = session.createQuery(queryStr);
 
        return query.list();
    }
    public static void main( String[] args )
    {
        EmployeesDao empDao = new EmployeesDao();
        List<Employee> empList = empDao.getEmployeeList();
        System.out.println("emp size: "+empList.size());
        empList.stream().forEach(System.out::println);
    }
}
