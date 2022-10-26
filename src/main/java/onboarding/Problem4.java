package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    public static boolean checkValidation(String word) {
        if (word.length() > 1000 || word.length() < 1) {
            return false;
        }
        return true;
    }

}


/*
1. 입력 조건에 맞지 않는 경우 예외처리 기능
2. 알파벳을 변환하는 기능
- (예외) 알파벳 외의 문자는 변환하지 않음
3. word을 변환하는 기능
* */