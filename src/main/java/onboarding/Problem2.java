package onboarding;

import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(cryptogram.length()>0){
            char prev = cryptogram.charAt(0);
            int lenPrev=1;
            String newCrypt=cryptogram;

            for(int i=1 ; i<cryptogram.length();i++){
                char c = cryptogram.charAt(i);
                if(Objects.equals(c,prev)) lenPrev+=1;
                else if (lenPrev>1) {
                        newCrypt=newCrypt.replaceAll(repeatStr(prev,lenPrev), "");
                        break;
                }
                prev=c;
            }
            if (Objects.equals(repeatStr(prev,lenPrev),newCrypt)) newCrypt="";
            if (Objects.equals(newCrypt,cryptogram)) break;
            cryptogram=newCrypt;
        }
        return cryptogram;
    }
    public static String repeatStr(char prev, int repeatNum){
        String s = String.valueOf(prev);
        return s.repeat(repeatNum);
    }
}
