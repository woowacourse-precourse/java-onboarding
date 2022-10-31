package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean changed = true;
        int index = 0;
        while (changed) {
            changed = false;
            for (int i = cryptogram.length() - 1; i > 0; i--) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                    changed = true;
                    index = i;
                    while ((i > 0) && (cryptogram.charAt(i) == cryptogram.charAt(i - 1))) {
                        i -= 1;
                    }
                    if ((i == 0) && (cryptogram.charAt(i) == cryptogram.charAt(index))){
                        cryptogram = cryptogram.substring(index + 1);
                    }
                    else cryptogram = cryptogram.substring(0, i).concat(cryptogram.substring(index + 1));
                }
            }
        }
        return cryptogram;
    }
}
