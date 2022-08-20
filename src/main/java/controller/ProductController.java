package controller;

import java.util.List;
import model.Product;
import model.dao.ProductDAO;
import model.exceptions.ProductException;

public class ProductController {

    private ProductDAO repository;

    public ProductController() {
        repository = new ProductDAO();
    }

    public boolean registrateProduct(String id, String name, String cost, String price, String quantity, String unity, String barCode) {
        Product newProduct = validation(id, name, cost, price, quantity, unity, barCode);

        if (repository.findById(Integer.parseInt(id)) == null) {
            return repository.save(newProduct);
        } else {
            throw new ProductException("Error - There is a product with this id already!");
        }
    }

    public void updateProduct(String originalId, String id, String name, String cost, String price, String quantity, String unity, String barCode) {

        Product newProduct = validation(id, name, cost, price, quantity, unity, barCode);
        repository.update(Integer.parseInt(originalId), newProduct);
    }

    public Product searchProduct(int id) {
        return this.repository.findById(id);
    }

    public List<Product> displayProducts() {
        return this.repository.findAll();
    }

    public void deleteProduct(int id) {
        Product prod = repository.findById(id);
        if (prod != null) {
            repository.delete(prod);
        } else {
            throw new ProductException("Error - There is no such product.");
        }
    }

    public String printProductList() {
        String list = "";

        for (Product p : this.repository.findAll()) {
            list = list + p.toString();
        }

        return list;
    }

    private Product validation(String id, String name, String cost, String price, String quantity, String unity, String barCode) {

        Product p = new Product();

        if (id.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Id'.");
        }
        p.setId(Integer.parseInt(id));

        if (name.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Name'.");
        }
        p.setName(name);

        if (cost.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Cost'.");
        }
        p.setCost(Float.parseFloat(cost));

        if (price.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Price'.");
        }
        p.setPrice(Float.parseFloat(price));

        if (quantity.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Quantity'.");
        }
        p.setQuantity(Float.parseFloat(quantity));

        if (unity.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Unity'.");
        }
        p.setUnity(unity);

        if (barCode.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Bar Code'.");
        }
        p.setBarCode(barCode);

        return p;
    }

}
