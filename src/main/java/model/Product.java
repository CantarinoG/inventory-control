package model;

public class Product {

    private int primaryCode;
    private String name;
    private float cost;
    private float price;
    private float quantity;
    private String unity;
    private String barCode;

    public Product() {
        this.primaryCode = -1;
        this.name = " ";
        this.cost = 0;
        this.price = 0;
        this.quantity = 0;
        this.unity = "un";
        this.barCode = "00000000000000";
    }

    @Override
    public String toString() { //Returns a String containing all informations about the product
        String txt
                = "---------- Product -----------\n";
        txt += "Primary Code: " + this.primaryCode + "\n";
        txt += "Name: " + this.name + "\n";
        txt += "Cost: " + this.cost + "\n";
        txt += "Price: " + this.price + "\n";
        txt += "Quantity: " + this.quantity + "\n";
        txt += "Unity: " + this.unity + "\n";
        txt += "Bar Code: " + this.barCode + "\n"
                + "-------------------------------------\n";
        return txt;
    }

    public void copy(Product other) {
        this.primaryCode = other.getPrimaryCode();
        this.name = other.getName();
        this.cost = other.getCost();
        this.price = other.getPrice();
        this.quantity = other.getQuantity();
        this.unity = other.getUnity();
        this.barCode = other.getBarCode();
    }

    public String header() {
        return "PrimaryCode;Name;Cost;Price;Quantity;Unity;BarCode\n";
    }

    public String attributeToCSV() {
        return this.primaryCode + ";" + this.name + ";" + this.cost + ";" + this.price + ";" + this.quantity + ";" + this.unity + ";" + this.barCode + "\n";
    }

    public void CSVToAttribute(String csv) {
        String array[] = csv.split(";");

        this.primaryCode = Integer.parseInt(array[0]);
        this.name = array[1];
        this.cost = Float.parseFloat(array[2]);
        this.price = Float.parseFloat(array[3]);
        this.quantity = Float.parseFloat(array[4]);
        this.unity = array[5];
        this.barCode = array[6];
    }

    public int getPrimaryCode() {
        return this.primaryCode;
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

    public String getUnity() {
        return this.unity;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public void setPrimaryCode(int priCode) {
        this.primaryCode = priCode;
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

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

}
