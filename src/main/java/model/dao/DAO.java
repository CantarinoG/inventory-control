package model.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class DAO {

    protected String pathFile;

    public DAO() {
        this.pathFile = "file.csv";
    }

    public DAO(String pathFile) {
        this.pathFile = pathFile;
    }

    public abstract boolean delete(Object obj);

    public abstract Object find(Object obj);

    protected void save(String texto) {
        FileWriter file = null;
        try {
            file = new FileWriter(this.pathFile);
            PrintWriter saveFile = new PrintWriter(file);
            saveFile.print(texto);
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
