package experiment1;

public class Producer {
    private int storage;
    private static final int MAX = 10;

    Producer() {
        new Thread(() -> {
            while (true) {
                produce();
            }
        }).start();
    }

    private void produce() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            if (this.storage < 10){
                this.storage++;
                System.out.println("A product has been produced!My storage: "+ this.storage);
            }
        }
    }

    public synchronized void releaseStorage() throws Exception {
        if(this.storage<0) throw new Exception("no Storage!!!!!!!!");
        this.storage--;
        System.err.println("A product has been consumed!My storage: "+ this.storage);
    }

    public boolean hasStorage() {
        return storage > 0;
    }
}
