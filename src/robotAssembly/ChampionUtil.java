package robotAssembly;

import java.util.Optional;

public final class ChampionUtil {

    private ChampionUtil() {
    }

    public static Scientist determineChampion(Scientist scientist1, Scientist scientist2) {
        if (Integer.compare(getCountRobots(scientist1), getCountRobots(scientist2)) > 0) {
            return scientist1;
        } else{
            return scientist2;
        }
    }

    public static int getCountRobots(Scientist scientist) {
        Optional<Integer> countRobots = scientist.getRobots().values().stream()
                .min(Integer::compareTo);

        return countRobots.get();
    }
}
