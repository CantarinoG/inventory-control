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

    public boolean registrateProduct(String primaryCode, String name, String cost, String price, String quantity, String unity, String barCode) {
        Product newProduct = validation(primaryCode, name, cost, price, quantity, unity, barCode);

        if (repository.findByPrimaryCode(Integer.parseInt(primaryCode)) == null) {
            return repository.save(newProduct);
        } else {
            throw new ProductException("Error - There is a product with this primary code already!");
        }
    }

    public void updateProduct(String originalPriCode, String primaryCode, String name, String cost, String price, String quantity, String unity, String barCode) {

        Product newProduct = validation(primaryCode, name, cost, price, quantity, unity, barCode);
        repository.update(Integer.parseInt(originalPriCode), newProduct);
    }

    public Product searchProduct(int primaryCode) {
        return this.repository.findByPrimaryCode(primaryCode);
    }

    public List<Product> displayProducts() {
        return this.repository.findAll();
    }

    public void deleteProduct(int priCode) {
        Product prod = repository.findByPrimaryCode(priCode);
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

    private Product validation(String primaryCode, String name, String cost, String price, String quantity, String unity, String barCode) {

        Product p = new Product();

        if (primaryCode.isEmpty()) {
            throw new ProductException("Error - Empty field: 'Primary Code'.");
        }
        p.setPrimaryCode(Integer.parseInt(primaryCode));

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
