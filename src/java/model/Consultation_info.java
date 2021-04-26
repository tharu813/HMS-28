/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author THARUSHI
 */
public class Consultation_info {

    private String consultation_id;
    private int fee;
    Time time;
    Date date;

    public Consultation_info(String consultation_id, int fee, Time time, Date date) {
        this.consultation_id = consultation_id;
        this.fee = fee;
        this.time = time;
        this.date = date;
    }

    public void setConsultation_id(String consultation_id) {
        this.consultation_id = consultation_id;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getConsultation_id() {
        return consultation_id;
    }

    public int getFee() {
        return fee;
    }

    public Time getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }
    
    

}
