/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import computer.Computer;
import java.util.ArrayList;
import java.util.Collections;
import simulation.DiscreteTime;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class NetworkComputers {

    private java.util.List<computer.Computer> computers;

    public NetworkComputers(int numberOfNodes) {
        computers = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            computers.add(new Computer(i, false));
        }
    }

    public void infectComputersRandomly(int numberOfComputersInfected) {
        java.util.Random r = DiscreteTime.r;
        java.util.ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < computers.size(); i++) {
            randomNumbers.add(i);
        }
        Collections.shuffle(randomNumbers, r);

        for (int i = 0; i < numberOfComputersInfected; i++) {
            computers.set(randomNumbers.get(i), new Computer(computers.get(randomNumbers.get(i)).getIdComputer(), true));
        }
    }

    public java.util.ArrayList<computer.Computer> getInfected() {
        java.util.ArrayList<computer.Computer> infected = new ArrayList<>();
        for (Computer computer : computers) {
            if (computer.getTask() instanceof malware.Malware) {
                infected.add(computer);
            }
        }
        return infected;
    }

    public String toString() {
        String t = "";

        for (Computer computer : computers) {
            t += "host: " + computer.getIdComputer() + " Status: " + computer.getTask().toString();
            t += "\n";
        }
        return t;
    }

    public java.util.List<computer.Computer> getComputers() {
        return computers;
    }

    public void setComputers(java.util.List<computer.Computer> computers) {
        this.computers = computers;
    }

}
