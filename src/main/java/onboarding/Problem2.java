package onboarding;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataValidationException;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";
        int count = 1;

        List<Character> cut = new ArrayList<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            cut.add(cryptogram.charAt(i));
        }


        return answer;
    }

}



