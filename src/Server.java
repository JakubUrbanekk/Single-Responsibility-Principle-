import java.util.List;

final class Server extends Middleware{
    private List<Student> users;
    private List<Student> bannedUsers;
    String operationSystem;
    String language;
    String adminName;
    MiddlewareChain chain;

    private Server(ServerBuilder builder){
        this.users=builder.users;
        this.bannedUsers=builder.bannedUsers;
        this.operationSystem=builder.operationSystem;
        this.language=builder.language;
        this.adminName=builder.adminName;
        this.chain=new MiddlewareChain(this);
    }

    public boolean check(Student student, String password) {
        if (checkNext(student, password)) {
            System.out.println("Authorization have been successful!");
            return true;
        }
            System.out.println("Authorization failed!");
        return false;
    }

    public void register(Student student) {
        users.add(student);
    }
    public void banUser(Student student){
        bannedUsers.add(student);
    }

    public boolean hasLogin(Student student) {
        return users.contains(student);
    }

    public boolean isValidPassword(Student student, String password) {
        for (Student user:users){
            if (user.equals(student)){
                if (user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isBanned(Student student){
        for (Student user:bannedUsers){
            if(user.equals(student)){
                return true;
            }
        }
        return false;
    }
    public Student.Faculty hasFaculty(Student student){
        return student.getFaculty();
    }

    public void setOperationSystem (String operationSystem){
        this.operationSystem = operationSystem;
    }

    public void setLanguage (String language){
        this.language = language;
    }

    public void setAdminName (String adminName){
        this.adminName = adminName;
    }

    @Override
    public String toString (){
        return "Server{" + "users=" + users + ", bannedUsers=" + bannedUsers + ", operationSystem='" + operationSystem + '\'' + ", language='" + language + '\'' + ", adminName='" + adminName + '\'' + ", chain=" + chain + '}';
    }

    public static class ServerBuilder{
        private List<Student> users;
        private List<Student> bannedUsers;
        String operationSystem;
        String language;
        String adminName;

        public ServerBuilder (List<Student> users, List<Student> bannedUsers){
            this.users = users;
            this.bannedUsers = bannedUsers;
        }

        public ServerBuilder setOperationSystem (String operationSystem){
            this.operationSystem = operationSystem;
            return this;
        }

        public ServerBuilder setLanguage (String language){
            this.language = language;
            return this;
        }
        public ServerBuilder setAdminName(String adminName){
            this.adminName=adminName;
            return this;
        }
        public Server build(){
            return new Server(this);
        }
    }
}
