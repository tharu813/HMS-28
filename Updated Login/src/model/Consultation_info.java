package model;

import java.sql.Date;
import java.sql.Time;

public class Consultation_info {

    private String consultation_id;
    private int fee;
    Time time;
    Date date;


    public Consultation_info(String consultation_id, int fee, Time time,Date date) {
        this.consultation_id = consultation_id;
        this.fee = fee;
        this.time =time;
        this.date =date;

    }

    public Consultation_info(){}

    public String getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(String consultation_id) {
        this.consultation_id = consultation_id;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
