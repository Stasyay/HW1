package Homework6;

public class Notebook {
    private String brand = ""; 
    private String color = "";
    private Boolean os = false;
    private int ram = 0;
    private int hdd = 0;
    private int diagonal = 0;
    private int price = 0;


    public Notebook(String brand, String color, Boolean os, int ram, int hdd, int diagonal, int price){
        this.brand = brand;
        this.color = color;
        this.os = os;
        this.ram = ram;
        this.hdd = hdd;
        this.diagonal = diagonal;
        this.price = price;
    
    }

    public void set_brand(String brand){
        this.brand = brand;
    }

    public void set_color(String color){
        this.color = color;
    }

    public void set_os(Boolean os){
        this.os = os;
    }

    public void set_ram(int ram){
        this.ram = ram;
    }

    public void set_hdd(int hdd){
        this.hdd = hdd;
    }

    public void set_diagonal(int diagonal){
        this.diagonal = diagonal;
    }

    public void set_price(int price){
        this.price = price;
    }

    public String get_color() {
        return color;
    }

    public Boolean get_os() {
        return os;
    }

    public int get_ram() {
        return ram;
    }

    public int get_hdd() {
        return hdd;
    }

    public int get_diagonal(){
        return diagonal;
    }
        
    public int get_price(){
        return price;
    }


    @Override
    public String toString(){
        String out_print = String.format("Цена: %d Бренд: %s цвет: %s ОС: %s RAM: %d HDD: %d диагональ: %d ",
        price, brand, color, os, ram, hdd, diagonal);
        return out_print; 
    }


}

