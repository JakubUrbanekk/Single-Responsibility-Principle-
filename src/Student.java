import java.util.Objects;

final class Student{
    private int index;
    private String firstName;
    private String secondName;
    private String address;
    private String password;
    private Faculty faculty;
    private int age;
    private int scholarship;

    private Student (StudentBuilder builder){
        this.index = builder.index;
        this.firstName=builder.firstName;
        this.secondName=builder.secondName;
        this.address=builder.address;
        this.age=builder.age;
        this.scholarship=builder.scholarship;
        this.password=builder.password;
        this.faculty=builder.faculty;
    }
    public void setIndex (int index){
        this.index = index;
    }

    public void setFirstName (String firstName){
        this.firstName = firstName;
    }

    public void setSecondName (String secondName){
        this.secondName = secondName;
    }

    public void setAddress (String address){
        this.address = address;
    }

    public void setAge (int age){
        this.age = age;
    }

    public void setScholarship (int scholarship){
        this.scholarship = scholarship;
    }

    public String getPassword (){
        return password;
    }

    public void setFaculty (Faculty faculty){
        this.faculty = faculty;
    }

    public Faculty getFaculty (){
        return faculty;
    }

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student student = (Student) o;
        return index == student.index && age == student.age && scholarship == student.scholarship && Objects.equals(firstName, student.firstName) && Objects.equals(secondName, student.secondName) && Objects.equals(address, student.address) && Objects.equals(password, student.password) && Objects.equals(faculty, student.faculty);
    }

    @Override
    public String toString (){
        return "Student{" + "index=" + index + ", firstName='" + firstName + '\'' + ", secondName='" + secondName + '\'' + ", address='" + address + '\'' + ", password='" + password + '\'' + ", faculty='" + faculty + '\'' + ", age=" + age + ", scholarship=" + scholarship + '}';
    }

    public static class StudentBuilder{
        int index;
        private String firstName;
        private String secondName;
        private String address;
        private String password;
        private Faculty faculty;
        int age;
        int scholarship;

        public StudentBuilder(int index, String firstName, String secondName, String password){
            this.index=index;
            this.firstName=firstName;
            this.secondName=secondName;
            this.password=password;
        }
        public StudentBuilder setScholarship(int scholarship){
            this.scholarship=scholarship;
            return this;
        }
        public StudentBuilder setAddres(String address){
            this.address=address;
            return this;
        }
        public StudentBuilder setAge(int age){
            this.age=age;
            return this;
        }
        public StudentBuilder setFaculty (Faculty faculty){
            this.faculty = faculty;
            return this;
        }

        public Student build (){
            return new Student(this);
        }
    }
    public enum Faculty{
        MANAGMENT, COMPUTER_SCIENCE, MECHANICAL_ENGINEERING, ELECTRICAL_ENGINEERING;
    }
}
