import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Serveur {
    public static void main(String[] args) {


        try{

            System.setProperty("java.security.policy", "/home/fadel_benomar/Bureau/Projet_RMI_FINAL+Rapport/Veterinaire_5/Serveur/src/Security.policy");
            System.setSecurityManager(new SecurityManager());

            System.setProperty("java.rmi.server.codebase", "file:/home/fadel_benomar/Bureau/Projet_RMI_FINAL+Rapport/Veterinaire_5/Client/codebase_dog/");            // sans le file j'aurai une exceptionl'exception du client : java.rmi.ServerException: RemoteException occurred in server thread; nested exception is:java.rmi.UnmarshalException: error unmarshalling arguments; nested exception is: java.net.MalformedURLException: no protocol: /home/fadel_benomar/Bureau/Project_vet_fin4/Client/codebase_dog

            Espece espece = new Espece("chat" , 27);

            Icabinet cab = new Cabinet();

            cab.addAnimal("Rex","Hamid",espece,"state");


            Registry registry = LocateRegistry.createRegistry(53127); // ici j'ai fait getRegistry mais y a aucun registre creer . donc il faut utilisé createRegistruy obligé de faire un port

            if(registry==null){
                System.err.println("RmiRegistry_not_found");
            }else{
                /*
                registry.bind("Animal" , obj );
                System.err.println("Server_ready 1");
                registry.bind("dossier" , obj2 );
                System.err.println("Server_ready 2");
                   */
                registry.bind("cabinet",cab);
                System.err.println("Server_ready cabinet");


                Thread.sleep(4000);


                //Affichage de combien de clients est dans le cabinet
                System.out.println("Nombre de client 1ere attente dans le cabinet \n" +cab.sizeclients());

                Thread.sleep(10000);


                //Affichage de combien de clients est dans le cabinet
                System.out.println("Nombre de client apres 2eme attente dans le cabinet \n" +cab.sizeclients());

                Thread.sleep(10000);


                //Affichage de combien de clients est dans le cabinet
                System.out.println("Nombre de client apres 3eme attente dans le cabinet \n" +cab.sizeclients());





            }

        } catch (Exception e) {
            System.err.println("Server_exception : "+ e);
            e.printStackTrace();
        }    }
}