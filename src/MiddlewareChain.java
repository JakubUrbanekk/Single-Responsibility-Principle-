public class MiddlewareChain{

    private Middleware server;

    public MiddlewareChain (Middleware server){
        // initialize the chain
        this.server = server;
        Middleware.setServer(server);
        Middleware userExists = new UserExistsMiddleware();
        Middleware userBanned = new UserBannedMidddleware();
        Middleware userRole = new UserFacultyMiddleware();

        server.linkWith(userExists);
        userExists.linkWith(userBanned);
        userBanned.linkWith(userRole);
    }
}
