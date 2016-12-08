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
public class Worker extends Human {
    
    public Worker(String name, String birthdate, int salary) {
        super(name, birthdate, 1000, salary);
    }
    
    public Worker(String name, String birthdate, int wealth, int salary) {
        super(name, birthdate, wealth, salary);
    }
    
    @Override
    public void doWork() {
        System.out.println(this.getName() + " is working now.");
    }
    
    @Override
    public void quitJob() {
        this.getCompany().removeWorker(this);
    }
}
