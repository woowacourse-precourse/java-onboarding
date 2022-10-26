package onboarding;

import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(cryptogram.length()>0){
            char[] chars = cryptogram.toCharArray();
            // StringBuilder = 저장공간 절약
            StringBuilder prev = new StringBuilder(String.valueOf(chars[0]));
            StringBuilder newCrypt= new StringBuilder();

            for(int i=1 ; i< chars.length;i++){
                // 현재 문자와 prev 의 문자가 같은가?
                if(Objects.equals(chars[i],prev.charAt(prev.length()-1))){
                    prev.append(chars[i]);
                }
                else {
                    // 만약 prev 의 길이가 1이라면 연속되지 않았다는 뜻이므로 newCrypt 에 붙여줌
                    if (prev.length()==1) newCrypt.append(prev);
                    prev = new StringBuilder(String.valueOf(chars[i]));
                }
            }
            // 남는 prev 확인 후 붙여주기
            if (prev.length()==1)newCrypt.append(prev);
            // 더 이상 변화가 없다면 break
            if (Objects.equals(newCrypt.toString(),cryptogram)) break;
            cryptogram= newCrypt.toString();
        }
        return cryptogram;
    }
}
