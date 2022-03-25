package per.zzz.algorithm.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/25 17:31
 */
public class LastWordLength {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String a = scanner.nextLine();
        s.toLowerCase();
        int length = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ' '){
                System.out.println(length);
                return;
            }
            length ++;
        }
        System.out.println(length);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String a = scanner.nextLine();
        s = s.toLowerCase();
        a = a.toLowerCase();
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == a.charAt(0)){
                sum ++;
            }
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < size; i++) {
            numbers.add(scanner.nextInt());
        }
        List<Integer> num = new ArrayList<>(numbers);
        Collections.sort(num);
        num.forEach(System.out::println);
    }
}
