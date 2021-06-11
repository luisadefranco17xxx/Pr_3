package Thread.Uebung_Schluss;

import java.io.IOException;

public abstract class Worker {
    protected String name;
    protected boolean shouldRun;

    public Worker(String name) {
        this.name = name;
        this.shouldRun = true;
    }


    protected abstract void work()  throws InterruptedException, IOException;


    public String getName() {
        return name;
    }

    public boolean isShouldRun() {
        return shouldRun;
    }

    protected void printStarted(){

        System.out.println(this.name+" wurde gestarted");
    }

    protected void printStopped() {

        System.out.println(this.name+" wurde gestoppt");
    }

    public void stopWorker(){

        this.shouldRun=false;
    }
}
