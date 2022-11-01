package onboarding;

public class Problem3 {
    // 1. 문자열에서 특정 문자 개수를 센다.
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

}
