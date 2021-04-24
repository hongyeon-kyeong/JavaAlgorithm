/*class Person{
    public Object info;
    Person(Object info){
        this.info = info;
    }
}*/
class Person<T>{
    public T info;
    Person(T info){
        this.info = info;
    }
}
class StudentInfo{
    public int grade;
    StudentInfo(int grade){
        this.grade = grade;
    }
}
class StudentPerson{
    public StudentInfo info;
    StudentPerson(StudentInfo info){
        this.info = info;
    }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){
        this.rank = rank;
    }
}
class EmployeePerson{
    public EmployeeInfo info;
    EmployeePerson(EmployeeInfo info){
        this.info = info;
    }
}

public class Generic {
    public static void main(String[] args) {
        //Person<String> p1 = new Person<String>("부장");
        //EmployeeInfo e1 = (EmployeeInfo) p1.info;
        //System.out.println(e1.rank);

        Person<EmployeeInfo> p2 = new Person<EmployeeInfo>(new EmployeeInfo(1));
        EmployeeInfo e2 = p2.info;
        System.out.println(e2.rank);
        //StudentInfo si = new StudentInfo(2);
        //StudentPerson sp = new StudentPerson(si);
        //System.out.println(sp.info.grade);

        //EmployeeInfo ei = new EmployeeInfo(1);
        //EmployeePerson ep = new EmployeePerson(ei);
        //System.out.println(ep.info.rank);

        //Person<String> p1 = new Person<String>();
        //Person<StringBuilder> p2 = new Person<StringBuilder>();
    }
}

