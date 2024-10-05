import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements Iclient {
    private Registry registry;
    private Icabinet cabinet;

    public Client() throws RemoteException {}

    @Override
    public void setUpRegistry() {
        try {
            this.registry = LocateRegistry.getRegistry(53127);

            if (registry == null){System.out.println("registry failed");}
            else {System.out.println("client registered");}

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void notification(String c) throws RemoteException {
        System.out.println(c);
    }

    @Override
    public Icabinet lookupCabinet(String key) throws NotBoundException, RemoteException {
        this.cabinet = (Icabinet) registry.lookup(key);
        return cabinet;

    }
    @Override
    public void recevoirAlerte(String info) throws RemoteException {
        System.out.println("Alerte : " + info);
    }

}
