package per.zzz.algorithm.other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/7 17:21
 */
public class EmptyBottle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Integer.parseInt(s, 16));
    }


    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        while ((x = scanner.nextInt()) != 0) {
            list.add(x);
        }

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            int number = list.get(i);
            while (number >= 3) {
                count += number / 3;
                number = number % 3 + number / 3;
            }
            if (number == 2) {
                count += 1;
            }
            System.out.println(count);
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        List<Integer> temp = new ArrayList<>(numbers);
        Collections.sort(temp);
        temp.forEach(System.out::println);
    }

}
