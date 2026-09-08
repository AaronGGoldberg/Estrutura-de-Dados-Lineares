package br.com.edl20262.desenho;

public class Desenho {
    private String circulo;
    private String cor;
    private String posicao;
    private String dimensoes;
    private String acao;

    public Desenho(String circulo,String cor,String posicao,String dimensoes,String acao){
        this.circulo=circulo;
        this.cor=cor;
        this.posicao=posicao;
        this.dimensoes=dimensoes;
    }

    public void setCirculo(String circulo){
        this.circulo=circulo;
    }

    public String getCirculo(){
        return this.circulo;
    }

    public void setCor(String cor){
        this.cor=cor;
    }

    public String getCor(){
        return this.cor;
    }

    public void setposicao(String posicao){
        this.posicao=posicao;
    }

    public String getposicao(){
        return this.posicao;
    }

    public void setdimensoes(String dimensoes){
        this.dimensoes=dimensoes;
    }

    public String getdimensoes(){
        return this.dimensoes;
    }

    public void setAcao(String acao){
        this.acao=acao;
    }

    public String getAcao(){
        return this.acao;
    }
}

