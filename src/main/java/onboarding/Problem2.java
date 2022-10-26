package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        if(1000>=cryptogram.length()&&cryptogram.length()>=1){
            // 1<=cryptogram<=1000

            //문자담을 배열 생성
            char[] array = new char[cryptogram.length()];

            //객체에 담기
            for(int i=0;i<cryptogram.length();i++){
                array[i] = cryptogram.charAt(i);
            }

            for(int i=1;i<array.length;i++){
                if(array[i-1]==array[i]){
                    array[i-1]=0;
                    array[i]=0;
                }
            }


            answer="";

        }else{// 1미만 or 1000자 이상
            answer="";
        }

        return answer;
    }
}
