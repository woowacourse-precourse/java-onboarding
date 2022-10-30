package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {

        int result = count(number);

        return result;
    }

    public static int count(int number) {
        int count = 0;

        for(int i = 1; i <= number; i++) {
            String str = String.valueOf(i);

            for(int j = 0; j < str.length(); j++) {
                char chk = str.charAt(j);

                if(chk == '3' || chk == '6' || chk == '9') {
                    count += 1;
                }
            }
        }

        return count;
    }
}
