package DZ_3.Chain;

public class Handler3 implements Handler{
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.CRITICAL) {
            System.out.println("Level 3 Support handled the request.");
        } else {
            System.out.println("Request cannot be handled.");
        }
    }

    public void setNextHandler(Handler nextHandler) {
        // No next handler for Level 3
    }
}
