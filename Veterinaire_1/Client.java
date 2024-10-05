package Veterinaire;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    private Client() {}
    public static void main(String [] args ){



        try {
            Registry registry = LocateRegistry.getRegistry(1352);
            
              Idossiersuivi stubdossier =(Idossiersuivi) registry.lookup("Dossier");
              Icabinet stubcabinet = (Icabinet) registry.lookup("Cabinet");
              interfaceAnimal stubanimal = (interfaceAnimal) registry.lookup("Animal");


            interfaceAnimal responsecabinet = stubcabinet.getAnimalnom("Rex");

            System.out.println("[Client]-----------------------------Debut Partie Dossier --------------- : ");


            System.out.println("[Client] : la reponse du stubdossier du client est  : "+stubdossier.getDossiersuivi());



            stubdossier.setDossiersuivi("dossier modifier");

            System.out.println("[Client] :la reponse du stubdossier du client apres modification est  : "+stubdossier.getDossiersuivi());


            System.out.println("[Client]-----------------------------Fin Partie Dossier --------------- : ");

            System.out.println("[Client]-----------------------------Debut Partie Espece (4) --------------- : ");

            System.out.println("Le Cabinet avant modification : ");


            Animal obj6 = new Animal("boubich","tarzan");
            stubcabinet.setAnimalCabinet(obj6);



            //modif espece
            Espece esp =stubanimal.getEspece();
            System.out.println("[Client]L'espece reçu est "+esp.getNom());

            esp.setEspeceNom("fadel");

            System.out.println("[Client]apres le setter de l'espece Client : "+esp.getNom());

            // pour voir si dans le servuer le nom de l'espece a ete changé

            System.out.println("le nom de l espece dans le serveur "+ stubanimal.getEspece().getNom());

            System.out.println("[Client]-----------------------------Fin Partie Espece (4) --------------- : ");



            // tout ce que j'ai fais est de ne pas mettre de setter dans l'interface

        } catch(Exception e){
            System.err.println("l'exception du client : "+ e);
            e.printStackTrace();
        }
    }

}
