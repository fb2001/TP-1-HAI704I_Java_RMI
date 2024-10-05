package Veterinaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements interfaceAnimal {
    private final String nom;
    private final String nom_maitre;
    private Espece espece;
    private Idossiersuivi dossier;

    // Constructeur qui gère RemoteException
    public Animal(String nom, String nom_maitre) throws RemoteException {
        super();  // Appelle le constructeur de UnicastRemoteObject
        this.nom = nom;
        this.nom_maitre = nom_maitre;
        this.dossier=new Dossiersuivi("suivie_animal" );
    }

    // Getters pour accéder aux attributs
    public String getNom() throws RemoteException {
        return nom;
    }

    public String getNomMaitre() throws RemoteException {
        return nom_maitre;
    }


  public Idossiersuivi getDossieranimal() throws RemoteException {
        return  this.dossier; // Retourner le texte du dossier
    }



    public void setDossiersuiviinter(Idossiersuivi dossier) throws RemoteException {
        this.dossier = dossier;
    }



    @Override
    public Espece getEspece() throws RemoteException {
        return this.espece;
    }

    public void setEspeceAnimal(Espece esp){
        this.espece = esp;
    }



    @Override
    public String getAnimal() throws RemoteException {
        String espNom = (espece != null) ? espece.getNom() : "Non spécifié";
        return "Nom: " + nom + ", Maître: " + nom_maitre + ", Espèce: " + espNom + ", Dossier: " + dossier;
    }
    @Override
    public String toString() {
        String especeNom = (espece != null) ? espece.getNom() : "Non spécifié";
        String dossierSuivi = (dossier != null) ? dossier.toString() : "Non spécifié";

        return "Nom: " + nom +
                ", Maître: " + nom_maitre +
                ", Espèce: " + especeNom +
                ", Dossier: " + dossierSuivi;
    }

}
