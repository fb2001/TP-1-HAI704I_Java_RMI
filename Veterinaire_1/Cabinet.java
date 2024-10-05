package Veterinaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Cabinet extends UnicastRemoteObject implements Icabinet {
    private ArrayList<interfaceAnimal> patients ;

    public Cabinet() throws RemoteException{
        super();
        this.patients = new ArrayList<interfaceAnimal>();
    }


    @Override
   public interfaceAnimal getAnimalnom(String nom) throws RemoteException {
        for (interfaceAnimal animalcherche : patients){

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





    public void setAnimalCabinet(interfaceAnimal an) throws RemoteException {
        this.patients.add(an);  // Pas besoin de caster vers Animal sinon j'aurai une erreur de cast je gere uniquement les interface animal
        System.out.println("Animal ajouté : " + an.getAnimal());
    }


}
