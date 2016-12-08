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
public class Boss extends Human {
    
    public Boss(String name, String birthdate, int salary) {
        super(name, birthdate, 5000, salary);
    }
        
    public Boss(String name, String birthdate, int wealth, int salary) {
        super(name, birthdate, wealth, salary);
    }
            
    @Override
    public void doWork() {
        System.out.println(this.getName() + " is giving orders now.");
    }
    
    @Override
    public void quitJob() {
        this.getCompany().removeBoss(this);
    }
    
    public void getWorkerFired(Worker worker) {
        this.getCompany().removeWorker(worker);
    }
}
