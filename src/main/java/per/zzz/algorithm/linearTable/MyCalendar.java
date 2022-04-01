package per.zzz.algorithm.linearTable;

import java.util.*;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/1 17:45
 */
public class MyCalendar {
    List<Map<String, String>> map;

    public MyCalendar() {
        map = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Map<String, String> i: map) {
            if((start < Integer.parseInt(i.get("end")) && start >= Integer.parseInt(i.get("start"))) ||
                    (end <= Integer.parseInt(i.get("end")) && end > Integer.parseInt(i.get("start"))) ||
                    (start <= Integer.parseInt(i.get("start")) && end >= Integer.parseInt(i.get("end")))){
                return false;
            }
        }
        Map<String, String> book = new HashMap<>();
        book.put("start", start+"");
        book.put("end", end+"");
        map.add(book);
        return true;
    }
}
