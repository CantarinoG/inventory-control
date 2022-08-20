package model;

public class Aluno extends Pessoa {

    private String matricula;
    private int anoIngresso;

    public Aluno() {
        super();
        this.matricula = "";
        this.anoIngresso = -1;
    }

    public Aluno(String nome, char sexo, int idade, String matricula, int anoIngresso) {
        super(nome, sexo, idade);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
    }

    @Override
    public String toString() {
        String txt
                = "---------- Aluno -----------\n";
        txt += super.toString();
        txt += "Matricula: " + this.matricula + "\n"
                + "Ano de ingresso: " + this.anoIngresso + "\n"
                + "-------------------------------------\n";
        return txt;
    }

    @Override
    public boolean equals(Object obj) {
        Aluno outro = (Aluno) obj;
        if (!super.equals(obj)) {
            return false;
        } else if (this.matricula.equals(outro.getMatricula())) {
            return false;
        }

        return true;
    }

    public void copiar(Aluno outro) {
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
        this.matricula = outro.getMatricula();
        this.anoIngresso = outro.getAnoIngresso();
    }

    public String cabecalho() {
        return "Nome;sexo;idade;matricula;ano\n";
    }

    public String atributoToCSV() {
        String aux = this.nome + ";" + this.sexo + ";" + this.idade + ";" + this.matricula + ";" + this.anoIngresso + "\n";
        return aux;
    }

    public void CSVToAtributo(String csv) {
        String vetor[] = csv.split(";");

        this.nome = vetor[0];
        this.sexo = vetor[1].charAt(0);
        this.idade = Integer.parseInt(vetor[2]);
        this.matricula = vetor[3];
        this.anoIngresso = Integer.parseInt(vetor[4]);
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return this.anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

}
