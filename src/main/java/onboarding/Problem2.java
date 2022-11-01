package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(deleteIdx(cryptogram).size()!=0){
            cryptogram = replace(cryptogram);
        }
        return cryptogram;
    }

            for (int i =0; i<charInput.length; i++) {
                // 중복되지 않은 문자 answer에 포함
                if (!check[i]) {
                    temp += String.valueOf(charInput[i]);
                } else if (check[i]) again = true;
            }
            cryptogram = temp;
            temp = "";
            if (again == false) break;
        }

        String answer = cryptogram;
        return answer;
    }

    private static boolean[] checkJungbok(char[] input) {
        boolean[] result = new boolean[input.length];
        for (int i=1; i<input.length; i++){
            if (input[i-1]==input[i]) {
                result[i-1] = true;
                result[i] = true;
            }
        }
        return result;
    }
}
