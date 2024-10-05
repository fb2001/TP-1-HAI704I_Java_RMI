
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Cabinet extends UnicastRemoteObject implements Icabinet {
    private ArrayList<interfaceAnimal> patients;
    private ArrayList<Iclient> clients;

    public Cabinet() throws RemoteException {
        this.patients = new ArrayList<interfaceAnimal>();
        this.clients = new ArrayList<Iclient>();
    }

    @Override
    public interfaceAnimal getAnimalnom(String nom) throws RemoteException {
        for (interfaceAnimal animalcherche : patients) {

            if (animalcherche.getNom().equals(nom)) {
                return animalcherche;
            }
        }
        return null;
    }

    public ArrayList<interfaceAnimal> getlistAnimal() throws RemoteException {
        ArrayList<interfaceAnimal> result = new ArrayList<>();
        for (interfaceAnimal animal : patients) {
            result.add(animal);  // Ajoute l'animal à la liste des résultats
        }
        return result;
    }

    @Override
    public int getnbPatients() throws RemoteException {
        return this.patients.size();
    }

    public void alerteClients(int CompteurClient) throws RemoteException {
        for (Iclient client : clients) {
            client.notification("Le nombre de patients est supérieur/inferieur ou égale à : " + CompteurClient);
        }
    }

    @Override
    public boolean addAnimal(String name, String ownerName, Espece species, String state) throws RemoteException {
        interfaceAnimal patient = new Animal(name, ownerName, species, state);
        patient.setDossier(state);
        if ((patients.size() == 99) || (patients.size() == 499) || (patients.size() == 999)) {
            alerteClients(patients.size() + 1);
        }
        return this.patients.add(patient);
    }

    @Override
    public void addClient(Iclient client) throws RemoteException {
        // Ajoute un client à la liste des clients
        clients.add(client);
    }



    @Override
    public boolean supprimerAnimal(String nom) throws RemoteException {
        // Supprime un animal en fonction de son nom
        for (interfaceAnimal animal : patients) {
            if (animal.getNom().equals(nom)) {
                boolean supprime = patients.remove(animal); // Supprime l'animal de la liste des patients
                if (supprime) {
                    System.out.println("Nombre total de patients après suppression : " + patients.size());
                    System.out.println("Nombre de clients à informer : " + clients.size());

                    // Appel à la notification lorsqu'un multiple de 100 est atteint
                    notification_cab(patients.size(), "Un animal a été supprimé.");
                }
                return supprime;
            }
        }
        return false; // Retourne false si l'animal n'est pas trouvé
    }

    private void notification_cab(int nombrePatients, String info) throws RemoteException {
        if ((patients.size() == 101) || (patients.size() == 501) || (patients.size() == 1001)) {
            alerteClients(patients.size() - 1);
        }
    }




    public int sizeclients() {
        // Retourne la taille de la liste des clients
        return clients.size();
    }
}
