package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2 {
    public static String solution(String cryptogram) {

        char[] arr = cryptogram.toCharArray();

        ArrayList<Character> list = new ArrayList<Character>();

        for(int l=0; l<arr.length; l++){
            list.add(arr[l]);
        }

        String answer = "";
        return answer;
    }
}