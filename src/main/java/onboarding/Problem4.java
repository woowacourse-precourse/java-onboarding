package onboarding;

public class Problem4 {
    public static char getLetterCase(char letter){
        //대문자일때
        if(letter >= 'A' && letter <= 'Z'){
            return 'A';
        }
        //소문자일때
        if(letter >= 'a' && letter <= 'z'){
            return 'a';
        }
        //알파벳 아닐 때
        return 0;
    }
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length();i++){
            char letter = word.charAt(i);
            char letterCase = getLetterCase(letter);
            if(letterCase==0) {
                answer += letter;
                continue;
            }
            //알파벳 반대로 변환
            //25-(letter-letterCase)+letterCase
            answer += (char)(25-letter+2*letterCase);
        }
        return answer;
    }

}
