package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = reverseAlphabetString(word);
        return answer;
    }

    private static int whatKindOfChar(char letter){//소문자 알파벳 =1, 대문자 알파벳 = 2, 그외 -1
        if(letter >='a' && letter <='z'){// 소문자 알파벳인 경우
            return 1;
        }
        else if(letter >='A' && letter <='Z'){// 대문자 알파벳인 경우
            return 2;
        }
        else{// 그외 다른 문자
            return -1;
        }
    }

    private static char reverseAlphabetChar(char alphabetChar, int capOption){//알파벳 문자 반대로 변환
        if(capOption==1){//소문자인경우
            return (char)('z'-alphabetChar+'a');
        }
        else if(capOption==2){// 대문자인경우
            return (char)('Z'-alphabetChar+'A');
        }
        else{
            return alphabetChar;
        }
    }
}
