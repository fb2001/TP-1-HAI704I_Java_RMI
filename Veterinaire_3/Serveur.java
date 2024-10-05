package Veterinaire;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public Serveur(){}

    public static void main(String[] args){

        try{
           // IDossiersuivi dossier = new Dossiersuivi("toujours vivant "); déja initialisé dans Animal
            Espece espece = new Espece("youssef" , 27);


            Animal obj = new Animal("Rex","Hamid");
            Animal obj2 = new Animal("Shaft" , "Awatef");
            Animal obj3 = new Animal("Fox" , "Souad");
            Cabinet cab = new Cabinet();
            cab.setAnimalCabinet(obj);
            cab.setAnimalCabinet(obj2);
            cab.setAnimalCabinet(obj3);

            obj.setEspeceAnimal(espece);

            //Idossiersuivi doss =obj.getDossieranimal() ;

            Registry registry = LocateRegistry.createRegistry(1554); // ici j'ai fait getRegistry mais y a aucun registre creer . donc il faut utilisé createRegistruy obligé de faire un port

            if(registry==null){
                System.err.println("RmiRegistry_not_found");
            }else{

                registry.bind("Cabinet",cab);
                System.err.println("Server_ready cabinet");
                System.out.println("[Serveur] : Le Cabinet avant modification : ");
                for(interfaceAnimal animal : cab.getlistAnimal()){
                    System.out.println(animal.getAnimal());
                }

                Thread.sleep(5000);



                System.out.println("[Serveur] :Le Cabinet apres modification : ");
                for(interfaceAnimal animal : cab.getlistAnimal()){
                    System.out.println(animal.getAnimal());
                }



            }

        } catch (Exception e) {
            System.err.println("Server_exception : "+ e);
            e.printStackTrace();
        }


    }

}
