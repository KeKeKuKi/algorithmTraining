package per.zzz.algorithm.slidingWindow;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/14 13:48
 */
public class IfSubstring {
    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0;i <s2.length();i++){
            if(s2.charAt(i) == s1.charAt(0)){
                if(s2.substring(i, s1.length() + i).equals(s1)){
                    return true;
                }
            }
        }
        return false;
    }
}
