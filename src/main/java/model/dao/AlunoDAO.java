package model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import model.exceptions.AlunoException;
import view.FrAluno;

public class AlunoDAO extends DAO {

    private List<Aluno> lstAluno;

    public AlunoDAO() {
        super("ListagemAlunos.csv");
        this.lstAluno = new ArrayList<>();
    }

    public boolean save(Aluno aluno) {
        this.lstAluno.add(aluno);

        String texto = this.lstAlunoToCSV();
        super.save(texto);
        return true;
    }

    public Aluno findByMatricula(String matricula) {

        for (Aluno a : this.lstAluno) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }

        return null;
    }

    public Object find(Object obj) {
        Aluno aluno = (Aluno) obj;

        for (Aluno a : this.lstAluno) {
            if (a.equals(aluno)) {
                return a;
            }
        }

        return null;
    }

    @Override
    public boolean delete(Object obj) {

        Aluno aluno = (Aluno) obj;
        for (int i = 0; i < this.lstAluno.size(); i++) {
            Aluno a = this.lstAluno.get(i);
            if (a.getMatricula().equals(aluno.getMatricula())) {
                this.lstAluno.remove(i);

                String texto = this.lstAlunoToCSV();
                super.save(texto);
                return true;
            }
        }

        return false;
    }

    public void update(String matriculaOriginal, Aluno novoAluno) {
        Aluno alunoOriginal = (Aluno) this.findByMatricula(matriculaOriginal);
        if (alunoOriginal == null) {
            throw new AlunoException("Error update - Aluno inexistente.");
        }

        alunoOriginal.copiar(novoAluno);

        String texto = this.lstAlunoToCSV();
        super.save(texto);
    }

    public List<Aluno> findAll() {
        this.lstAluno = loadArquivo();

        if (this.lstAluno == null) {
            return new ArrayList<Aluno>();
        } else {
            return this.lstAluno;
        }
    }

    private String lstAlunoToCSV() {
        String texto = "";
        Aluno a = new Aluno();
        texto = a.cabecalho();

        for (Aluno p : this.lstAluno) {
            texto = texto + p.atributoToCSV();
        }

        return texto;
    }

    private List<Aluno> loadArquivo() {
        FileReader f = null;
        try {
            f = new FileReader(this.pathArquivo);
            Scanner arquivoLido = new Scanner(f);
            arquivoLido.useDelimiter("\n");

            List<Aluno> lista = new ArrayList<>();
            String linhaLida = arquivoLido.next();
            while (arquivoLido.hasNext()) {
                linhaLida = arquivoLido.next();

                Aluno p = new Aluno();
                p.CSVToAtributo(linhaLida);
                lista.add(p);
            }
            return lista;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
