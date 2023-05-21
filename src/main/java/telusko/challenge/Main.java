package telusko.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        ProductService ps = new ProductService();
        ps.addProduct(new Products("Asus", "Laptop", "Black Table", 2));
        ps.addProduct(new Products("Samsung", "Phone", "Brown Table", 5));
        ps.addProduct(new Products("HP", "Laptop", "White Table", 3));
        ps.addProduct(new Products("Apple", "Phone", "Red Table", 1));
        ps.addProduct(new Products("Dell", "Laptop", "Blue Table", 4));

        //This method will return all the details of the all the Products that are there in list
        List<Products> products = ps.getAllProducts();
        products.forEach(System.out::println);

        //This method will return all the details of the Product if you give the name of it
        ps.getProduct("Asus");

        ps.getProductWithText("black");

        ps.getProductWithPlace("Blue Table");

        ps.getProuctOutofWarranty(3);






    }

}
