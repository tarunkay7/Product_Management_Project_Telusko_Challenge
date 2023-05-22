package telusko.challenge;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        int choice;
        ProductService ps = new ProductService();
        do{
        System.out.println("++++Welcome to the Product Database++++");
        System.out.println("Choose from any Options below: ");
        System.out.println("1. Add a Product");
        System.out.println("2. Get all Products");
        System.out.println("3. Get Products by Text");
        System.out.println("4. Get Products by Place");
        System.out.println("5. Get Products by Warranty");
        System.out.println("6. Get Products out of Warranty");


        choice = sc.nextInt();

        switch (choice) {
            case '1':
                System.out.println("Enter the Product Name: ");
                String name = sc.next();
                System.out.println("Enter the Product Type: ");
                String type = sc.next();
                System.out.println("Enter the Product Place: ");
                String place = sc.next();
                System.out.println("Enter the Product Warranty: ");
                int warranty = sc.nextInt();
                ps.addProduct(new Products(name, type, place, warranty));
                break;
            case '2':
                ps.getAllProducts();
                break;
            case '3':
                System.out.println("Enter the Product Name: ");
                String t = sc.next();
                ps.getProductWithText(t);
                break;
            case '4':
                System.out.println("Enter the Product Place: ");
                String pl = sc.next();

                ps.getProductWithPlace(pl);
                break;
            case '5':
                System.out.println("Enter the Warranty: ");
                int w = sc.nextInt();
                ps.getProductsByWarranty(w);
                break;
            case '6':
                System.out.println("Enter the Warranty: ");
                int wa = sc.nextInt();

                ps.getProductsOutOfWarranty(wa);
                break;
            default:
                System.out.println("Invalid Choice");

        }
    }while(choice != 0);



        //This method will return all the details of the products from the database
        List<Products> products = ps.getAllProducts();
        System.out.println("All Products: ");
        for (Products p : products) {
            System.out.println(p);
        }

        //This method will return all the details of the products that have the name which you gave
        List<Products> products_by_text = ps.getProductWithText("Apple");
        System.out.println("Products by text: ");
        for (Products p : products_by_text) {
            System.out.println(p);
        }

        //this method will return all the details of products that have the location which you gave
        List<Products> products_by_place = ps.getProductWithPlace("Red Table");
        System.out.println("Products by place: ");
        for (Products p : products_by_place) {
            System.out.println(p);
        }

        //this method will return all the details of the products which have warranty greater than what you gave as input
        List<Products> product_out_of_warranty = ps.getProuctsOutofWarranty(3);
        System.out.println("Products out of warranty: ");
        for (Products p : product_out_of_warranty) {
            System.out.println(p);
        }

        //this method will give you all the product details by giving input as warranty
        List<Products> products_by_warranty = ps.getProductsbyWarranty(3);
        System.out.println("Products by warranty: ");
        for (Products p : products_by_warranty) {
            System.out.println(p);
        }
    }

}
