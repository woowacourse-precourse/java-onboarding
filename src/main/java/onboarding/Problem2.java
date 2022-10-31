package onboarding;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataValidationException;

public class Problem2 {
    public static String solution(String cryptogram) {



        int size = cut.size();
        while (count>0) {
            count = 0;
            for (int j = 0; j < size - 1; j++) {
                if (cut.get(j) == cut.get(j + 1)) {
                    cut.remove(j);
                    cut.remove(j);
                    size -= 2;
                    j--;
                    count++;
                }
            }
        }


    }


}



