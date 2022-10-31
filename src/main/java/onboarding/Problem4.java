package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            if(isUpper((int) word.charAt(i)) == 1) {
                answer += (char)(155 - (int)word.charAt(i));
            } else if(isUpper((int) word.charAt(i)) == 0) {
                answer += (char)(219 - (int)word.charAt(i));
            } else {
                answer += word.charAt(i);
            }
        }

        return answer;
    }

    public static int isUpper (int a) {
        if(a > 96 && a < 122)
            return 0;
        else if(a > 64 && a < 91)
            return 1;
        else
            return -1;
    }
}
