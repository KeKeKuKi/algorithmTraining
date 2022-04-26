package per.zzz.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/6 19:07
 */
public class RomaToNumber {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        Map<String, Integer> specialMap = new HashMap<>();
        specialMap.put("IV", 4);
        specialMap.put("IX", 9);
        specialMap.put("XL", 40);
        specialMap.put("XC", 90);
        specialMap.put("CD", 400);
        specialMap.put("CM", 900);

        if (specialMap.containsKey(s)) {
            return specialMap.get(s);
        }
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if(i == s.length() - 1){
                sum += map.get(s.charAt(i));
                return sum;
            }
            char fi = s.charAt(i);
            char se = s.charAt(i + 1);
            if (specialMap.containsKey(fi + String.valueOf(se))){
                sum += specialMap.get(fi + String.valueOf(se));
                i++;
            }else {
                sum += map.get(fi);
            }
        }
        return sum;
    }
}
