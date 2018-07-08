package experiment1;

public class Bootstrap {
    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c1 = new Consumer(p);
        Consumer c2 = new Consumer(p);
        Consumer c3 = new Consumer(p);
    }
}
