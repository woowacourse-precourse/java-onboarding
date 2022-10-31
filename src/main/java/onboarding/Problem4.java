package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //제한사항
        if(word.length() < 1 | word.length() > 1000){
            answer = "엄마 말씀이 아닙니다.";
            return answer;
        }

        for(int i=0; i<word.length(); i++){
            char letter = word.charAt(i);
            answer += frog(letter);
        }

        return answer;
    }

    //청개구리 사전(반대로 변환)
    public static char frog(char letter){
        int charInt = letter;
        if(letter >= 65 & letter <= 90){
            charInt += 25 -(2*(letter-65));
        } else if(letter >= 97 & letter <= 122){
            charInt += 25 -(2*(letter-97));
        }
        return (char)charInt;
    }

}
