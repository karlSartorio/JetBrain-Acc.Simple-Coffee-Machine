import java.util.Scanner;

public class CoffeeMachine4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        coffeeMachineClass machine = new coffeeMachineClass(400, 540, 120, 9, 550);

        // logic menu logic.
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String mainMenu = scanner.next();
            if (mainMenu.toLowerCase().equals("exit")) {
                // exit the loop option, if the user type exit removes from the loop.
                System.out.println("Thank you!");
                break;

            } else if (mainMenu.toLowerCase().equals("buy")) {
                //buy option, allow the user to make one purchase of coffee .
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String buyMenu = scanner.next();

                switch(buyMenu.toLowerCase()) {
                    case "1":
                        machine.makeEspresso();
                        break;
                    case "2":
                        machine.makeLatte();
                        break;
                    case "3":
                        machine.makeCappuccino();
                        break;
                    case "back":
                        break;
                    default:
                        System.out.println("invalid Option. Try again.");
                        break;
                }

            } else if (mainMenu.toLowerCase().equals("fill")) {
                // option to fill the machine with the needed supplies.
                // these parameter are inputted in the class method after.
                System.out.println("Write how many ml of water you want to add: ");
                String fillWater = scanner.next();

                System.out.println("Write how many ml of milk you want to add: ");
                String fillMilk = scanner.next();


                System.out.println("Write how many grams of coffee beans you want to add: ");
                String coffeeBeans = scanner.next();

                System.out.println("Write how many disposable cups of coffee you want to add: ");
                String fillDisCups = scanner.next();

                System.out.println("Quantity of goods added to the machine.");
                machine.fill(fillWater, fillMilk, coffeeBeans, fillDisCups);

            } else if (mainMenu.toLowerCase().equals("take")) {
                machine.take();

            } else if (mainMenu.toLowerCase().equals("remaining")) {
                machine.remaining();

            } else {
                System.out.println("error! invalid input");
            }
        }
    }
}


class coffeeMachineClass {
    //fields
    int water;
    int milk;
    int coffeeBeans;
    int disposableCups;
    int cash;

    public coffeeMachineClass(int water, int milk, int coffeeBeans, int disposeableCups, int cash) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposeableCups;
        this.cash = cash;
    }

    public void makeEspresso() {
        // create the a cup of a coffee, reducing the suppplies depending by an amount.
        // if unable to create, return which ingredient is lacking.
        if (this.water >= 250 && this.coffeeBeans >= 16 && this.disposableCups != 0) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 250;
            this.coffeeBeans -= 16;
            this.disposableCups -= 1;
            this.cash += 4;
        } else if (this.water < 250) {
        System.out.println("Sorry, not enough water!");
        } else if (this.coffeeBeans < 16) {
            System.out.println("Sorry, not enough Coffee Beans!");
        } else {
            System.out.println("Sorry, not enough DisposableCups");
        }
    }

    public void makeLatte() {
        // create the a cup of a coffee, reducing the suppplies depending by an amount.
        // if unable to create, return which ingredient is lacking.
        if (this.water >= 350 && this.milk >= 75 && this.coffeeBeans >= 20 && this.disposableCups != 0) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 350;
            this.milk -= 75;
            this.coffeeBeans -= 20;
            this.disposableCups -= 1;
            this.cash += 7;
        } else if (this.water < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < 70) {
            System.out.println("Sorry, not enough milk!");
        }else if (this.coffeeBeans < 20) {
            System.out.println("Sorry, not enough Coffee Beans!");
        } else {
            System.out.println("Sorry, not enough DisposableCups");
        }
    }

    public void makeCappuccino() {
        // create the a cup of a coffee, reducing the suppplies depending by an amount.
        // if unable to create, return which ingredient is lacking.
        if (this.water >= 200 && this.milk >= 100 && this.coffeeBeans >= 12 && this.disposableCups != 0) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 200;
            this.milk -= 100;
            this.coffeeBeans -= 12;
            this.disposableCups -= 1;
            this.cash += 6;
        } else if (this.water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < 100) {
            System.out.println("Sorry, not enough milk!");
        }else if (this.coffeeBeans < 12) {
            System.out.println("Sorry, not enough Coffee Beans!");
        } else {
            System.out.println("Sorry, not enough DisposableCups");
        }
    }

    public void fill(String fillWater, String fillMilk, String fillCofBean, String fillDisCups) {
        // "fill"/ increase the suppplies the machine needs to create coffee by a the given amount the user inputted.
        this.water += Integer.parseInt(fillWater);
        this.milk += Integer.parseInt(fillMilk);
        this.coffeeBeans += Integer.parseInt(fillCofBean);
        this.disposableCups += Integer.parseInt(fillDisCups);
    }

    public void remaining() {
        // Print the current objects fields

        System.out.println("The coffee machine has:\n" +  this.water + " ml of water\n" + this.milk + " ml of milk");
        System.out.println(this.coffeeBeans + " g of coffee beans\n" + this.disposableCups + " disposable cups");
        System.out.println("$" + this.cash + " of money\n");
    }
    public void take() {
        // giving the "owner" all the cash the machine object currently have, after doing so make the cash object as 0.
        System.out.println("I give you $" + this.cash);
        this.cash -= this.cash;
    }
}
