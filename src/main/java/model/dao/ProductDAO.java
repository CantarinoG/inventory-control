package model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.exceptions.ProductException;
import view.FrProduct;

public class ProductDAO extends DAO {

    private List<Product> lstProduct;

    public ProductDAO() {
        super("ProductsList.csv");
        this.lstProduct = new ArrayList<>();
    }

    public boolean save(Product prod) {
        this.lstProduct.add(prod);

        String text = this.lstProductToCSV();
        super.save(text);
        return true;
    }

    public Product findById(int id) { //Returns the product with the specified id

        for (Product p : this.lstProduct) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public Object find(Object obj) {
        Product prod = (Product) obj;

        for (Product p : this.lstProduct) {
            if (p.equals(prod)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public boolean delete(Object obj) {

        Product prod = (Product) obj;
        for (int i = 0; i < this.lstProduct.size(); i++) {
            Product p = this.lstProduct.get(i);
            if (p.getId() == prod.getId()) {
                this.lstProduct.remove(i);

                String texto = this.lstProductToCSV();
                super.save(texto);
                return true;
            }
        }

        return false;
    }

    public void update(int originalId, Product newProduct) { //Update product with the original id to newProduct
        Product originalProd = (Product) this.findById(originalId);
        if (originalProd == null) {
            throw new ProductException("Error - Product does not exist.");
        }

        originalProd.copy(newProduct);

        String text = this.lstProductToCSV();
        super.save(text);
    }

    public List<Product> findAll() {
        this.lstProduct = loadFile();

        if (this.lstProduct == null) {
            return new ArrayList<Product>();
        } else {
            return this.lstProduct;
        }
    }

    private String lstProductToCSV() {
        String text = "";
        Product a = new Product();
        text = a.header();

        for (Product p : this.lstProduct) {
            text = text + p.attributeToCSV();
        }

        return text;
    }

    private List<Product> loadFile() {
        FileReader f = null;
        try {
            f = new FileReader(this.pathFile);
            Scanner readFile = new Scanner(f);
            readFile.useDelimiter("\n");

            List<Product> lista = new ArrayList<>();
            String linhaLida = readFile.next();
            while (readFile.hasNext()) {
                linhaLida = readFile.next();

                Product p = new Product();
                p.CSVToAttribute(linhaLida);
                lista.add(p);
            }
            return lista;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
