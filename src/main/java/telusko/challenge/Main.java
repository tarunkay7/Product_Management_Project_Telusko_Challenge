package telusko.challenge;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        ProductService ps = new ProductService();
        ps.addProduct(new Products("Asus", "Laptop", "Black Table", 2));
        ps.addProduct(new Products("Samsung", "Phone", "Brown Table", 5));
        ps.addProduct(new Products("HP", "Laptop", "White Table", 3));
        ps.addProduct(new Products("Apple", "Phone", "Red Table", 1));
        ps.addProduct(new Products("Dell", "Laptop", "Blue Table", 4));



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
