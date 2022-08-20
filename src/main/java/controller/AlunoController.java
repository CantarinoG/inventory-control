package controller;

import java.util.List;
import model.Aluno;
import model.dao.AlunoDAO;
import model.exceptions.AlunoException;

public class AlunoController {

    private AlunoDAO repositorio;

    public AlunoController() {
        repositorio = new AlunoDAO();
    }

    public boolean cadastrarAluno(String nome, String sexo, String idade, String matricula, String anoIngresso) {
        Aluno novoAluno = validacaoVazio(nome, sexo, idade, matricula, anoIngresso);

        if (repositorio.findByMatricula(matricula) == null) {
            return repositorio.save(novoAluno);
        } else {
            throw new AlunoException("Error - Já existe um aluno com esta matricula.");
        }
    }

    public void atualizarAluno(String matriculaOriginal, String nome, String sexo, String idade, String matricula, String anoIngresso) {
        Aluno novoAluno = validacaoVazio(nome, sexo, idade, matricula, anoIngresso);
        repositorio.update(matriculaOriginal, novoAluno);
    }

    public Aluno buscarAluno(String matricula) {
        return this.repositorio.findByMatricula(matricula);
    }

    public List<Aluno> listarAlunos() {
        return this.repositorio.findAll();
    }

    public void excluirAlunos(String matricula) {
        Aluno aluno = repositorio.findByMatricula(matricula);
        if (aluno != null) {
            repositorio.delete(aluno);
        } else {
            throw new AlunoException("Error - Aluno inexistente.");
        }
    }

    public String imprimirListaAlunos() {
        String listagemTotal = "";

        for (Aluno a : this.repositorio.findAll()) {
            listagemTotal = listagemTotal + a.toString();
        }

        return listagemTotal;
    }

    private Aluno validacaoVazio(String nome, String sexo, String idade, String matricula, String anoIngresso) {
        Aluno a = new Aluno();
        if (nome.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'nome'.");
        }
        a.setNome(nome);

        if (sexo.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'sexo'.");
        }
        a.setSexo(sexo.charAt(0));

        int idadeInt = 0;
        if (idade.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'idade'.");
        }

        if (!idade.matches("[0-9]*")) {
            throw new AlunoException("Error - Valor inválido no campo 'idade'.");
        }

        idadeInt = Integer.parseInt(idade);
        a.setIdade(idadeInt);

        if (matricula.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'cpf'.");
        }
        a.setMatricula(matricula);

        int anoInt = 0;
        if (anoIngresso.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'Ano de ingresso'.");
        }

        anoInt = Integer.parseInt(anoIngresso);
        a.setAnoIngresso(anoInt);

        return a;
    }

}
