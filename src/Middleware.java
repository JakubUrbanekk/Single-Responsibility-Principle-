public abstract class Middleware{
    private Middleware next;
    protected static Middleware server;


    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public static void setServer (Middleware server){
        Middleware.server = server;
    }

    public abstract boolean check(Student student, String password);
    protected boolean checkNext(Student student, String password) {
        return next.check(student, password);
    }

    public boolean hasLogin (Student student){
        return Middleware.server.hasLogin(student);
    }

    public boolean isValidPassword (Student student, String password){
        return Middleware.server.isValidPassword(student,password);
    }

    public boolean isBanned (Student student){
        return Middleware.server.isBanned(student);
    }

    public Student.Faculty hasFaculty (Student student){
        return Middleware.server.hasFaculty(student);
    }
}
