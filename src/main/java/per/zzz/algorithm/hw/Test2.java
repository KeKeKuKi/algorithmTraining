package per.zzz.algorithm.hw;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            words.add(scanner.nextLine());
        }
        List<String> topKString = getTopKString(2, words);
        topKString.forEach(System.out::println);
    }

    public static List<String> getTopKString(int k, List<String> strList){
        // 统计单词数
        Map<String, Integer> map = new HashMap<>();
        strList.forEach(i -> {
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        });
        // 个数排序
        List<Integer> keys = map.values().stream().sorted().collect(Collectors.toList());

        // 返回最大单词数
        List<String> ans = new ArrayList<>(k);
        int max = keys.size() -1;
        for (int i = 0; i < k; i++) {
            int finalMax = max;
            map.forEach((key, value) -> {
                if (value.equals(keys.get(finalMax))) {
                    ans.add(key);
                }
            });
            if (ans.size() >= k){
                ans.sort(String::compareTo);
                return ans;
            }
            max --;
        }
        ans.sort(String::compareTo);
        return ans;
    }

}
