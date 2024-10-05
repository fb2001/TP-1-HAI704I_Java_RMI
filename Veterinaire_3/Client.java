package Veterinaire;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    private Client() {}
    public static void main(String [] args ){



        try {
            Registry registry = LocateRegistry.getRegistry(1554);
            Icabinet stubcabinet = (Icabinet) registry.lookup("Cabinet");

            // Affichage du cabinet avant modification
            System.out.println("[Client] :Le Cabinet avant modification : ");
            for (interfaceAnimal animal : stubcabinet.getlistAnimal()) {
                System.out.println(animal.getAnimal());
            }

            // Ajouter un nouvel animal
            Animal obj6 = new Animal("boubich", "tarzan");
            stubcabinet.setAnimalCabinet(obj6);

            // Affichage du cabinet après modification
            System.out.println("[Client] :Le Cabinet apres modification : ");
            for (interfaceAnimal animal : stubcabinet.getlistAnimal()) {
                System.out.println(animal.getAnimal());
            }

        } catch (Exception e) {
            System.err.println("l'exception du client : " + e);
            e.printStackTrace();
        }

    }

}
