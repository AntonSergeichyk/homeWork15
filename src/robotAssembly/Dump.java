package robotAssembly;

import java.util.LinkedList;
import java.util.Queue;

public class Dump {

    private Queue<Detail> listDetails = new LinkedList<>();

    public Dump() {
        addDetail(RandomUtil.nextInt());
    }

    public void addDetail(int countDetails) {
        for (int i = 0; i < countDetails; i++) {
            listDetails.offer(getDetail());
        }
    }

    public Detail getDetail() {
        Detail detail = null;

        switch (RandomUtil.nextInt(9)) {
            case 0:
                detail = Detail.BODY;
                break;
            case 1:
                detail = Detail.CPU;
                break;
            case 2:
                detail = Detail.HDD;
                break;
            case 3:
                detail = Detail.HEAD;
                break;
            case 4:
                detail = Detail.LEFT_ARM;
                break;
            case 5:
                detail = Detail.LEFT_FOOT;
                break;
            case 6:
                detail = Detail.RAM;
                break;
            case 7:
                detail = Detail.RIGHT_ARM;
                break;
            case 8:
                detail = Detail.RIGHT_FOOT;
                break;
            default:
                System.out.println("неизвестная деталь");
                break;
        }

        return detail;
    }

    public void setListDetails(Queue<Detail> listDetails) {
        this.listDetails = listDetails;
    }

    public Queue<Detail> getListDetails() {

        return listDetails;
    }
}
