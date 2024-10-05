package Veterinaire;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Dossiersuivi extends UnicastRemoteObject implements Idossiersuivi{
    private String dossieranimal;

    public Dossiersuivi(String dossieranimal) throws RemoteException {
        super();
        this.dossieranimal=dossieranimal;
    }

    public String getDossiersuivi()  throws RemoteException {
        return this.dossieranimal;
    }

    public void setDossiersuivi(String dossieranimal) throws RemoteException {
        this.dossieranimal = dossieranimal;
    }
// cette methode permet de nous afficher le dossier de maniere string
    @Override
    public String toString() {
        return "Dossiersuivi: " + dossieranimal;
    }


}
