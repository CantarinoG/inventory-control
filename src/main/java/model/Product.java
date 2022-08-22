package model;

public class Product {

    private int id;
    private String name;
    private float cost;
    private float price;
    private float quantity;
    private String unit;
    private String barCode;

    public Product() {
        this.id = -1;
        this.name = " ";
        this.cost = 0;
        this.price = 0;
        this.quantity = 0;
        this.unit = "un";
        this.barCode = "00000000000000";
    }

    @Override
    public String toString() { //Returns a String containing all informations about the product
        String txt
                = "---------- Product -----------\n";
        txt += "ID: " + this.id + "\n";
        txt += "Name: " + this.name + "\n";
        txt += "Cost: " + this.cost + "\n";
        txt += "Price: " + this.price + "\n";
        txt += "Quantity: " + this.quantity + "\n";
        txt += "Unit: " + this.unit + "\n";
        txt += "Bar Code: " + this.barCode + "\n"
                + "-------------------------------------\n";
        return txt;
    }

    public void copy(Product other) {
        this.id = other.getId();
        this.name = other.getName();
        this.cost = other.getCost();
        this.price = other.getPrice();
        this.quantity = other.getQuantity();
        this.unit = other.getUnit();
        this.barCode = other.getBarCode();
    }

    public String header() {
        return "PrimaryCode;Name;Cost;Price;Quantity;Unit;BarCode\n";
    }

    public String attributeToCSV() {
        return this.id + ";" + this.name + ";" + this.cost + ";" + this.price + ";" + this.quantity + ";" + this.unit + ";" + this.barCode + "\n";
    }

    public void CSVToAttribute(String csv) {
        String array[] = csv.split(";");

        this.id = Integer.parseInt(array[0]);
        this.name = array[1];
        this.cost = Float.parseFloat(array[2]);
        this.price = Float.parseFloat(array[3]);
        this.quantity = Float.parseFloat(array[4]);
        this.unit = array[5];
        this.barCode = array[6];
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getCost() {
        return this.cost;
    }

    public float getPrice() {
        return this.price;
    }

    public float getQuantity() {
        return this.quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public void setId(int priCode) {
        this.id = priCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

}
