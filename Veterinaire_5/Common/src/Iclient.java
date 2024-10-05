import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public interface Iclient extends Remote {
    void notification(String c) throws RemoteException;
    Icabinet lookupCabinet(String key) throws RemoteException, NotBoundException;
    void setUpRegistry() throws RemoteException;
    void recevoirAlerte(String info) throws RemoteException;


}
