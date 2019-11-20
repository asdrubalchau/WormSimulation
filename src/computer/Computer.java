/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;

import malware.Malware;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class Computer {
    /**
     * The number of computer, to identify it.
     */
    private int idComputer;
    /**
     * This simulates the operating system email services
     */
    private TaskOperatingSystem task;

    //In this constructor we simulated if a computer 
    //is infected at the beginning
    public Computer(int idComputer, boolean beginsInfected) {
        this.idComputer = idComputer;
        
        if (beginsInfected) {
            task = new Malware();
        } else {
            task = new TaskOperatingSystem();
        }
        task.setComputer(this);
    }
    
    public int getIdComputer() {
        return idComputer;
    }
    
    public void setIdComputer(int idComputer) {
        this.idComputer = idComputer;
    }
    
    public TaskOperatingSystem getTask() {
        return task;
    }
    
    public void setTask(TaskOperatingSystem task) {
        this.task = task;
    }
    
    @Override
    public String toString() {
        return "Computer{" + "id: " + idComputer + "\t, SO: " + task + '}';
    }
    
}
