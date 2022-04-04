package per.zzz.algorithm.paper;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(scanner.nextInt());
        }

        Collections.sort(nums);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        while (set.size() < nums.size()){
            for (int i = 0; i < N; i++) {
                if (!set.contains(i)){
                    set.add(i);
                    for (int j = i + 1; j < N; j++) {
                        if (!set.contains(j) && (nums.get(j) % nums.get(i) == 0)){
                            set.add(j);
                        }
                    }
                    count ++;
                }
            }
        }

        System.out.println(count);
    }
}
