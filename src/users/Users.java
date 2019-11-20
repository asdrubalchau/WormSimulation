/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.ArrayList;
import java.util.Collections;
import network.ServerEmails;
import simulation.DiscreteTime;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class Users {

    private java.util.ArrayList<User> users=new ArrayList<>();
    private int totalUsers;
    private int numberOfComputerOwners;
    private int minNumberOfContacts;
    private int maxNumberOfContacts;

    public Users(ServerEmails serverEmails, int totalUsers, int numberOfComputerOwners, int minNumberOfContacts, int maxNumberOfContacts) throws Exception {
        if (totalUsers < numberOfComputerOwners) {
            throw new Exception("totalUsers cannot be lesser than numberOfComputerOwners");
        }
        this.totalUsers = totalUsers;
        this.numberOfComputerOwners = numberOfComputerOwners;
        this.minNumberOfContacts = minNumberOfContacts;
        this.maxNumberOfContacts = maxNumberOfContacts;
        //Create the users
        java.util.Random r = DiscreteTime.r;

        for (int i = 0; i < totalUsers; i++) {
            User user = new User(false, i, serverEmails);
            int t = minNumberOfContacts + r.nextInt(maxNumberOfContacts - minNumberOfContacts);
            user.getEmailAccount().setContacts(generateContacts(i, t));
            users.add(user);
        }

        java.util.ArrayList<Integer> tempo = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            tempo.add(i);
        }
        Collections.shuffle(tempo, r);
        for (int i = 0; i < numberOfComputerOwners; i++) {
            users.get(tempo.get(i)).setAlwaysInSameComputer(true);
        }

    }

    /**
     * Generate a list of email contacts
     *
     * @param id The id of user, he/she cannot be a contact of himself/herself
     * @param numberOfContacts The number of contacts to generate
     * @return
     */
    private java.util.ArrayList<Integer> generateContacts(int id, int numberOfContacts) {
        java.util.ArrayList<Integer> contacts = new ArrayList<>();
        java.util.ArrayList<Integer> tempo = new ArrayList<>();
        java.util.Random r = DiscreteTime.r;
        for (int i = 0; i < totalUsers; i++) {
            tempo.add(i + 1);
        }
        Collections.shuffle(tempo, r);
        int t = 0;
        int c = 0;
        for (int i = 0; i < numberOfContacts; i++) {
            c = tempo.get(t++);
            if (c == id) {
                i--;
                continue;
            }
            contacts.add(c);
        }
        return contacts;
    }

    public String toString() {
        String t = "";
        for (User user : users) {
            t += user.toString() + "\n";
        }
        return t;
    }

    public java.util.ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(java.util.ArrayList<User> users) {
        this.users = users;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getNumberOfComputerOwners() {
        return numberOfComputerOwners;
    }

    public void setNumberOfComputerOwners(int numberOfComputerOwners) {
        this.numberOfComputerOwners = numberOfComputerOwners;
    }

    public int getMinNumberOfContacts() {
        return minNumberOfContacts;
    }

    public void setMinNumberOfContacts(int minNumberOfContacts) {
        this.minNumberOfContacts = minNumberOfContacts;
    }

    public int getMaxNumberOfContacts() {
        return maxNumberOfContacts;
    }

    public void setMaxNumberOfContacts(int maxNumberOfContacts) {
        this.maxNumberOfContacts = maxNumberOfContacts;
    }

}
