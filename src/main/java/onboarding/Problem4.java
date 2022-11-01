package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Problem4 {

    public static String solution(String word) {
        String answer = translation(word);
        return answer;
    }
    public static String translation(String word){
        // 입력 받은 문자를 char array로 변환
        char[] charArray = word.toCharArray();
        // char 타입의 문자를 담을 스트링 빌더를 생성
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<charArray.length; i++){
            // 입력 받은 아스키코드를 char로 형변환 (공백) 문자를 빌더에 추가
            if((int)charArray[i]==32){
                sb.append((char)32);
            }
            // 소문자를 판단 후 계산식에 따라 결과 값을 빌더에 저장
            else if((int)charArray[i]<91){
                sb.append((char)((90-charArray[i])+65));
            }
            // 대문자 판단 후 계산식에 따라 결과 값을 빌더에 저장
            else if((int)charArray[i]>97){
                sb.append((char)((122-charArray[i])+97));
            }
        }
        //  스트링 빌더에 저장된 값을 스트링으로 리턴
        return sb.toString();
    }

}
