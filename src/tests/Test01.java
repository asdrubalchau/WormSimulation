/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import computer.Computer;
import java.util.ArrayList;
import network.ServerEmails;
import simulation.DiscreteTime;

/**
 * Clase principal
 *
 * @author asdruballopezchau
 */
public class Test01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//      

        DiscreteTime dt = new DiscreteTime();
        int totalUsers = 20, numberOfComputerOwners = 15, minNumberOfContacts = 5, maxNumberOfContacts = 10;
        int numberOfComputers = totalUsers;
        int numberOfComputersInfected = 1;
        int minTime = 5;
        int maxTime = 10;
        //////////////
        ServerEmails server = new ServerEmails();
        dt.setEmailServer(server);
        dt.generateNetwork(numberOfComputers);
        System.out.println(dt.getNetwork().toString());
        dt.setInitiallyInfected(numberOfComputersInfected);
        System.out.println(dt.getNetwork().toString());
        ArrayList<Computer> infected = dt.getNetwork().getInfected();
        System.out.println("INFECTED: ");
        for (Computer i : infected) {
            System.out.println(i);
        }
        //////
        dt.setUsersParameters(totalUsers, numberOfComputerOwners, minNumberOfContacts, maxNumberOfContacts);
        dt.generateUSers();
        System.out.println(dt.getUsers().toString());
        dt.setUsersTimeParameters(minTime, maxTime);
        /////
        

        //System.out.println(dt.getUsers().toString());
        dt.step(100);

    }

}
