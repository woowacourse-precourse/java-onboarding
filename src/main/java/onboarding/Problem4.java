package onboarding;

/*
 char 문자에 대해 아스키 코드를 이용해 처리작업
 대문자: 아스키 코드상 65~90인 경우 '155 - 알파벳' 을 진행하면 문자 역전이 일어남
 소문자: 아스키 코드상 97~122인 경우 '219 - 알파벳' 을 진행하면 문자 역전이 일어남
 */

public class Problem4 {
    public static String solution(String word) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if(wordArray[i] >= 65 && wordArray[i] <= 90) wordArray[i] = (char)(155 - wordArray[i]);
            if(wordArray[i] >= 97 && wordArray[i] <= 122) wordArray[i] = (char)(219 - wordArray[i]);
        }

        String answer = new String(wordArray);
        return answer;
    }
}
