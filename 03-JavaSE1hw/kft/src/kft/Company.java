/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam
 */
public class Company {
    private String name;
    private String address;
    private int wealth;
    private List<Activity> activities = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();
    private List<Boss> bosses = new ArrayList<>();
    
    public Company(String address, String name, int wealth) {
        this.address = address;
        this.name = name;
        this.wealth = wealth;
    }
    
    public Company(String address, String name, int wealth, 
            List<Activity> activities, List<Worker> workers, List<Boss> bosses) {
        this.address = address;
        this.name = name;
        this.wealth = wealth;
        this.activities = activities;
        this.workers = workers;
        this.bosses = bosses;
    }
    
    public void addWorker(Worker worker) {
        this.workers.add(worker);
        worker.setCompany(this);
    }
    
    public void removeWorker(Worker worker) {
        this.workers.remove(worker);
        System.out.println(worker.getName() + " (worker) has left the company.");
    }
    
    public void listWorkers() {
        System.out.println("Workers:");
        for(Worker w : workers) {
            System.out.println("Name: " + w.getName() + "\nDate of birth: " + w.getBirthdate() + 
                    "\nWealth: " + w.getWealth() + "\nSalary: " + w.getSalary() + "\n");
        }
    }
    
    public void addBoss(Boss boss) {
        this.bosses.add(boss);
        boss.setCompany(this);
    }

    public void removeBoss(Boss boss) {
        this.bosses.remove(boss);
        System.out.println(boss.getName() + " (boss) has left the company.");
    }
    
    public void listBosses() {
        System.out.println("Bosses:");
        for(Boss b : bosses) {
            System.out.println("Name: " + b.getName() + "\nDate of birth: " + b.getBirthdate() + 
                    "\nWealth: " + b.getWealth() + "\nSalary: " + b.getSalary()+ "\n");
        }
    }
    
    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
    
    public void askForWork() {
        for(Boss b : bosses) {
            b.doWork();
        }
        for(Worker w : workers) {
            w.doWork();
        }
        System.out.println();
    }
    
    public void givePayments() {
        for(Worker w : workers) {
            if(this.wealth > w.getSalary()) {
                w.receivePayment();
            }  
        }
        for(Boss b : bosses) {
            if(this.wealth > b.getSalary()) {
                b.receivePayment();
            }
        }        
    }
}
