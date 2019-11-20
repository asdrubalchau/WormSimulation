/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import network.NetworkComputers;
import users.User;
import users.Users;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class Simulate {
//
//    NetworkComputers network;
//    Users users;
//    long seed;
//    public static java.util.Random r;
//
//    public Simulate(long seed) {
//        this.seed = seed;
//        r = new Random(seed);
//        dt = new DiscreteTime();
//    }
//
//    DiscreteTime dt;
//
//    public void setNetworkParameters(int numberOfNodes) {
//        network = new NetworkComputers(numberOfNodes);
//    }
//
//    public void setUsersParameters(int totalUsers, int numberOfComputerOwners, int minNumberOfContacts, int maxNumberOfContacts) throws Exception {
//        users = new Users(totalUsers, numberOfComputerOwners, minNumberOfContacts, maxNumberOfContacts, seed);
//    }
//
//    public void setUserTimeRestrictions(int minTime, int maxTime) {
//        for (User u : users.getUsers()) {
//            ((DiscreteTimeUser) u).setMinTime(minTime);
//            ((DiscreteTimeUser) u).setMaxTime(maxTime);
//        }
//
//    }
//
//    public void initiallyInfected(int numberOfComputersInfected) throws Exception {
//        if (network == null) {
//            throw new Exception("You must first set the parameters of network");
//        }
//        network.infectComputersRandomly(numberOfComputersInfected);
//    }
//
//    public void sumulating(int iterations) {
////        simulateSendEmail(0, 1, "hola", null);
////        simulateReceiveEmail(1);
////        System.out.println(users.toString());
//        for (int i = 0; i < iterations; i++) {
//            assignComputersToUsersRandomly();
//            System.out.println(users.toString());
//            m1();
//        }
//
//    }
//
//    private void assignComputersToUsersRandomly() {
//        ArrayList<User> u = users.getUsers();
//        ArrayList<Integer> listComputers = generateListOfComputersRandomly(network.getComputers().size());
//        int i = 0;
//        for (User u1 : u) {
//            u1.setComputer(network.getComputers().get(listComputers.get(i)));
//            i++;
//        }
//
//    }
//
//    private java.util.ArrayList<Integer> generateListOfComputersRandomly(int numberOfComputers) {
//        java.util.ArrayList<Integer> computers = new ArrayList<>();
//        java.util.ArrayList<Integer> tempo = new ArrayList<>();
//
//        for (int i = 0; i < numberOfComputers; i++) {
//            tempo.add(i);
//        }
//        Collections.shuffle(tempo, r);
//        int t = 0;
//        for (int i = 0; i < numberOfComputers; i++) {
//            computers.add(tempo.get(t));
//            t++;
//        }
//        return computers;
//    }
//
//    private void m1() {
//
//        for (User u : users.getUsers()) {
//            ((DiscreteTimeUser) u).step();
//        }
//
//    }
//
//    private void simulateSendEmail(int from, int numberOfRecipients, String msg, Object attach) {
//        users.getUsers().get(from).getComputer().getTask().serviceComposeEmail(msg);
//        users.getUsers().get(from).getComputer().getTask().serviceAttachToEmail(attach);
//        for (int i = 0; i < numberOfRecipients; i++) {
//            simulateSend(from, users.getUsers().get(from).getContacts().get(i));
//        }
//    }
//
//    private void simulateSend(int from, int to) {
//        users.getUsers().get(to).getComputer().getTask().serviceReceiveEmail(users.getUsers().get(from).getComputer().getTask().getM());
//
//    }
//
//    private void simulateReceiveEmail(int to) {
//        users.getUsers().get(to).getComputer().getTask().serviceReadEmail();
//    }

}
