package per.zzz.algorithm.string;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/19 15:11
 */
public class ClosestChar {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c){
                list.add(i);
            }
        }
        int [] ans = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ans[i] = closest(list, i);
        }
        return ans;
    }

    Integer closest(List<Integer> map, Integer point){
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        map.forEach(i -> {
            int abs = Math.abs(point - i);
            min.set(Math.min(abs, min.get()));
        });
        return min.get();
    }
}
