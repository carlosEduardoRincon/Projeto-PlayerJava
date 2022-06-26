package model;

public class ControleRemoto implements Controlavel {

    private int volume;
    private int volumeMudo;
    private boolean ligado;
    private boolean tocando;
    
    public ControleRemoto(){
                
        volume = 50;
        ligado = false;
        tocando = false;
    }
       
    @Override
    public void ligar() {
        if(!isLigado()){
            ligado = true;
        }
    }

    @Override
    public void desligar() {
        if(isLigado()){
            ligado = false;
        }
    }

    @Override
    public void abrirMenu() {
        System.out.println("=============MENU===============");
        if(isLigado()){  
            System.out.println("Está ligado"); 
        }
        else{ 
            System.out.println("Está desligado"); 
        }
        if(isTocando()){
            System.out.println("Está tocando");
        } else {
            System.out.println("Não está tocando");
        }
        System.out.print("Volume: "+volume+"  ");
        for(int i=0; i<volume; i+=10){
            System.out.print("|");
        }
        System.out.println("\n================================");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechou Menu");
    }

    @Override
    public void maisVolume() {
        if(isLigado()){
            volume += 5;
        } else {
            System.out.println("Está desligado, não é possível aumentar");
        }
    }

    @Override
    public void menosVolume() {
        if(isLigado() && volume > 0){
            volume -= 5;
        } else {
            System.out.println("Está desligado, não é possível diminuir");
        }
    }

    @Override
    public void ligarMudo() {
        if(isLigado() && volume > 0){
            volumeMudo = volume;
            volume = 0;
        }
    }

    @Override
    public void desligarMudo() {
        if(isLigado() && volume == 0){
            volume = volumeMudo;
        }
    }

    @Override
    public void play() {
        if(isLigado() && !isTocando()){
            tocando = true;
        }
    }

    @Override
    public void pause() {
        if(isLigado() && isTocando()){
            tocando = false;
        }
    }
    
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isTocando() {
        return tocando;
    }

    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
}
