package com.example.shivam.shivamsood_comp304_assignment4;

public class Order_obj {

    private int employeeID;
    private String userName, password, firstName, lastName;

    //Construtor
    public Order_obj(){}
    public Order_obj(int employeeID, String userName, String password, String firstName, String lastName)
    {
        this.employeeID = employeeID; this.userName = userName;
        this.password = password; this.firstName = firstName;
        this.lastName = lastName;

    }
    //setter
    public void setemployeeID(int employeeID){this.employeeID = employeeID; }
    public void setuserName(String userName){this.userName = userName; }
    public void setpassword(String password){this.password = password; }
    public void setfirstName(String firstName){this.firstName = firstName; }
    public void setlastName(String lastName){this.lastName = lastName; }
    //getter
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
}
