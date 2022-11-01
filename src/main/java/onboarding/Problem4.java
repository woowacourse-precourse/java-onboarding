package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String dict[]  = {"A","B","C","D","E","F","G","H","I","J","K","L","N","M","O","P","Q","R","S","T","U","V","W","X","Y","Z"};  //인덱스 검색 시 사용
        char frogdict[] = {'Z','Y','X','W','V','U','T','S','R','Q','P','O','M','N','L','K','J','I','H','G','F','E','D','C','B','A'}; //출력 시 사용

        if(word.length()>1000 || word.length()<1)
            return "word는 길이가 1 이상 1,000 이하인 문자열이어야 합니다.";

        for(int i=0; i<word.length(); i++){ //word에서 문자 추출 후 조건문 돌리기
            char ch = word.charAt(i);

            if(ch<65 || (90 < ch && ch< 97) || (122<ch && ch<=127) ){ //알파벳이 아닐 때 사용
                answer+=ch;
            }

            if(Character.isUpperCase(ch)){
                int num = Arrays.asList(dict).indexOf(String.valueOf(ch)); //배열을 list로 변환해서 indexOf를 사용하여 ch(문자열로 변환) 찾기
                answer += frogdict[num];
            }

            if(Character.isLowerCase(ch)){
                int num = Arrays.asList(dict).indexOf(String.valueOf(Character.toUpperCase(ch))); //위와 같은 방법이지만 ch를 대문자로 바꿔 검색
                answer += Character.toLowerCase(frogdict[num]); //dict배열만 쓰고 char형으로 변환해도 가능, 소문자로 다시 변환
            }
        }
        return answer;
    }
}
