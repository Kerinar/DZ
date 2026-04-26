package DZ_3.Strategy;

public class Strateg {
    private Strategy strategy;

    public Strateg(){
        strategy = new StrategyOne();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
