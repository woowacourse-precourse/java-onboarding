package onboarding;

import java.util.stream.Stream;

public class Problem2 {

    /*
    * 1. cryptogram의 매개 변수로 값을 받으며 값의 길이는 1000 이하다.
    * 2. 중복 문자열을 제거한다.
    * 3. 이과정을 반복한다.
    * 4. 중복이 없으면 반환한다.
    */
    public static String solution(String cryptogram) {
        String answer = "";
        if(cryptogram.length() > 1000){
            return answer;
        }
        boolean check = true;

        String result = overLapRemove(cryptogram);

        while (check){
            if(result.equals(overLapRemove(result))){
                answer = result;
                check = false;
            }else{
                result = overLapRemove(result);
            }
        }

        return answer;
    }

    public static String overLapRemove(String cryptogram){
        String answer="";

        for (int i=0; i<cryptogram.length(); i++){
            if(i == 0){
                if(cryptogram.charAt(i) != cryptogram.charAt(i+1)) answer +=cryptogram.charAt(i);
            }
            else if(i < cryptogram.length()-1){
                if(cryptogram.charAt(i) != cryptogram.charAt(i+1)){
                    if(cryptogram.charAt(i) != cryptogram.charAt(i-1)){
                        answer += cryptogram.charAt(i);
                    }
                }
            }else{
                if(cryptogram.charAt(i) != cryptogram.charAt(i-1)){
                    answer += cryptogram.charAt(i);
                }
            }
        }
        return answer;
    }


}
