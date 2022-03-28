package per.zzz.algorithm.huawei;

import com.sun.javafx.collections.MappingChange;

import java.util.*;
public class LastWordLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][] goods = new int[m][3];
        for (int i = 0; i < m; i++) {
//            goods[0] = new
        }
    }

    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long num = scanner.nextLong();
        String numStr = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numStr.length() - 1 ; i > -1 ; i--) {
            if(stringBuilder.indexOf(numStr.charAt(i) + "") < 0){
                stringBuilder.append(numStr.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            Integer key = scanner.nextInt();
            Integer value = scanner.nextInt();
            map.merge(key, value, Integer::sum);
        }
        ArrayList<Integer> sortKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortKeys);
        sortKeys.forEach(i -> {
            System.out.println(i + " " + map.get(i));
        });
    }

    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Math.round(scanner.nextDouble()));
    }


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


    public static void main3(String[] args) {
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

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String str = scanner.nextLine();
            if(str.length() == 0){
                continue;
            }
            for (int i = 0; i < ((str.length() - 1) / 8 + 1) * 8; i++) {
                if(i < str.length()){
                    System.out.print(str.charAt(i));
                }else {
                    System.out.print("0");
                }
                if(i > 0 && (i + 1)  % 8 == 0){
                    System.out.println();
                }
            }
        }
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = Integer.parseInt(s.replaceFirst("0x", ""), 16);
        System.out.println(i);
    }
}
