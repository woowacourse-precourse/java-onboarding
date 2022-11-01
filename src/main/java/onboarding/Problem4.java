package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static int whatKindOfChar(char letter){//소문자 알파벳 =1, 대문자 알파벳 = 2, 그외 -1
        int ascii = (int)letter; // 문자 아스키코드로 변환
        if(ascii >=97 && ascii <=122){// 소문자 알파벳인 경우
            return 1;
        }
        else if(ascii >=41 && ascii <=90){// 대문자 알파벳인 경우
            return 2;
        }
        else{// 그외 다른 문자
            return -1;
        }
    }
}
