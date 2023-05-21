package telusko.challenge;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    List<Products> products = new ArrayList();

    public void addProduct(Products p){
        products.add(p);
    }

    public List<Products> getAllProducts(){
        return products;
    }

    public Products getProduct(String name) {
        for (Products p : products) {
            if (p.getName().equals(name)) {
                System.out.println(p);
            }

        }
        return null;
    }

    public List<Products> getProductWithText(String t) {
        List<Products> prods = new ArrayList();
        t =t.toLowerCase();

        for (Products p : products) {
            String n = p.getName().toLowerCase();
            String ty = p.getType().toLowerCase();
            String pl = p.getPlace().toLowerCase();

            if (n.contains(t) || ty.contains(t) ||pl.contains(t)) {
                prods.add(p);
            }
        }

        return prods;
    }

    //This method will return all the details of products that have the location which you gave
    public List<Products> getProductWithPlace(String pl){
    List<Products> prods = new ArrayList();
        pl = pl.toLowerCase();

        for(Products p : products){
            String place = p.getPlace().toLowerCase();

            if(place.contains(pl)){
                prods.add(p);
            }
        }

        return prods;
    }

    //This method will return all the details of the products which have warranty greater than what you gave as input
    public List<Products> getProuctsOutofWarranty(int w) {
        List<Products> prods = new ArrayList();
        for (Products p : products) {
            if (p.getWarranty() > w) {
                prods.add(p);
            }
        }
        return prods;
    }

    //This method will give you all the product details by giving input as warranty
    public List<Products> getProductsbyWarranty(int w){
        List<Products> prods = new ArrayList();
        for(Products p : products){
            if(p.getWarranty() == w){
                prods.add(p);
            }
        }
        return prods;
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

    public List<Products> getallProducts() {
        return products.stream()
                .collect(Collectors.toList());
    }

    public List<Products> getProducts(String name){
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Products> getProductswithText(String t) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(t.toLowerCase()) || p.getType().toLowerCase().contains(t.toLowerCase()) || p.getPlace().toLowerCase().contains(t.toLowerCase()))
                .collect(Collectors.toList());
    }




}
