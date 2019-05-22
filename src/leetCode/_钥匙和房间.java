package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _钥匙和房间 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);

        System.out.println(canVisitAllRooms(rooms));
        int []a = new int[10];
        System.out.println(a.length);
    }

    static boolean vis[];

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        vis = new boolean[rooms.size()];

        List<Integer> temp = rooms.get(0);
        vis[0] = true;
        for (int j = 0; j < temp.size(); j++) {
            int cur = temp.get(j);
            if (!vis[cur]) {
                vis[cur] = true;
                dfs(rooms, cur);
            }
        }

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(List<List<Integer>> rooms, int curRoom) {
        List<Integer> room = rooms.get(curRoom);
        for (int i = 0; i < room.size(); i++) {
            int temp = room.get(i);
            if (!vis[temp]) {
                vis[temp] = true;
                dfs(rooms, temp);
            }
        }
    }

}
