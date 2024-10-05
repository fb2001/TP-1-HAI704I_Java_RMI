package Veterinaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Icabinet extends Remote {
     interfaceAnimal getAnimalnom(String nom) throws RemoteException;

    ArrayList<interfaceAnimal> getlistAnimal() throws  RemoteException;

    void setAnimalCabinet(interfaceAnimal an) throws RemoteException;

}
