import java.util.Objects;

public class Pessoa {

    private String nome;
    private int idade;
    private UF uf;
    private boolean temFilhos;
    private int filhos;

    public Pessoa(String nome, int idade, UF uf, boolean temFilhos, int filhos) {
        this.nome = nome;
        this.idade = idade;
        this.uf = uf;
        this.temFilhos = temFilhos;
        this.filhos = filhos;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public UF getUf() {
        return uf;
    }

    public boolean isTemFilhos() {
        return temFilhos;
    }

    public int getFilhos() {
        return filhos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return temFilhos == pessoa.temFilhos && filhos == pessoa.filhos && Objects.equals(nome, pessoa.nome) && Objects.equals(idade, pessoa.idade) && uf == pessoa.uf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, uf, temFilhos, filhos);
    }

    @Override
    public String toString() {
        return "dao.Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", uf=" + uf +
                ", temFilhos=" + temFilhos +
                ", filhos=" + filhos +
                '}';
    }
}
