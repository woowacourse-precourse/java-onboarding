package onboarding;

import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(cryptogram.length()>0){
            char prev = cryptogram.charAt(0);
            int lenSamePrev=1;
            StringBuilder newCrypt= new StringBuilder();

            for(int i=1 ; i<cryptogram.length();i++){
                char c = cryptogram.charAt(i);
                if(Objects.equals(c,prev)) lenSamePrev+=1;
                else if (lenSamePrev>1) lenSamePrev=1;
                else newCrypt.append(prev);
                prev=c;
            }

            if (lenSamePrev==1)newCrypt.append(prev);
            if (Objects.equals(newCrypt.toString(),cryptogram)) break;
            cryptogram= newCrypt.toString();
        }
        return cryptogram;
    }
}
