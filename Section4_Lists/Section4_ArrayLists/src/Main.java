import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        List<Employee> L = new ArrayList<>();
        L.add(new Employee("Jane","Jones",123));
        L.add(new Employee("John","Doe",4567));
        L.add(new Employee("Mary","Smith",22));
        L.add(new Employee("Mike","Wilson",3245));
        L.forEach(employee -> System.out.println(employee)); //loops through the list and spits em out
        System.out.println(L.size());
        L.set(2,new Employee("John","Adams",1776));
        System.out.println(L.size());
        System.out.println(L.get(2));
        Object[] employeeArr = L.toArray(new Employee[L.size()]);
        System.out.println(employeeArr.length);

    }
}
