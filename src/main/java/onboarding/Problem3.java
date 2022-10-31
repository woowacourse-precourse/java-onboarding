package onboarding;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3 {
    public static int solution(int number) {

        int count = 0;
        for (int k = 1; k <= number; k++) {

            String str = Integer.toString(k);

            char[] arr = str.toCharArray();

            ArrayList<Character> list = new ArrayList<Character>();

            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
        }

            int answer = 0;

        return answer;
    }
}