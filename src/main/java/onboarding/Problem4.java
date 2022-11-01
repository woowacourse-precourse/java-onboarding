package onboarding;

import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        //z = a + 25
        //e = a + 5
        //v = a + 21
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                c = arr['Z' - c];
            } else if (c <= 'z' && c >= 'a') {
                c -= 32;
                c = arr['Z' - c];
                c += 32;
            }
            answer += c;
        }
        return answer;
    }
}
