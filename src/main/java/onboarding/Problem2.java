package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        String checked = checkDuplicate(cryptogram);
        // 첫 중복 제거 검사후 반환값이 빈 문자열이거나 변화가 없다면 반환
        if (checked == "" || checked.equals(cryptogram)){return checked;}

        // 변화가 없을 때까지 반복 검사
        else{

            while(checked != cryptogram || checked != ""){
                if (checked.equals(checkDuplicate(checked)) || checked == ""){return checked;}
                checked = checkDuplicate(checked);
            }
        }
        return checked;
    }

//    암호문 중복확인 메소드
    public  static  String checkDuplicate(String cryptogram){

        // 빈 문자열이 들어오거나 같은 글자가 2개 남았을 경우 빈 문자열 반환
        if (cryptogram == "" || cryptogram.charAt(0) == cryptogram.charAt(1)){return "";}

        String checked = "";
        checked += cryptogram.charAt(0);

        // 앞 뒤 문자 비교하여 중복되지 않는다면 checked에 추가
        for (int i = 1; i < cryptogram.length()-1; i++){
            if(cryptogram.charAt(i-1) != cryptogram.charAt(i) && cryptogram.charAt(i) != cryptogram.charAt((i+1))){
                checked += cryptogram.charAt(i);
            }
        }
        checked += cryptogram.charAt(cryptogram.length()-1);
        return checked;
        }
    }

