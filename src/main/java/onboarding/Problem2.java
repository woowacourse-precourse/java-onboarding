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

        int i = 0;


        for(i=0; i<list.size()-1; i++) {

            int l = 0;
            int j = i + 1;

            while (list.get(i) == list.get(j)) {
                if (j + 1 == list.size()) {
                    l++;
                    break;
                } else {
                    j++;
                }
            }
        }


            String answer = "";
        return answer;
    }
}