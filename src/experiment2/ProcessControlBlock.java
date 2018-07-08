package experiment2;

import java.util.Random;

public class ProcessControlBlock {
    public static final int FINISH = 0;
    public static final int READY = 1;
    public static final int WORKING = 2;

    private String name;
    private ProcessControlBlock thisPCB;
    private int wannaMillisecond;
    private int spentMillisecond;
    private int state;

    public ProcessControlBlock(String name) {
        this.name = name;
        this.thisPCB = this;
        this.wannaMillisecond = generateWannaTime();
        this.state = READY;
    }

    public String getStateString() {
        return state == FINISH ?
                "finish" :
                state == READY ?
                        "ready" :
                        "working";
    }

    @Override
    public String toString() {
        return this.name + " "
                + String.format("%10d",spentMillisecond) + " "
                + String.format("%8d",wannaMillisecond) + " "
                + this.getStateString();
    }

    public void run() {
        this.spentMillisecond++;
        this.wannaMillisecond--;
    }

    private int generateWannaTime() {
        Random random = new Random();
        int randomTime = random.nextInt(10);
        System.out.println("I wanna time is" + randomTime + " millisecond");
        return randomTime + 1;
    }

    public boolean isEnd() {
        return wannaMillisecond == 0;
    }

    public int getWannaMillisecond() {
        return wannaMillisecond;
    }

    public void setState(int state) {
        this.state = state;
    }
}
