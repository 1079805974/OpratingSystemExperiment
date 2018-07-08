package experiment1;

public class Consumer {
    private Producer producer;

    Consumer(Producer producer) {
        this.producer = producer;
        new Thread(() -> {
            while (true) {
                consume();
            }
        }).start();
    }

    private void consume() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (producer) {
            if (this.producer.hasStorage()) {
                try {
                    this.producer.releaseStorage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("emmm...There is nothing!");
            }
        }
        //System.out.println("A product has been consumed!");
    }
}
