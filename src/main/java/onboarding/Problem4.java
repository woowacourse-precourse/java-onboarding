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
}
