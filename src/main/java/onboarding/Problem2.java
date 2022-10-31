package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        while(true) {
            String tmp = "";
            int continuous = 0;     //연속성을 확인할 변수

            for (int i = 0; i < cryptogram.length()-1; i++) {
                String cryptogram_i = cryptogram.substring(i, i + 1);
                String cryptogram_i_next = cryptogram.substring(i + 1, i + 2);

                if (cryptogram_i.equals(cryptogram_i_next)) {   //다음 글자와 같다면
                    continuous = 1;
                } else if(continuous == 1){     //다음 글자와는 다르지만 이전 글자와 같았다면
                    continuous = 0;
                } else {        //둘 다 아닐 경우
                    tmp += cryptogram_i;
                }
            }

            if(continuous == 0 && cryptogram.length() != 0){
                tmp += cryptogram.substring(cryptogram.length()-1, cryptogram.length());
            }

            if(tmp.equals(cryptogram)) {        //cryptogram에 중복이 없어 그대로 저장되었다면
                break;
            } else {
                cryptogram = tmp;
            }
        }

        answer = cryptogram;

        return answer;
    }
}
