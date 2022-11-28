package onboarding;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;

public class Problem4 {

    public static final int VALUE_UPPER_A = 65;
    public static final int VALUE_UPPER_Z = 90;
    public static final int VALUE_LOWER_A = 97;
    public static final int VALUE_LOWER_Z = 122;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int value : word.toCharArray()) {
            if (value >= VALUE_UPPER_A && value <= VALUE_UPPER_Z) {
                value = VALUE_UPPER_A + VALUE_UPPER_Z - value;
            }
            if (value >= VALUE_LOWER_A &&value <= VALUE_LOWER_Z) {
                value = VALUE_LOWER_A + VALUE_LOWER_Z - value;
            }
            answer.append((char)value);
        }
        return answer.toString();
    }
}
