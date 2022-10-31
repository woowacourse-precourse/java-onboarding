package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String[] crypto;
        crypto = word.split("");
        String answer = "";
        for (int i = 0; i < crypto.length; i++) {
            if (crypto[i].equals(" ")){
                answer += " ";
            } else {
                char c = crypto[i].charAt(0);
                int decode = (int)(c);
                if (Character.isUpperCase(c)){
                    int key = 65;
                    int value = 90;
                    int new_key = decode - key;
                    int new_value = value - new_key;
                    char real_ch = (char)new_value;
                    answer += real_ch;

                } else {
                    int key = 97;
                    int value = 122;
                    int new_key = decode - key;
                    int new_value = value - new_key;
                    char real_ch = (char)new_value;
                    answer += real_ch;
                }
            }

        }

        return answer;
    }
}
