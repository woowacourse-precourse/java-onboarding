package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            char tmpChar = word.charAt(i);
            int asciiValue = (int)tmpChar;

            if(65 <= asciiValue && asciiValue <= 90){
                asciiValue = 65 + 90 - asciiValue;
                tmpChar = (char)asciiValue;
            }
            else if(97 <= asciiValue && asciiValue <= 122){
                asciiValue = 97 + 122 - asciiValue;
                tmpChar = (char)asciiValue;
            }

            answer += tmpChar;


        }
        return answer;
    }
}