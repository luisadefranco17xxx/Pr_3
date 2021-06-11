package Thread.Person;

public class Main {
    public static void main(String[] args){
        Runnable person1=new Person("Name");
        Runnable person2=new Person("NameNeu");

        Thread thread1=new Thread(person1);
        Thread thread2=new Thread(person2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Ende " );
    }
}
