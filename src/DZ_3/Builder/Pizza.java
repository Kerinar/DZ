package DZ_3.Builder;

public class Pizza {
    private String topping1;
    private String topping2;
    private String topping3;

    public Pizza(PizzaBuilder pizzaBuilder){
        this.topping1 = pizzaBuilder.topping1;
        this.topping2 = pizzaBuilder.topping2;
        this.topping3 = pizzaBuilder.topping3;
    }


    //Билдер
    public static class PizzaBuilder{
        private String topping1;
        private String topping2;
        private String topping3;

        public PizzaBuilder setTopping1(String topping1){
            this.topping1 = topping1;
            return this;
        }

        public PizzaBuilder setTopping2(String topping2){
            this.topping2 = topping2;
            return this;
        }

        public PizzaBuilder setTopping3(String topping3){
            this.topping3 = topping3;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }
}
