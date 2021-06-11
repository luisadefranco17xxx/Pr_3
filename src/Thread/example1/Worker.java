package Thread.example1;


public class Worker implements Runnable {
    private boolean isRunning = true;  // cosi user puo stoppare il thread dall´estereno
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    private char sign;

//    public Worker(char sign) {
//        this.sign = sign;
//    }

    public void requestShutDown() {
        isRunning = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (isRunning) {
                System.out.println(name + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                break;
            }
        }
    }


}