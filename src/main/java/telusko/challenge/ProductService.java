package telusko.challenge;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    List<Products> products = new ArrayList();
    ProductDB db = new ProductDB();

    public void addProduct(Products p) throws SQLException {
        db.save(p);
    }

    public List<Products> getAllProducts() throws SQLException {
        List<Products> all_products = db.getAll();
        return all_products;
    }


    public List<Products> getProductWithText(String t) {
        List<Products> products_by_text = db.getProdByText(t);
        return products_by_text;
    }

    //This method will return all the details of products that have the location which you gave
    public List<Products> getProductWithPlace(String pl) {
        List<Products> products_by_place = db.getProdByPlace(pl);
        return products_by_place;
    }

    //This method will return all the details of the products which have warranty greater than what you gave as input
    public List<Products> getProuctsOutofWarranty(int w) {
        List<Products> product_out_of_warranty = db.getProdOutOfWarranty(w);
        return product_out_of_warranty;
    }

    //This method will give you all the product details by giving input as warranty
    public List<Products> getProductsbyWarranty(int w) {
        List<Products> products_by_warranty = db.getProdByWarranty(w);
        return products_by_warranty;
    }


    //Assignment
    public List<Products> getProductsOutOfWarranty(int w) {
        return products.stream()
                .filter(p -> p.getWarranty() > w)
                .collect(Collectors.toList());
    }

    public List<Products> getProductsByWarranty(int w) {
        return products.stream()
                .filter(p -> p.getWarranty() == w)
                .collect(Collectors.toList());
    }

    public List<Products> getProductswithPlace(String pl) {
        return products.stream()
                .filter(p -> p.getPlace().toLowerCase().contains(pl.toLowerCase()))
                .collect(Collectors.toList());
    }
}
