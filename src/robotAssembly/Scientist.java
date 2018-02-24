package robotAssembly;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Scientist {

    private Map<Detail, Integer> robots = new HashMap<>();
    private String name;

    public Scientist(String name) {
        this.name = name;
    }

    public void getDetailsFoRobot(Queue<Detail> foundDetails) {
        for (Detail detail : foundDetails) {
            robots.merge(detail, 1, (a, b) -> a + b);
            foundDetails.clear();
        }
    }

    public String getName() {
        return name;
    }

    public Map<Detail, Integer> getRobots() {
        return robots;
    }
}
