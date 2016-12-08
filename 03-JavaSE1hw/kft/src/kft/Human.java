/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kft;

/**
 *
 * @author Adam
 */
public abstract class Human {
    private String name;
    private String birthdate;
    private int wealth;
    private int salary;
    private Company company;
    
    public Human(String name, String birthdate, int wealth, int salary) {
        this.name = name;
        this.birthdate = birthdate;
        this.wealth = wealth;
        this.salary = salary;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getBirthdate() {
        return this.birthdate;
    }
    
    public int getWealth() {
        return this.wealth;
    }
    
    public int getSalary() {
        return this.salary;
    }
    
    public void receivePayment() {
        this.wealth = this.wealth + this.salary;
    }
    
    public abstract void doWork();
    
    public abstract void quitJob();
    
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
}
