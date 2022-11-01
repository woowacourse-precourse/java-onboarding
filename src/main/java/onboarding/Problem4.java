package onboarding;

import java.util.List;

public class Problem4 {
    //청개구리 사전으로 문자 변환하기
    public static char returnReverseChar(char character) {
        List<Integer> reverseAddDic = List.of( //청개구리 사전 : 청개구리 문자로 변환되기 위해 더할 값만 정의해놓은 리스트
                25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, //a(A) ~ m(M)
                -1, -3, -5, -7, -9, -11, -13, -15, -17, -19, -21, -23, -25 //n(N) ~ z(Z)
        );
        int dicIndex;

        if(character >= 'A' && character <= 'Z') { //알파벳 대문자인 경우
            dicIndex = character - 'A';
            return (char)(character + reverseAddDic.get(dicIndex));
        }
        else if(character >= 'a' && character <= 'z') { //알파벳 소문자인 경우
            dicIndex = character - 'a';
            return (char)(character + reverseAddDic.get(dicIndex));
        }
        else { //알파벳이 아닌 경우
            return character;
        }
    }

    //솔루션 메소드
    public static String solution(String word) {
        String answer = "";
        char[] text = word.toCharArray();

        for(int i=0; i < text.length; i++) {
            answer += returnReverseChar(text[i]); //청개구리 문자 변환
        }
        return answer;
    }
}
