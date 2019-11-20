/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import computer.Computer;
import email.EmailAccount;
import email.Message;
import java.util.ArrayList;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class User {

    /**
     * This user uses the same computer always
     */
    private boolean alwaysInSameComputer;
    /**
     * This identifies the user
     */
    private int idUser;
    /**
     * The email account of the user
     */
    private email.EmailAccount emailAccount;
    /**
     * The computer that the user is using in this moment
     */
    private Computer computer;

    public User(boolean alwaysInSameComputer, int idUser, network.ServerEmails serverEmail) {
        this.alwaysInSameComputer = alwaysInSameComputer;
        this.idUser = idUser;
        emailAccount = new EmailAccount(serverEmail, idUser);
    }

    public void sendEmail(int to, String msg, Object attach) {
        emailAccount.sendEmail(msg, computer.getTask().taskAttachEmail(attach), idUser, to);
    }

    /**
     * Reads an email
     */
    public void readEmail() {
        Message m = emailAccount.readEmail();
        computer.getTask().taskReadEmail(m);
    }

    /**
     * Reads an email
     */
    public void readAllEmails() {
        ArrayList<Message> emails = emailAccount.readAllEmails();
        for (Message email : emails) {
            computer.getTask().taskReadEmail(email);

        }
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public String toString() {
        String t;
        if (computer != null) {
            t = "UserID: " + idUser + "->" + emailAccount.getContactsAsString() + ", \t" + getComputer().toString() + ", Owner: " + alwaysInSameComputer;
        } else {
            t = "UserID: " + idUser + ", \tcurrent Computer: Not assigned";
        }

        return t;
    }

    public boolean isAlwaysInSameComputer() {
        return alwaysInSameComputer;
    }

    public void setAlwaysInSameComputer(boolean alwaysInSameComputer) {
        this.alwaysInSameComputer = alwaysInSameComputer;
    }

    public email.EmailAccount getEmailAccount() {
        return emailAccount;
    }

}
