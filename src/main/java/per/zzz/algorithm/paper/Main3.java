package per.zzz.algorithm.paper;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int max = 0;
        int step = 0;
        int s = 0;
        int re = 0;
        int po = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if (s == 0){
                    s = 1;
                    step ++;

                }else {
                    step ++;
                }
                if (step > max){
                    max = step;
                }
            }else {
                if (s != 0){
                    if (po < 1){
                        po += 1;
                        re = i;
                    }else {
                        s = 0;
                        step  = 0;
                        po = 0;
                        i = re;
                    }

                }
            }
        }
        if (max == 0 || max == str.length()){
            System.out.println(-1);
        }else {
            System.out.println(max + 1);
        }

    }
}
