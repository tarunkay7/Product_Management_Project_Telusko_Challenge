package telusko.challenge;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    Connection conn= null;

    public ProductDB() {
       try{
           conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/telusko", "postgres", "tarun123");

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }


    public void save(Products p) {

        String query = "INSERT INTO product (name, type, place, warranty) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getType());
            stmt.setString(3, p.getPlace());
            stmt.setInt(4, p.getWarranty());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Products> getAll() {
        String query = "SELECT * FROM product";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            List<Products> products = new ArrayList<>();
            while (rs.next()) {
                Products p = new Products();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Products> getProdByText(String t) {
        String query = "SELECT * FROM product WHERE name LIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + t + "%");
            ResultSet rs = stmt.executeQuery();
            List<Products> products = new ArrayList<>();
            while (rs.next()) {
                Products p = new Products();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Products> getProdByPlace(String pl){
        String query = "SELECT * FROM product WHERE place LIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + pl + "%");
            ResultSet rs = stmt.executeQuery();
            List<Products> products = new ArrayList<>();
            while (rs.next()) {
                Products p = new Products();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Products> getProdOutOfWarranty(int w) {
        String query = "SELECT * FROM product WHERE warranty > ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, w);
            ResultSet rs = stmt.executeQuery();
            List<Products> products = new ArrayList<>();
            while (rs.next()) {
                Products p = new Products();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Products> getProdByWarranty(int w) {
        String query = "SELECT * FROM product WHERE warranty = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, w);
            ResultSet rs = stmt.executeQuery();
            List<Products> products = new ArrayList<>();
            while (rs.next()) {
                Products p = new Products();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
