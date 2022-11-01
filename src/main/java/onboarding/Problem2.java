package onboarding;
import java.util.HashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer str = new StringBuffer(cryptogram);
        Set<Integer> set;
        Integer[] arr;
        String answer;
        while(true){
            set = new HashSet<>();
            setSet(str, set);
            arr = set.toArray(new Integer[0]);
            if (isLenZero(arr)) break;
            delOverlapChar(str, arr);
        }
        answer = new String(str);
        return answer;
    }
    private static void setSet(StringBuffer str, Set<Integer> set) {
        for(int i = 0; i< str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i + 1)){
                set.add(i);
                set.add(i + 1);
            }
        }
    }
    private static boolean isLenZero(Integer[] arr) {
        if(arr.length == 0){
            return true;
        }
        return false;
    }
    private static void delOverlapChar(StringBuffer str, Integer[] arr) {
        for(int i = arr.length-1; i>=0; i--){
            str.deleteCharAt(arr[i]);
        }
    }
}
