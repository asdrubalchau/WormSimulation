/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;

import email.Message;
import malware.Malware;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class TaskOperatingSystem {

    /**
     * Vinculated to a computer
     */
    private Computer computer;
    private network.NetworkComputers network;

    public String taskReadEmail(Message m) {
        if (m != null && m.getAttach() != null) {
            if (m.getAttach() instanceof malware.Malware) {//Here the infection takes place
                if (computer != null) {
                    computer.setTask(new Malware());
                }
            } else {
            }
        }
        //System.out.println(m);//Prints the message
        return m.toString();

    }

    public Object taskAttachEmail(Object attach) {
        return attach;

    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public String toString() {
        return "Health";
    }

}
