/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import computer.Computer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.NetworkComputers;
import network.ServerEmails;
import users.User;
import users.Users;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class DiscreteTime {

    //Users information
    int totalUsers;
    int numberOfComputerOwners;
    int minNumberOfContacts;
    int maxNumberOfContacts;
    //Email server, network and users
    ServerEmails serverEmails;
    private network.NetworkComputers network;
    private Users users;
    //Time constraints
    private int time;//Counter of time
    private int minTime;//Minimum time to begin 
    private int maxTime;//Maximum time to being
    public static java.util.Random r = new Random(System.nanoTime());
    //
    ArrayList<User> usersOwners = new ArrayList<>();
    ArrayList<User> usersNotOwners = new ArrayList<>();

    /**
     * 
     * @param totalUsers
     * @param numberOfComputerOwners
     * @param minNumberOfContacts
     * @param maxNumberOfContacts 
     */
    public void setUsersParameters(int totalUsers, int numberOfComputerOwners, int minNumberOfContacts, int maxNumberOfContacts) {
        this.totalUsers = totalUsers;
        this.numberOfComputerOwners = numberOfComputerOwners;
        this.minNumberOfContacts = minNumberOfContacts;
        this.maxNumberOfContacts = maxNumberOfContacts;
    }

    public void setEmailServer(ServerEmails serverEmails) {
        this.serverEmails = serverEmails;
    }

    /**
     *
     * @param minTime the task do not being before this time
     * @param maxTime the task will be do at this time
     */
    public void setUsersTimeParameters(int minTime, int maxTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public void generateUSers() throws Exception {
        users = new Users(serverEmails, totalUsers, numberOfComputerOwners, minNumberOfContacts, maxNumberOfContacts);
    }

    /**
     * 
     * @param numberOfNodes 
     */
    public void generateNetwork(int numberOfNodes) {
        network = new NetworkComputers(numberOfNodes);
    }

    public void step(int t) {
        for (int i = 0; i < t; i++) {
            step();
            System.out.println(i + ", " + getNumInfectedComputers());
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(DiscreteTime.class.getName()).log(Level.SEVERE, null, ex);
            }
            assignComputersToUsers();
            System.out.println(getUsers().toString());
        }

    }

    public void step() {
        time++;
        if (time >= maxTime) {//Do the task now
            doTask();
            reset();
        } else if (time >= minTime) {//there is 50% of change to do the task
            doTaskRandomly();
        }

    }

    private boolean flipCoin() {
        int r = DiscreteTime.r.nextInt(101);
        if (r >= 50) {
            return true;
        } else {
            return false;
        }
    }

    private void doTaskRandomly() {
        for (User u : users.getUsers()) {
            if (flipCoin()) {
                int to = u.getEmailAccount().selectAContactRandomly();
                String msg = "hola";
                Object attach = null;
                u.sendEmail(to, msg, attach);
                u.readAllEmails();
            }
        }

        for (User u : users.getUsers()) {
            if (flipCoin()) {
                u.readAllEmails();
            }
        }

    }

    private void doTask() {
        for (User u : users.getUsers()) {
            int to = u.getEmailAccount().selectAContactRandomly();
            String msg = "hola";
            Object attach = null;
            u.sendEmail(to, msg, attach);
        }
        for (User u : users.getUsers()) {
            u.readAllEmails();
        }

    }

    public void reset() {
        time = 0;
    }

    public void setInitiallyInfected(int numberOfComputersInfected) throws Exception {
        if (network == null) {
            throw new Exception("You must first set the parameters of network");
        }
        network.infectComputersRandomly(numberOfComputersInfected);
    }

    /**
     * Assign to each computer
     */
    public void assignComputersToUsers() {
        ArrayList<User> u = users.getUsers();
        usersOwners = new ArrayList<>();
        usersNotOwners = new ArrayList<>();

        for (User u1 : u) {
            if (u1.isAlwaysInSameComputer()) {//He/she is an owner of a computer
                if (u1.getComputer() == null) {
                    usersOwners.add(u1);//She/he does not have a computer yet
                }
            } else {
                usersNotOwners.add(u1);
            }
        }

        ArrayList<Integer> computers = getRandomListOfNumbers(network.getComputers().size());
        int i = 0;

        for (i = 0; i < usersOwners.size(); i++) {
            usersOwners.get(i).setComputer(network.getComputers().get(computers.get(i)));
        }

        TreeSet<Integer> ts = new TreeSet<>();
        for (Integer c : computers) {
            ts.add(c);
        }
        for (User t : usersOwners) {
            if (t.getComputer() != null) {
                ts.remove(t.getComputer().getIdComputer());
            }
        }
        computers = new ArrayList<>();
        for (Integer t : ts) {
            computers.add(t);
        }

        Collections.shuffle(computers, r);
        i = 0;
        for (User t : usersNotOwners) {
            t.setComputer(network.getComputers().get(computers.get(i)));
            i++;

        }
    }

    /**
     * Assign to each computer
     */
    public void assignComputersToUsersRandomly() {
        ArrayList<User> u = users.getUsers();

        ArrayList<Integer> listComputers = getRandomListOfNumbers(network.getComputers().size());
        int i = 0;
        for (User u1 : u) {
            if (!u1.isAlwaysInSameComputer()) {
                u1.setComputer(network.getComputers().get(listComputers.get(i)));
            }
            i++;
        }
    }

    private java.util.ArrayList<Integer> getRandomListOfNumbers(int numberOfComputers) {
//        java.util.ArrayList<Integer> computers = new ArrayList<>();
        java.util.ArrayList<Integer> tempo = new ArrayList<>();

        for (int i = 0; i < numberOfComputers; i++) {
            tempo.add(i);
        }
        Collections.shuffle(tempo, r);
        return tempo;
//        int t = 0;
//        for (int i = 0; i < numberOfComputers; i++) {
//            computers.add(tempo.get(t));
//            t++;
//        }
//        return computers;
    }

    public Users getUsers() {
        return users;
    }

    public int getNumInfectedComputers() {
        int ctr = 0;
        for (Computer c : network.getComputers()) {
            if (c.getTask() instanceof malware.Malware) {
                ctr++;
            }
        }

        return ctr;
    }

    public network.NetworkComputers getNetwork() {
        return network;
    }

}
