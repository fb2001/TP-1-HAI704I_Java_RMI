import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(5312);
            Icabinet stubcabinet = (Icabinet) registry.lookup("Cabinet");

            // Affichage du cabinet avant modification
            System.out.println("Le Cabinet avant modification : ");
            for (interfaceAnimal animal : stubcabinet.getlistAnimal()) {
                System.out.println(animal.getAnimal());
            }

            // Ajouter un nouvel animal
            Dog dog = new Dog("boubich",15);
            // creation de m'espece Dog pour Client

            Boolean ajout_oupas = stubcabinet.addAnimal("boubich","tarzan",dog ,"vide");

            System.out.println("ajout ou pas : "+ajout_oupas);


            // Affichage du cabinet après modification
            System.out.println("Le Cabinet apres modification : ");
            for (interfaceAnimal animal : stubcabinet.getlistAnimal()) {
                System.out.println(animal.getAnimal());
            }

        } catch (Exception e) {
            System.err.println("l'exception du client : " + e);
            e.printStackTrace();
        }
    }
}