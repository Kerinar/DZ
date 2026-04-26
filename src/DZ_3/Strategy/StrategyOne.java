package DZ_3.Strategy;

public class StrategyOne implements Strategy{
    @Override
    public void doSomething() {
        IO.println("StrategyOne");
    }
}
