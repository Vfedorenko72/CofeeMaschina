package coffeemachine;

public class Making {



    public String espresso(int q) {
        int quantityCoffee = q * 10;
        int quantityWater = q * 40;


       /* if (coffee < quantityCoffee) {
            вап
        }
        coffee -= quantityCoffee;
        water -= quantityWater;

        if (coffee < 0 || water < 0) {
            return "Не получилось";
        } else {
            return "Вот ваш кофе";
        }*/
    }


    public void checkCoffee() {
        System.out.println("ОСТАТОК\nБокс для кофе: " + coffee);
    }

    public void checkWater() {
        System.out.println("ОСТАТОК\nЕмкомть для воды: " + water);
    }

    public void checkMilk() {
        System.out.println("ОСТАТОК\nЕмкомть для молока: " + milk);
    }


    public String checkAll() {
        return "ОСТАТОК\nБокс для кофе: " + coffee + "\n" + "ОСТАТОК\nЕмкомть для воды: " + water + "\n" + "ОСТАТОК\nЕмкомть для молока: " + milk;
    }

}
