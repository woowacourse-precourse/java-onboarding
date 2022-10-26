package onboarding;

import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(cryptogram.length()>0){
            char[] chars = cryptogram.toCharArray();
            StringBuilder prev = new StringBuilder(String.valueOf(chars[0]));
            StringBuilder newCrypt= new StringBuilder();
            for(int i=1 ; i< chars.length;i++){
                if(Objects.equals(chars[i],prev.charAt(prev.length()-1))){
                    prev.append(chars[i]);
                }
                else {
                    if (prev.length()==1) newCrypt.append(prev);
                    prev = new StringBuilder(String.valueOf(chars[i]));
                }
            }
            if (prev.length()==1)newCrypt.append(prev);
            if (Objects.equals(newCrypt.toString(),cryptogram)) break;
            cryptogram= newCrypt.toString();
        }
        return cryptogram;
    }
}
