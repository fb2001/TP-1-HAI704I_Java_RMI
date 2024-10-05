
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements interfaceAnimal {
    private  String nom;
    private  String nom_maitre;
    private Espece espece;
    private Idossiersuivi dossier;

    // Constructeur qui gère RemoteException
    protected Animal(String name, String ownerName, Espece species, String state) throws RemoteException {
        this.nom = name;
        this.nom_maitre = ownerName;
        this.espece = species; // affectation de l'espèce créée auparavant
        this.dossier = new Dossiersuivi(state);
    }

    // Getters pour accéder aux attributs
    public String getNom() throws RemoteException {
        return nom;
    }


    public void setDossier(String dossierSuivi) throws  RemoteException{
        Idossiersuivi dossier = new Dossiersuivi(dossierSuivi);
        this.dossier=dossier;

    }

    public String getNomMaitre() throws RemoteException {
        return nom_maitre;
    }


  public Idossiersuivi getDossieranimal() throws RemoteException {
        return  dossier; // Retourner le texte du dossier
    }



    public void setDossiersuiviinter(Idossiersuivi dossier) throws RemoteException {
        this.dossier = dossier;
    }



    @Override
    public Espece getEspece() throws RemoteException {
        return espece;
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
