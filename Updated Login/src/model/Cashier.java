package model;

public class Cashier extends StaffUser{

    private String cashierID;

    public Cashier(){
        super();
    }


    public String getCashierID() {
        return cashierID;
    }

    public void setCashierID(String cashierID) {
        this.cashierID = cashierID;
    }
}
