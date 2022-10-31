package onboarding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";

        //지울 중복문자가 없을때까지 반복해서 중복문자를 지우는 함수
        answer = removeDuplicateWords(cryptogram);

        return answer;
    }


    //지울 중복문자가 없을때까지 반복해서 중복문자를 지우는 함수
    public static String removeDuplicateWords(String cryptogram) {

        String result = "";

        while (true) {
            for (int i = 0; i < cryptogram.length(); i++) {
                char currentCharacter = cryptogram.charAt(i);
                //현재 문자가 앞부분 문자와 같다면 넘어간다.
                if( i+1 <cryptogram.length()
                    && cryptogram.charAt(i+1)== currentCharacter)
                {
                    continue;
                }
                //현재 문자가 뒷부분 문자와 같다면 넘어간다.
                if( i-1 >= 0
                    && cryptogram.charAt(i-1)== currentCharacter)
                {
                    continue;
                }
                //그게아니라면 결과값 변수에 저장한다.
                result += currentCharacter;

            }
            //중복문자가 존재해 처음들어온 문자열과 결과문자열이 다르다면
            if (!result.equals(cryptogram)) {
                cryptogram = result; // 결과문자열로 암호문을 바꿔주고
                result = ""; // 결과를 저장할 변수도 초기화해준다.
            }
            //지워질게없어서 들어온 문장과 결과문장이 같다면
            else{
                break; //반복문을 탈출한다.
            }
        }

        return result;

    }


}
