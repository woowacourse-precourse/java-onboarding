package onboarding;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem4 {
    public static String solution(String word) {

        char[] arr = word.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        HashMap<Character, Character> upperAlphet = new HashMap<Character,Character>();
        HashMap<Character, Character> lowerAlphet = new HashMap<Character,Character>();

        for (int k = 0; k < arr.length; k++) {
            list.add(arr[k]);
        }

        for(int i=0; i<26; i++){
            upperAlphet.put((char) ('A'+i), (char) ('Z'-i));
        }

        for(int k=0; k<26; k++){
            lowerAlphet.put((char) ('a'+k), (char) ('z'-k));
        }






        String answer = "";


        return answer;
    }
}

