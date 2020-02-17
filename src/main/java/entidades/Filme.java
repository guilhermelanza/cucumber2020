package entidades;

public class Filme {

    private int estoque;
    private int precoAluguel;

    public void setEstoque(int arg1) {
        this.estoque = arg1;
    }

    public int getEstoque(){
        return estoque;
    }

    public void setPrecoAluguel(int arg1) {
        this.precoAluguel = arg1;
    }

    public int getAluguel() {
        return precoAluguel;
    }
}
