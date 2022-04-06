package per.zzz.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/6 19:36
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                stack.push(map.get(s.charAt(i)));
            }else {
                if(stack.empty()){
                    return false;
                }
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
