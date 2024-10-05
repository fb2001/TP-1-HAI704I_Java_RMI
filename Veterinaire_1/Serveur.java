package Veterinaire;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public Serveur(){}

    public static void main(String[] args){

        try{
           Idossiersuivi dossier = new Dossiersuivi("toujours vivant "); //déja initialisé dans Animal
            Espece espece = new Espece("youssef" , 27);


            interfaceAnimal obj = new Animal("Rex","Hamid");

            Cabinet cab = new Cabinet();
            cab.setAnimalCabinet(obj);

            obj.setEspeceAnimal(espece);

            Idossiersuivi obj2 =obj.getDossieranimal() ;

            Registry registry = LocateRegistry.createRegistry(1352); // ici j'ai fait getRegistry mais y a aucun registre creer . donc il faut utilisé createRegistruy obligé de faire un port

            if(registry==null){
                System.err.println("RmiRegistry_not_found");
            }else{



               registry.bind("Animal" , obj );
                //              System.err.println("Server_ready 1");
                registry.bind("Cabinet",cab);
                registry.bind("Dossier" , dossier);

                System.err.println("Server_ready cabinet");
                System.out.println("Le Cabinet avant modification : ");

                System.out.println("[Serveur] : Dossier avant la modification : "+dossier.getDossiersuivi());
                System.out.println(("[Serveur]l'espece de l'animal au depart est : "+ obj.getEspece().getNom()));



               /* for (interfaceAnimal animal : cab.getlistAnimal()) {
                    System.out.println(animal.getAnimal());
                }
                */
                Thread.sleep(5000);


                System.out.println("[Serveur] : Dossier apres la modification : "+dossier.getDossiersuivi());

/*
                System.out.println("Le Cabinet apres modification : ");
                for (interfaceAnimal animal : cab.getlistAnimal()) {
                    System.out.println(animal.getAnimal());
                }

 */

                //Espece
                System.out.println(("[Serveur]l'espece de l'animal apres la modif est : "+ obj.getEspece().getNom()));
                System.out.println(("le dossier de l'animal à la fin  est : "+ obj.getDossieranimal()));


            }

        } catch (Exception e) {
            System.err.println("Server_exception : "+ e);
            e.printStackTrace();
        }


    }

}
