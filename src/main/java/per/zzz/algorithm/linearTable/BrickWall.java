package per.zzz.algorithm.linearTable;

import java.util.*;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/1 18:14
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        final int[] max = {0};
        List<Integer> map = new ArrayList<>();
        int tar = 0;
        for (int i = 0; i < wall.get(0).size(); i++) {
            tar += wall.get(0).get(i);
        }
        if(tar == 1){
            return wall.size();
        }
        for (List<Integer> integers : wall) {
            int pos = 0;
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; pos < tar; j++) {
                pos += integers.get(j);
                if(pos != tar){
                    sub.add(pos);
                }
            }
            map.addAll(sub);
        }

        Map<Integer, Integer> his = new HashMap<>();
        map.forEach(i -> his.merge(i, 1, Integer::sum));

        his.forEach((key, value) -> {
            if (value > max[0]) {
                max[0] = value;
            }
        });
        return wall.size() - max[0];
    }
}
