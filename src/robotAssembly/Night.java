package robotAssembly;

public final class Night {

    private static boolean flag;

    private Night() {
    }

    public synchronized static void newNight(Dump dump) {
        if (!flag) {
            dump.addDetail(RandomUtil.nextInt(4) + 1);
            flag = true;
        } else {
            flag = false;
        }
    }
}
