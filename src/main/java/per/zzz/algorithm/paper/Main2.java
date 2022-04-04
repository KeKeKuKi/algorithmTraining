package per.zzz.algorithm.paper;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tar = scanner.nextLine();
        String all = scanner.nextLine();

        int p = tar.length() - 1;
        int i = all.length() - 1;
        while (p >= 0 && i >= 0){
            if (all.charAt(i) == tar.charAt(p)){
                p--;
                if(p < 0){
                    System.out.println(i);
                    return;
                }
            }
            i--;
        }
        System.out.println(-1);
    }
}
