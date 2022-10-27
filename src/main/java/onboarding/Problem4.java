package onboarding;

import java.util.ArrayList;
import java.util.Collections;


public class Problem4 {
    static ArrayList<Integer> InitAscii() {
        ArrayList<Integer> result = new ArrayList<>(
                Collections.nCopies(256, -1)
        );
        for (int i = 0; i < 26; i++) {
            result.set('A'+i, 'A'+25-i);
            result.set('a'+i, 'a'+25-i);
        }
        return result;
    }

    public static String solution(String word) {
        String answer = "";
        ArrayList<Integer> ascii_array;

        ascii_array = InitAscii();

        return answer;
    }

    public static void main(String argv[]){

        solution("asdasd");
    }
}
