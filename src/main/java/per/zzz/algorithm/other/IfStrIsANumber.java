package per.zzz.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/10 10:41
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个小数或者整数
 * （可选）一个'e'或'E'，后面跟着一个整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d6vi6/
 * 来源：力扣（LeetCode）
 */
public class IfStrIsANumber {
    /**
     *
     *解题思路：
     * 本题使用有限状态自动机。根据字符类型和合法数值的特点，先定义状态，再画出状态转移图，最后编写代码即可。
     *
     * 字符类型：
     *
     * 空格 「 」、数字「 0—90—9 」 、正负号 「 ++, -− 」 、小数点 「 .. 」 、幂符号 「 ee, EE 」 。
     *
     * 状态定义：
     *
     * 按照字符串从左到右的顺序，定义以下 9 种状态。
     *
     * 开始的空格
     * 幂符号前的正负号
     * 小数点前的数字
     * 小数点、小数点后的数字
     * 当小数点前为空格时，小数点、小数点后的数字
     * 幂符号
     * 幂符号后的正负号
     * 幂符号后的数字
     * 结尾的空格
     * 结束状态：
     *
     * 合法的结束状态有 2, 3, 7, 8 。
     *算法流程：
     * 初始化：
     *
     * 状态转移表 states ： 设 states[i] ，其中 i 为所处状态， states[i] 使用哈希表存储可转移至的状态。键值对 (key, value) 含义：输入字符 key ，则从状态 i 转移至状态 value 。
     * 当前状态 p ： 起始状态初始化为 p = 0 。
     * 状态转移循环： 遍历字符串 s 的每个字符 c 。
     *
     * 记录字符类型 t ： 分为四种情况。
     * 当 c 为正负号时，执行 t = 's' ;
     * 当 c 为数字时，执行 t = 'd' ;
     * 当 c 为 e 或 E 时，执行 t = 'e' ;
     * 当 c 为 . 或 空格 时，执行 t = c （即用字符本身表示字符类型）;
     * 否则，执行 t = '?' ，代表为不属于判断范围的非法字符，后续直接返回 falsefalse 。
     * 终止条件： 若字符类型 t 不在哈希表 states[p] 中，说明无法转移至下一状态，因此直接返回 falsefalse 。
     * 状态转移： 状态 p 转移至 states[p][t] 。
     * 返回值： 跳出循环后，若状态 p \in {2, 3, 7, 8}∈2,3,7,8 ，说明结尾合法，返回 truetrue ，否则返回 falsefalse 。
     *
     * 复杂度分析：
     * 时间复杂度 O(N)O(N) ： 其中 NN 为字符串 s 的长度，判断需遍历字符串，每轮状态转移的使用 O(1)O(1) 时间。
     * 空间复杂度 O(1)O(1) ： states 和 p 使用常数大小的额外空间。
     *
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dkal2/
     * 来源：力扣（LeetCode）
     */


    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap() {{ put('d', 3); }},                                        // 4.
                new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap() {{ put('d', 7); }},                                        // 6.
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
