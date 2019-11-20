/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import email.EmailAccount;
import email.Message;
import java.util.ArrayList;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class ServerEmails {

    java.util.ArrayList<email.EmailAccount> accounts=new ArrayList<>();

    public void addAccount(email.EmailAccount account) {
        accounts.add(account);
    }

    public void sendEmail(int from, int to, Message message) {
        for (EmailAccount acc : accounts) {
            if (acc.getIdOwner() == to) {
                acc.getReceived().add(message);//break;
            }
        }
    }
}
