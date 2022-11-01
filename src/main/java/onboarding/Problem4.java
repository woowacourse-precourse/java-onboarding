package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        char[] strChar = word.toCharArray();

        for(int i=0; i<strChar.length; i++){
            // 대문자
            if('A' <= strChar[i] && strChar[i] <= 'Z'){
                strChar[i] = (char)(155 - (int)strChar[i]);
            }
            // 소문자
            if('a' <= strChar[i] && strChar[i] <= 'z'){
                strChar[i] = (char)(219 - (int)strChar[i]);
            }

            answer += strChar[i];
        }

        return answer;
    }

}
