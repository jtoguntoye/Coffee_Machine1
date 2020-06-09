package machine;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class CoffeeMachine {

    private static int amountOfWater = 400;
    private static int milkVol = 540;
    private static int coffeeBeans = 120;
    private static int moneyInTray = 550;
    private static int numOfCups = 9;

    public static void main(String[] args) {
        String action;
        //printMachineState();
        Scanner  scanner = new Scanner(System.in);

        do{
        System.out.println("Write action (buy, fill, take, remaining, exit) :");
            action = scanner.nextLine();
            switch (action) {
            case "buy" :
                buyAction();
                break;
            case "fill" :
                fillAction();
                break;
            case "take":
                takeAction();
                break;
            case "remaining":
                printMachineState();
                break;
                case "exit":
                    break;

        }
        } while (!action.equals("exit"));

    }

    private static void takeAction() {
        System.out.println("I gave you " + "$" +moneyInTray);
        moneyInTray =0;

    }

    private static void fillAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int addedWater =  scanner.nextInt();
        scanner.skip("\\R");
        amountOfWater += addedWater;
        System.out.println("Write how many ml of milk do you want to add:");
        int addedMilk = scanner.nextInt();
        milkVol += addedMilk;

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addedBeans = scanner.nextInt();
        coffeeBeans += addedBeans;

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addedCup = scanner.nextInt();
        numOfCups += addedCup;


    }

    private static void buyAction() {
        System.out.println("What do you want to buy? 1-espresso, 2- latte, 3- cappuccino, back - to main menu:");
        Scanner sc = new Scanner(System.in);
        String coffeeChoice = sc.nextLine();

        if ( coffeeChoice.equals("1") ) {
            if(amountOfWater >= 250 && coffeeBeans >=16 && numOfCups >=1 ) {
                System.out.println("I have enough resources, making you a coffee!");
             amountOfWater-=250;
            coffeeBeans -=16;
            moneyInTray +=4;
            numOfCups -= 1;
            }
            else {
                if(amountOfWater <250 ) {
                    System.out.println("Sorry, not enough water!");
                }
                else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if (numOfCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }

            }

        }
        if ( coffeeChoice.equals("2") ) {
            if (amountOfWater >= 350 && milkVol > 75 && coffeeBeans >= 20 && numOfCups >= 1) {
                System.out.println("I have enough resources, making you a coffee!");
                amountOfWater -=350;
                numOfCups -=1;
                milkVol -=75;
                coffeeBeans -=20;
                moneyInTray += 7;
            }
            else {
                if(amountOfWater <350 ) {
                    System.out.println("Sorry, not enough water!");
                }
                else if (milkVol < 75){
                    System.out.println("Sorry, not enough milk!");
                }
                else if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if (numOfCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }

            }


        }
        if(coffeeChoice.equals("3") ) {
           if (amountOfWater >= 200 && milkVol > 100 && coffeeBeans >= 12 && numOfCups >= 1){
               System.out.println("I have enough resources, making you a coffee!");
            amountOfWater -= 200;
            milkVol -= 100;
            numOfCups -= 1;
            coffeeBeans -= 12;
            moneyInTray += 6;
           }
           else {
               if(amountOfWater <200 ) {
                   System.out.println("Sorry, not enough water!");
               }
               else if (milkVol < 100){
                   System.out.println("Sorry, not enough milk!");
               }
               else if (coffeeBeans < 12) {
                   System.out.println("Sorry, not enough coffee beans!");
               }
               else if (numOfCups < 1) {
                   System.out.println("Sorry, not enough disposable cups!");
               }
           }

        }
       // printMachineState();
    }

    static void printMachineState(){
        System.out.println("The coffee machine has:" +"\n"
        + amountOfWater + " of water" + "\n"
        + milkVol + " of milk" + "\n"
        + coffeeBeans + " of coffee beans" + "\n"
         + moneyInTray + " of money" + "\n"
        + numOfCups + " of disposable cups" +"\n"
       );
    }





    static void canMakeCoffee(){
        System.out.println("Write how many ml of water the coffee machine has:");
        int Water = new Scanner(System.in).nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int Milk = new Scanner(System.in).nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int CoffeeBeans = new Scanner(System.in).nextInt();

        System.out.println("Write how many cups of coffee you will need");
        int numOfCups = new Scanner(System.in).nextInt();

            Water /= 200;
            Milk /= 50;
            CoffeeBeans /= 15;

            int min = Math.min(Water,Milk);
            min = Math.min(CoffeeBeans, min);

            if(numOfCups == min) {
                System.out.println("Yes, I can make that amount of coffee");
            } else if (numOfCups < min) {
                System.out.println("Yes, I can make that amount of coffee (and even " +
                        (min - numOfCups) + " more than that)");
            } else {
                System.out.println("No, I can make only " + min + " cup(s) of coffee");

            }
        }
}
