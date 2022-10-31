package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    
    public static int stringChecker(String string1, String string2) {

        int idx = 0;
        int cnt = 0;
        int maxIdx = Math.min(string1.length(), string2.length());

        for (int i = 0; i < maxIdx; i++) {
            for (int j = 0; j < maxIdx; j++) {
                if (string1.charAt(i) == string2.charAt(j)) {
                    while (j + idx < maxIdx && string1.charAt(i + idx) == string2.charAt(j + idx)) {
                        idx++;
                        cnt++;
                    }
                    return cnt;
                }
            }
        }
        return cnt;
    }

}