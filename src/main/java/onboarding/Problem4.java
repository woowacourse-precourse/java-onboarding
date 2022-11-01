package onboarding;

/***
 * 기능목록
 * 1. 입력 문자열 변환 기능
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer = alphaConversion(word);
    }

    public static String alphaConversion(String word) {
        String Alpa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String AlpaRev = "zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA";
        String ans = "";
        for (char c : word.toCharArray()) {
            if (Alpa.contains(Character.toString(c))) {
                int index = Alpa.indexOf(c);
                ans += AlpaRev.charAt(index);
            } else ans += c;
        }
        return ans;
    }
}
