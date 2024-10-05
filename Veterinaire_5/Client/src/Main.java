import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {


    public static void fillPatientList(int nbPatients, Icabinet cabinet) throws RemoteException {
        for (int i = 0; i<nbPatients; i++){
            cabinet.addAnimal("fadel", "youssef", new Espece("hmar", 23), "con");
        }
    }
    public static void viderCabinet(Icabinet cabinet, int nb_Supprime, String nomAnimal) throws Exception {
        int supprimeCounter = 0;
        for (int i = 0; i < nb_Supprime; i++) {
            boolean isSupprime = cabinet.supprimerAnimal(nomAnimal);
            if (isSupprime) {
                supprimeCounter++;
            } else {
                System.out.println("L'animal " + nomAnimal + " n'a pas pu être supprimé.");
            }
        }
    }


    public static void main(String[] args) {

        try {
           Iclient client = new Client();

           client.setUpRegistry();

           Icabinet stubcabinet = client.lookupCabinet("cabinet");

           stubcabinet.addClient(client);

            // Affichage du cabinet avant modification

/*            System.out.println("Le Cabinet avant modification : ");
            for (interfaceAnimal animal : stubcabinet.getlistAnimal()) {
                System.out.println(animal.getAnimal());
            }

 */

            // Ajouter un nouvel animal
            //Dog dog = new Dog("boubich",15);
            // creation de m'espece Dog pour Client

            //Boolean ajout_oupas = stubcabinet.addAnimal("boubich","tarzan",dog ,"vide");

            //System.out.println("ajout ou pas : "+ajout_oupas);

            // Maintenant passage a l'ajout des client pour voir si il y a execution de la  condition 100 , 500 , 1000

            Thread.sleep(5000);
            // Ajouter 100 patients
            fillPatientList(100, stubcabinet);
            Thread.sleep(5000);
            // Ajouter encore 400 patients supplémentaires (total 500)
            fillPatientList(400, stubcabinet);

            Thread.sleep(5000);
            // Ajouter encore 500 patients supplémentaires (total 1000)

            Thread.sleep(5000);
            //suppresion de tout les patients et affichage des resultat :
            viderCabinet(stubcabinet, 500, "fadel");


        } catch (Exception e) {
            System.err.println("l'exception du client : " + e);
            e.printStackTrace();
        }
    }
}