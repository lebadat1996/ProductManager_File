package Product;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable, Comparable<Product> {
    private int id;
    private String productCode;
    private String productName;
    private String Manufacturer;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product() {

    }

    public Product(int id, String productCode, String productName, String Manufacturer, float price) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.Manufacturer = Manufacturer;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void EnterProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        this.id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter productCode: ");
        this.productCode = scanner.nextLine();
        System.out.print("Enter productName: ");
        this.productName = scanner.nextLine();
        System.out.print("Enter Manufacturer: ");
        this.Manufacturer = scanner.nextLine();
        System.out.print("Enter price: ");
        this.price = Float.parseFloat(scanner.nextLine());
    }

    public void ShowProduct() {
        System.out.printf("%-15d %-15s %-15s %-15s %-15.2f",
                this.id, this.productCode, this.productName, this.Manufacturer, this.price);
        System.out.println();
    }

    @Override
    public String toString() {
        return " ID: " + this.id + "  ProductCode: " + this.productCode + " ProductName: " + this.productName +
                "  ProductManufacturer: " + this.Manufacturer + "  Price: " + this.price + "\n";
    }

    @Override
    public int compareTo(Product o) {
        if (this.id == o.id)
            return this.productName.compareTo(o.productName);
        return (int) (this.id - o.id);
    }
}
