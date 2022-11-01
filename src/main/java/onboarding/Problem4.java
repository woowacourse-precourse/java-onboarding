package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<String> alphabetLowerList = new ArrayList<>();
        List<String> alphabetUpperList = new ArrayList<>();
        List<String> alphabetList = new ArrayList<>();
        for(char i='a'; i<='z'; i++) {
            alphabetLowerList.add(String.valueOf(i));
        }
        for(char i='A'; i<='Z'; i++){
            alphabetUpperList.add(String.valueOf(i));
        }

        alphabetList.addAll(alphabetUpperList);
        alphabetList.add(" ");
        alphabetList.addAll(alphabetLowerList);

        List<Integer> pointList = new ArrayList<>();
        char[] words = word.toCharArray();
        for (char alphabet: words) {
            pointList.add(alphabetList.indexOf(String.valueOf(alphabet)));
        }
        List<String> reverseAlphabetList = new ArrayList<>();
        Collections.reverse(alphabetLowerList);
        Collections.reverse(alphabetUpperList);
        reverseAlphabetList.addAll(alphabetUpperList);
        reverseAlphabetList.add(" ");
        reverseAlphabetList.addAll(alphabetLowerList);

        String answer="";

        for (int point : pointList) {
            answer += reverseAlphabetList.get(point);
        }
        return answer;
    }

}

