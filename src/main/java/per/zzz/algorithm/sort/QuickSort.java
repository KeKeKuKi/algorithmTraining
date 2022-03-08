package per.zzz.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author 阿忠 2669918628@qq.com
 * @since 2022/2/14 16:39
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] num = {1, 5, 9, 6, 2, 3, 5, 8, 7, 2};
        System.out.println(Arrays.toString(qSort(num, 0, num.length - 1)));
    }

    public static int[] qSort(int[] numbers, int left, int right) {
        int i = left, j = right;
        int temp = numbers[i];
        while (i < j) {
            while (i < j && temp < numbers[j]) {
                j--;
            }
            while (i < j && temp > numbers[i]) {
                i++;
            }
            if (numbers[i] == numbers[j] && i < j) {
                i++;
            } else {
                int swap = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = swap;
            }
        }
        if(i - left > 1) numbers = qSort(numbers, left, i - 1);
        if(right - j > 1) numbers = qSort(numbers, j + 1, right);
        return numbers;
    }
}
