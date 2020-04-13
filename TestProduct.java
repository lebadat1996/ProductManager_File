package Product;

import Students.Students;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class TestProduct {
    public static void main(String[] args) {
        System.out.print("*****Product Manager*****\n");
        System.out.print("1. Enter InFor Product\n");
        System.out.print("2. Show InFor Product\n");
        System.out.print("3. Add Product\n");
        System.out.print("4. Find Product\n");
        System.out.print("5. Edit Product\n");
        System.out.print("6. remove Product\n");
        System.out.print("7. Sort Product\n");
        System.out.print("8. Writer Information Product to File\n");
        System.out.print("9. Exit Bye Bye!!!\n");
        Scanner scanner = new Scanner(System.in);
        List<Product> listProduct = new ArrayList<Product>();
        int choose;
        do {
            System.out.println("Enter choose: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    EnterInfo(scanner, listProduct);
                    break;
                case 2:
                    ShowInfo(listProduct);
                    break;
                case 3:
                    AddProduct(listProduct);
                    break;
                case 4:
                    FindProduct(scanner, listProduct);
                    break;
                case 5:
                    scanner.nextLine();
                    EditInForProduct(scanner, listProduct);
                    break;
                case 6:
                    removeProduct(scanner, listProduct);
                    break;
                case 7:
                     Collections.sort(listProduct);
                    break;
                case 8:
                    WriterProduct(listProduct);
                    ReadProduct(listProduct);
                    break;
                default:
                    System.out.print("Ban da nhap sai");
                    break;
            }
        } while (choose != 10);

    }

    private static void removeProduct(Scanner scanner, List<Product> listProduct) {
        Product product = null;
        System.out.print("Enter ID remove: ");
        int id = scanner.nextInt();
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getId()) {
                product = listProduct.get(i);
                break;
            }
        }
        if (product != null) {
            listProduct.remove(product);
        }
        return;
    }


    private static void WriterProduct(List<Product> listProduct) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Hello1.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listProduct);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReadProduct(List<Product> listProduct) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Hello1.txt");
            ois = new ObjectInputStream(fis);
//            Product product = new Product();
//            product = (Product)ois.readObject();
//            System.out.print(product);
            Object obj = null;
            obj = ois.readObject();
            System.out.print(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void EditInForProduct(Scanner scanner, List<Product> listProduct) {
        System.out.print("Edit Product\n");
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.equals(listProduct.get(i).getProductName())) {
                System.out.print("Enter name Edit: ");
                String nameEdit = scanner.nextLine();
                listProduct.get(i).setProductName(nameEdit);
                System.out.print("Enter ID edit: ");
                int id = Integer.parseInt(scanner.nextLine());
                listProduct.get(i).setId(id);
                System.out.print("Enter ProductCode edit: ");
                String code = scanner.nextLine();
                listProduct.get(i).setProductCode(code);
                System.out.print("Enter ProductPrice edit: ");
                float price = Float.parseFloat(scanner.nextLine());
                listProduct.get(i).setPrice(price);
                break;
            }
        }
    }

    private static void FindProduct(Scanner scanner, List<Product> listProduct) {
        System.out.print("Find Product\n");
        System.out.print("Enter the ID to search: ");
        int id = scanner.nextInt();
        for (int i = 0; i < listProduct.size(); i++) {

            if (id == listProduct.get(i).getId()) {
                listProduct.get(i).ShowProduct();
            } else {
                System.out.print("No find Product");
            }
        }
    }

    private static void AddProduct(List<Product> listProduct) {
        System.out.print("Add Product!!!\n");
        Product product = new Product();
        product.EnterProduct();
        listProduct.add(product);
    }

    private static void ShowInfo(List<Product> listProduct) {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s",
                "ID", "ProductCode", "productName", "Manufacturer", "Price");
        System.out.println();
        for (Product product1 : listProduct) {
            product1.ShowProduct();
        }
    }

    private static void EnterInfo(Scanner scanner, List<Product> listProduct) {
        System.out.print("Enter the product number: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.EnterProduct();
            listProduct.add(product);
        }
    }
}