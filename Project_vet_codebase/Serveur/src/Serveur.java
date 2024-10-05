import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Serveur {
    public static void main(String[] args) {


        try{

            System.setProperty("java.security.policy", "/home/fadel_benomar/Bureau/Master_s1/architectures_distribuées/RMI/Final_RMI/Project_vet_codebase/Serveur/src/Security.policy");
            System.setSecurityManager(new SecurityManager());

            //System.setProperty("java.rmi.server.codebase", "file:/home/fadel_benomar/Bureau/Master_s1/architectures_distribuées/RMI/Final_RMI/Project_vet_codebase/Client/codebase_dog/");// sans le file j'aurai une exceptionl'exception du client : java.rmi.ServerException: RemoteException occurred in server thread; nested exception is:java.rmi.UnmarshalException: error unmarshalling arguments; nested exception is: java.net.MalformedURLException: no protocol: /home/fadel_benomar/Bureau/Project_vet_fin4/Client/codebase_dog

            Espece espece = new Espece("chat" , 27);

            Cabinet cab = new Cabinet();

            cab.addAnimal("Rex","Hamid",espece,"state");


            Registry registry = LocateRegistry.createRegistry(5312); // ici j'ai fait getRegistry mais y a aucun registre creer . donc il faut utilisé createRegistruy obligé de faire un port

            if(registry==null){
                System.err.println("RmiRegistry_not_found");
            }else{
                /*
                registry.bind("Animal" , obj );
                System.err.println("Server_ready 1");
                registry.bind("dossier" , obj2 );
                System.err.println("Server_ready 2");
                   */
                registry.bind("Cabinet",cab);
                System.err.println("Server_ready cabinet");
                System.out.println("Le Cabinet avant modification : ");
                for(interfaceAnimal animal : cab.getlistAnimal()){
                    System.out.println(animal.getAnimal());
                }

                Thread.sleep(5000);



                System.out.println("Le Cabinet apres modification : ");
                for(interfaceAnimal animal : cab.getlistAnimal()){
                    System.out.println(animal.getAnimal());
                }

             /*   //Espece
                System.out.println(("l'espece de l'animal au depart est : "+ obj.getEspece().getNom()));



                Thread.sleep(5000);
                System.out.println(("l'espece de l'animal apres la modif est : "+ obj.getEspece().getNom()));
                System.out.println(("le dossier de l'animal à la fin  est : "+ obj.getDossieranimal()));
    */

            }

        } catch (Exception e) {
            System.err.println("Server_exception : "+ e);
            e.printStackTrace();
        }    }
}