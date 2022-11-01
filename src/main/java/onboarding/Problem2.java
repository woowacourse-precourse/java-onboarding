package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        int len = cryptogram.length();
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        int changed = 0;
        int j = 0;
        List<Integer> sames = new ArrayList<>();
        for(int i= 0; i<len-1 ; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                j = i;
                while (cryptogram.charAt(i) == cryptogram.charAt(j)) {
                    sames.add(j);
                    j++;
                    if(j>=len){
                        break;
                    }
                }
                changed = 1;
                break;
            }
        }

        if(changed == 1){
            int c = sames.get(0);
            for(Integer e : sames){
                stringBuilder.deleteCharAt(c);
            }
            sames.clear();
            return solution(stringBuilder.toString());
        }
        String answer = stringBuilder.toString();
        return answer;
    }
}
