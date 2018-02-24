package robotAssembly;

import java.util.Random;

public final class RandomUtil {

    private final static Random RANDOM = new Random();
    private  final static int DEFAULT_BOUND = 20;

    private RandomUtil() {
    }

    public static int nextInt() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
