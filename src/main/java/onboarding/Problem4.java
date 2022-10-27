package onboarding;

import org.mockito.stubbing.ValidableAnswer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.toCharArray()[i];

            if (Character.isLowerCase(ascii)) {
                if (ascii + 25 > 122) {
                    ascii = 122 - ((ascii + 25) % 122);
                }
            }

            if (Character.isUpperCase(ascii)) {
                if (ascii + 25 > 90) {
                    ascii = 90 - ((ascii + 25) % 90);
                }
            }

            list.add(ascii);
        }

        String answer = "";
        return answer;
    }
}
