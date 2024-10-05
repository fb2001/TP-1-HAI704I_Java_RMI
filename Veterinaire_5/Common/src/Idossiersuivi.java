import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Idossiersuivi extends Remote {
    String getDossiersuivi()  throws RemoteException;
    void setDossiersuivi(String dossieranimal) throws RemoteException ;
}
