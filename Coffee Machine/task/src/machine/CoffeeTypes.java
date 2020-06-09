package machine;

public enum CoffeeTypes {
    ESPRESSO(250,16,4,0),
    LATTE(350,20,7,75),
    CAPPUCCINO(200,12,6,100);

    int water;
    int AmntOfCoffeeBeans;
    int price;
    int milkVol;


    CoffeeTypes(int water,int beans, int price, int milkVol ) {
        this.water = water;
        this.AmntOfCoffeeBeans = beans;
        this.price = price;
        this.milkVol = milkVol;
    }
}
