package model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Professor;
import model.exceptions.ProfessorException;
import view.FrProfessor;

public class ProfessorDAO extends DAO {

    private List<Professor> lstProfessores;

    public ProfessorDAO() {
        super("ListagemProfessores.csv");
        this.lstProfessores = new ArrayList<>();
    }

    public boolean save(Professor prof) {
        this.lstProfessores.add(prof);

        String texto = this.lstProfessorToCSV();
        super.save(texto);
        return true;
    }

    public Professor findByCpf(String cpf) {

        for (Professor p : this.lstProfessores) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        return null;
    }

    public Object find(Object obj) {
        Professor prof = (Professor) obj;

        for (Professor p : this.lstProfessores) {
            if (p.equals(prof)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public boolean delete(Object obj) {

        Professor prof = (Professor) obj;
        for (int i = 0; i < this.lstProfessores.size(); i++) {
            Professor p = this.lstProfessores.get(i);
            if (p.getCpf().equals(prof.getCpf())) {
                this.lstProfessores.remove(i);

                String texto = this.lstProfessorToCSV();
                super.save(texto);
                return true;
            }
        }

        return false;
    }

    public void update(String cpfOriginal, Professor novoProfessor) {
        Professor professorOriginal = (Professor) this.findByCpf(cpfOriginal);
        if (professorOriginal == null) {
            throw new ProfessorException("Error update - Professor inexistente.");
        }

        professorOriginal.copiar(novoProfessor);

        String texto = this.lstProfessorToCSV();
        super.save(texto);
    }

    public List<Professor> findAll() {
        this.lstProfessores = loadArquivo();

        if (this.lstProfessores == null) {
            return new ArrayList<Professor>();
        } else {
            return this.lstProfessores;
        }
    }

    private String lstProfessorToCSV() {
        String texto = "";
        Professor a = new Professor();
        texto = a.cabecalho();

        for (Professor p : this.lstProfessores) {
            texto = texto + p.atributoToCSV();
        }

        return texto;
    }

    private List<Professor> loadArquivo() {
        FileReader f = null;
        try {
            f = new FileReader(this.pathArquivo);
            Scanner arquivoLido = new Scanner(f);
            arquivoLido.useDelimiter("\n");

            List<Professor> lista = new ArrayList<>();
            String linhaLida = arquivoLido.next();
            while (arquivoLido.hasNext()) {
                linhaLida = arquivoLido.next();

                Professor p = new Professor();
                p.CSVToAtributo(linhaLida);
                lista.add(p);
            }
            return lista;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
