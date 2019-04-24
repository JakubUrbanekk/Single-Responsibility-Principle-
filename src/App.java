import java.util.ArrayList;

public class App{
    public static void main (String[] args){
        Student stud1=new Student.StudentBuilder(12,"Marcin", "Waligorski", "asd").setAddres("Pawelkowo").setScholarship(2356).build();
        Student stud2=new Student.StudentBuilder(14, "Krzysztof", "Krawczyk", "asd").setFaculty(Student.Faculty.ELECTRICAL_ENGINEERING).build();
        Student stud3=new Student.StudentBuilder(165,"Maciej", "Grabczyk", "asd").build();
        ArrayList<Student> users=new ArrayList<>();
        users.add(stud1);
        users.add(stud2);
        users.add(stud3);
        ArrayList<Student>bannedUsers=new ArrayList<>();
        bannedUsers.add(stud3);
        Server server=new Server.ServerBuilder(users,bannedUsers).setLanguage("Polish").build();
        server.check(stud1, "asd");

    }
}
