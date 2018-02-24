package robotAssembly;

import java.util.LinkedList;
import java.util.Queue;

public class ServantThread extends Thread {

    public static final int PERIOD_OF_TIME = 10000;
    public static final int MAX_COUNT_DETAIL = 4;
    private Queue<Detail> foundDetails = new LinkedList<>();
    private Dump dump;
    private Scientist scientist;

    public ServantThread(String name, Dump dump, Scientist scientist) {
        super(name);
        this.dump = dump;
        this.scientist = scientist;
    }

    @Override
    public void run() {
        Long startTime = System.currentTimeMillis();
        Long endTime = System.currentTimeMillis();
        while (endTime - startTime < PERIOD_OF_TIME) {
            System.out.println(getName() + " пришел на свалку");
            synchronized (dump.getListDetails()) {
                while (!dump.getListDetails().isEmpty() && foundDetails.size() < MAX_COUNT_DETAIL) {
                    foundDetails.offer(dump.getListDetails().poll());
                    System.out.println(getName() + " нашел запчасть");
                    try {
                        dump.getListDetails().wait(RandomUtil.nextInt(5) + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            scientist.getDetailsFoRobot(foundDetails);
            System.out.println(getName() + " отдал запчасти ученому:"+scientist.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Night.newNight(dump);
            endTime = System.currentTimeMillis();
        }
    }
}