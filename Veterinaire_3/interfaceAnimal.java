package Veterinaire;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceAnimal extends Remote{
    String getAnimal() throws RemoteException;

/*
    void setDossiersuiviinter(String modifiedDossier) throws RemoteException;
    Dossiersuivi getDossieranimal() throws RemoteException;
*/

    Espece getEspece() throws RemoteException;

    Idossiersuivi getDossieranimal() throws RemoteException;

    String getNom() throws RemoteException;
}
