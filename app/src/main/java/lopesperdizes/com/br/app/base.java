package lopesperdizes.com.br.app;

public class base {

    public enum tipo{
        VENDA, ALUGUEL;
    }

    private int valor;
    private tipo tipo;
    private String titulo;
    private String localidade;
    private int imagem;

    //construtor da classe
    public base(int valor, tipo tipo, String titulo, String localidade, int imagem){
        this.valor = valor;
        this.tipo = tipo;
        this.titulo = titulo;
        this.localidade = localidade;
        this.imagem = imagem;

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public base.tipo getTipo() {
        return tipo;
    }

    public void setTipo(base.tipo tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
