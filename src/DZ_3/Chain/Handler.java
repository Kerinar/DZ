package DZ_3.Chain;

public interface Handler {
    void handleRequest(Request request);
    void setNextHandler(Handler nextHandler);
}
