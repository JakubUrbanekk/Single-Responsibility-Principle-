public class UserBannedMidddleware extends Middleware{

        public boolean check(Student student, String password) {
            if (server.isBanned(student)) {
                System.out.println("You are banned from service!");
                return false;
            }
                System.out.println("You are not banned from service");
            return checkNext(student, password);
        }
}
