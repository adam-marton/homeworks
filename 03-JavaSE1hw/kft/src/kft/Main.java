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
public class Main {


    
    public static void main(String[] args) {
        Company company = new Company("Bad Company", "1111 Budapest, Summer street 11/1", 150000);
        company.addActivity(Activity.TECH_SHOP);
        Boss theboss = new Boss("Big Daddy", "1965.02.28.", 100000, 9876);
        Boss littleboss = new Boss("Little Jacob", "1980.12.31.", 7800);
        Worker worker1 = new Worker("John Hancock", "1993.10.10.", 600);
        Worker worker2 = new Worker("Peter Parker", "1962.08.01.", 200, 1100);
        Worker worker3 = new Worker("Tony Stark", "1963.03.01.", 3600, 1700);
        company.addBoss(theboss);
        company.addBoss(littleboss);
        company.addWorker(worker1);
        company.addWorker(worker2);
        company.addWorker(worker3);
        company.listBosses();
        company.listWorkers();
        company.askForWork();
        company.givePayments();
        theboss.getWorkerFired(worker1);
        worker2.quitJob();
        company.removeBoss(littleboss);
        company.listBosses();
        company.listWorkers();
    }
}
