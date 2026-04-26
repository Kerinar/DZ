package DZ_3.Proxy;

public class HelloProxy implements Hello{
    Hello helloClass = new HelloClass();

    @Override
    public String getHello() {
        return helloClass.getHello() + " World!";
    }
}
