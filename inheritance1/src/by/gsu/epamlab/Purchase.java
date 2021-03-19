package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase{
    private String name;
    private int price;
    private int number;

    public Purchase(String name, int price, int number){
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(){
        this(null, 0, 0);
    }

    public Purchase(Scanner sc) {
        name = sc.next();
        price = sc.nextInt();
        number = sc.nextInt();
    }

    public Byn getCost(){
        return new Byn(price * number);
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + number + ";" + getCost();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Purchase purchase = (Purchase) object;
        return price == purchase.price;
    }
}
