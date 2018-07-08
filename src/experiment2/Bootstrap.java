package experiment2;

import java.util.LinkedList;
import java.util.Queue;

public class Bootstrap {
    private static ProcessControlBlock[] pcbArray = new ProcessControlBlock[5];
    public static void main(String[] args) {
        int CPUTime = 0;
        Queue<ProcessControlBlock> pcbQueue = new LinkedList<>();
        ProcessControlBlock t1 = new ProcessControlBlock("thread-1");
        ProcessControlBlock t2 = new ProcessControlBlock("thread-2");
        ProcessControlBlock t3 = new ProcessControlBlock("thread-3");
        ProcessControlBlock t4 = new ProcessControlBlock("thread-4");
        ProcessControlBlock t5 = new ProcessControlBlock("thread-5");
        pcbArray[0] = t1;
        pcbArray[1] = t2;
        pcbArray[2] = t3;
        pcbArray[3] = t4;
        pcbArray[4] = t5;
        pcbQueue.add(t1);
        pcbQueue.add(t2);
        pcbQueue.add(t3);
        pcbQueue.add(t4);
        pcbQueue.add(t5);

        ProcessControlBlock currentThread;
        while (pcbQueue.size() > 0) {
            CPUTime++;
            currentThread = pcbQueue.poll();
            currentThread.setState(ProcessControlBlock.WORKING);
            printStatus();
            currentThread.run();
            currentThread.setState(ProcessControlBlock.READY);
            if (!currentThread.isEnd()) {
                pcbQueue.add(currentThread);
            } else {
                currentThread.setState(ProcessControlBlock.FINISH);
            }
        }
        printStatus();
    }

    private static void printStatus() {
        System.out.println("name      spentTime needTime state");
        for(ProcessControlBlock t:pcbArray){
            System.out.println(t);
        }
    }
}
