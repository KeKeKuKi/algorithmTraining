package per.zzz.algorithm.other;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CircleNumberWin {
    public static int findTheWinner(int n, int k) {
        if (n == 1){
            return 1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int step = k;
        while (list.size() > 1){
            int po = k % list.size();
            int index = po - 1;
            if (index < 0){
                list.remove(list.size() - 1);
                k = step;
                continue;
            }
            list.remove(index);
            k = index + step;
        }
        return list.get(0) + 1;
    }

    public static void main(String[] args) {
        findTheWinner(5,2);
    }
}
