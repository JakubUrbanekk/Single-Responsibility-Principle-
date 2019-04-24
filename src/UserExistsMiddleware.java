public class UserExistsMiddleware extends Middleware {

    public boolean check(Student student, String password) {
        if (!server.hasLogin(student)) {
            System.out.println("This student is not registered!");
            return false;
        }
        if (!server.isValidPassword(student, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        System.out.println("UserName and password are correct");
        return checkNext(student, password);
    }
}