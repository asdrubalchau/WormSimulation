/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import computer.Computer;
import computer.TaskOperatingSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import network.ServerEmails;
import simulation.DiscreteTime;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class EmailAccount {

    /**
     * The net to sync accounts
     */
    network.ServerEmails server;
    /**
     * The id of the user
     */
    private int idOwner;
    /**
     * the list of emails received
     */
    private java.util.List<Message> received = new ArrayList<>();
    /**
     * The list of emails sent
     */
    private java.util.List<Message> sent = new ArrayList<>();
    /**
     * The list of contacts
     */
    private List<Integer> contacts = new ArrayList<>();
    /**
     * The computer where this account is used in this time
     */
    private Computer computer;

    /**
     * All emails account must have the same network
     *
     * @param server
     * @param idOwner
     */
    public EmailAccount(ServerEmails server, int idOwner) {
        this.server = server;
        this.idOwner = idOwner;
        server.addAccount(this);
    }

    /**
     * Choses an element in the contact list, randomly
     *
     * @return
     */
    public int selectAContactRandomly() {
        return contacts.get(DiscreteTime.r.nextInt(contacts.size()));
    }

    public void sendEmail(String msg, Object attach, int from, int to) {
        Message m = new Message();
        m.setTo(to);
        m.setFrom(from);
        m.setAttach(attach);
        m.setMsg(msg);
        sent.add(m);
        server.sendEmail(from, to, m);
    }

    public java.util.ArrayList<Message> readAllEmails() {
        java.util.ArrayList<Message> emails = new ArrayList<>();
        while (received.size() > 0) {
            emails.add(readEmail());
        }
        return emails;
    }

    public Message readEmail() {
        Message r = null;
        if (received.size() > 0) {
            r = received.get(0);
           // System.out.println("Read. " + r.toString());
            received.remove(0);
        }
        return r;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public java.util.List<Message> getReceived() {
        return received;
    }

    public void setReceived(java.util.List<Message> received) {
        this.received = received;
    }

    public java.util.List<Message> getSent() {
        return sent;
    }

    public void setSent(java.util.List<Message> sent) {
        this.sent = sent;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public List<Integer> getContacts() {
        return contacts;
    }

    public void setContacts(List<Integer> contacts) {
        this.contacts = contacts;
    }

    public String getContactsAsString() {
        int c[] = new int[contacts.size()];
        for (int i = 0; i < c.length; i++) {
            c[i] = contacts.get(i);

        }
        return Arrays.toString(c);
    }

}
