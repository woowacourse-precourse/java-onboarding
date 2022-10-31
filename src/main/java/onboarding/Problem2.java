package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<String> duplicateList = new ArrayList<>(
            Arrays.asList("aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"));

        String answer;
        int j = 0;
        do {
            answer = cryptogram;
            for (int i = 0; duplicateList.size() > i; i++){
                cryptogram = cryptogram.replace(duplicateList.get(i),"");
            }
            if (answer.equals(cryptogram)) {break;}
            j += 1;
        } while(j<501);

        return answer;
    }
}
