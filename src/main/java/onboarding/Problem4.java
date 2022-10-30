package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            char tempChar = word.charAt(i);
            //대문자
            if(Character.isUpperCase(tempChar)){
                tempChar = (char)('Z' - (tempChar - 'A'));
            }
            answer += tempChar;
        }
        return answer;
    }
}
