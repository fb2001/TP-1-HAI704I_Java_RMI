package Veterinaire;


import java.io.Serializable;

public class Espece implements Serializable {
    private  String nom;
    private  Integer Moyennedevie ;

    public Espece(String nom , Integer Moyennedevie){
        this.nom=nom;
        this.Moyennedevie=Moyennedevie;
    }

    public String getNom() {
        return nom;
    }
    public Integer getMoyennedevie(){
        return Moyennedevie;
    }

    public void setEspeceNom(String nom ){
        this.nom=nom;
    }

    public void setEspeceMoyennedevie(Integer numero ){
        this.Moyennedevie=numero;
    }

}
