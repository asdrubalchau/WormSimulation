/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

/**
 * Universidad Autónoma del Estado de México CU UAEM Zumpango Ingeniería en
 * Computación
 *
 * @author asdruballopezchau
 */
public class Message {

    private String msg;
    private Object attach;
    private int from;
    private int to;

    public String toString() {
        String r =   "From " + from + ", To " + to + "\t Message: " + msg + ", " + "attach: " + attach;
        return r;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getAttach() {
        return attach;
    }

    public void setAttach(Object attach) {
        this.attach = attach;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
