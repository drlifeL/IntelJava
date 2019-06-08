package java核心技术1.ThreadStudy_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院
 */
public class SynCinema {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(5);


        CinemaSelect c = new CinemaSelect(list, "dxxy");
        new Thread(new HappyCustomer(c, list1)).start();
        new Thread(new HappyCustomer(c, list2)).start();
    }
}

//顾客
class HappyCustomer implements Runnable {

    CinemaSelect cinema;
    List<Integer> seats;

    public HappyCustomer(CinemaSelect cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为：" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不够");
            }
        }
    }

}


//影院,带有位置选择
class CinemaSelect {
    List<Integer> available;//可用的位置
    String name;//名称

    public CinemaSelect(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTickets(List<Integer> seats) {
        System.out.println("可用位置为:" + available);
        List<Integer> copy = new ArrayList<>(available);
        copy.removeAll(seats);
        if (copy.size() != available.size() - seats.size()) {
            return false;
        }
        available = copy;
        return true;

    }


}