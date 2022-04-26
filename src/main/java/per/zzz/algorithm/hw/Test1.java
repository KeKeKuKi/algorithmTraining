package per.zzz.algorithm.hw;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] trust = new int[n][2];

        for (int i = 0; i < n; i++) {
            trust[i][0] = scanner.nextInt();
            trust[i][1] = scanner.nextInt();
        }

        System.out.println(fun2(n, trust));
    }


    public static Boolean fun(String str){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                stack.push(map.get(str.charAt(i)));
            }else {
                if (stack.pop() != str.charAt(i)){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static Integer fun2(int n ,int [][] trust){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i + 1);
        }
        for (int i = 0; i < trust.length; i++) {
            if (set.contains(trust[i][0])){
                set.remove(trust[i][0]);
            }
        }
        if (set.size() == 1){
            return (Integer) set.toArray()[0];
        }
        return -1;
    }


}
