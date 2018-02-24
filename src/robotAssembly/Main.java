package robotAssembly;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Dump dump = new Dump();
        Scientist scientist1 = new Scientist("Ученый_1");
        Scientist scientist2 = new Scientist("Ученый_2");
        ServantThread servant1 = new ServantThread("слуга_1", dump, scientist1);
        ServantThread servant2 = new ServantThread("слуга_2", dump, scientist2);

        servant1.start();
        servant2.start();

        servant1.join();
        servant2.join();

        System.out.println(scientist1.getRobots());
        System.out.println(scientist2.getRobots());

        System.out.println(ChampionUtil.getCountRobots(scientist1));
        System.out.println(ChampionUtil.getCountRobots(scientist2));
        System.out.println(ChampionUtil.determineChampion(scientist1,scientist2).getName());
    }
}
