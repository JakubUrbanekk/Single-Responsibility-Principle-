import java.util.Scanner;

public class UserFacultyMiddleware extends Middleware{

        public boolean check(Student student, String password) {
            Student.Faculty facultyName=server.hasFaculty(student);
            Scanner scanner=new Scanner(System.in);
            if (facultyName==null) {
                while(true){
                    System.out.println("You don't have assigned faculty " + "Do you want to choose faculty? It's mandatory " + "\n" + "Y/N" + "\n" + "Your decision? ");
                    String decision=scanner.next();
                    if(decision.equals("Y")){
                        String facultiesList="";
                        String separator=", ";
                        for (Student.Faculty faculty: Student.Faculty.values()){
                            facultiesList=facultiesList+faculty+separator;
                        }
                        System.out.println("Allowed faculties are " + facultiesList);
                        System.out.println("Choose your faculty");
                        String facultyInput = scanner.next();
                        try{
                            Student.Faculty newFaculty = Student.Faculty.valueOf(facultyInput);
                            student.setFaculty(newFaculty);
                            System.out.println("Faculty assigned succesfully");
                            return true;
                        } catch(IllegalArgumentException e){
                            System.out.println("Invalid faculty name!");
                            return false;
                        }
                    } else if(decision.equals("N")){
                        System.out.println("You didn't choose faculty!");
                        return false;
                    } else{
                        System.out.println("Invalid input. Try again");
                    }
                }
            }
            System.out.println("Hello, "+ student.getFaculty() + " student");
            return true;
        }
}