package onboarding;

public class Problem4 {
    static final int MIN_WORD_LENGTH = 1;
    static final int MAX_WORD_LENGTH = 1000;

    public static String solution(String word) {
        String answer = "";

        validateWordLength(word);

        for(int i = 0; i < word.length(); i++){
            int ascii = word.charAt(i);

            if(Character.isUpperCase(ascii)){
                answer += String.valueOf((char)(('Z' - ascii) + 'A'));

            }else if(Character.isLowerCase(ascii)){
                answer += String.valueOf((char)(('z' - ascii) + 'a'));

            }else{
                answer += String.valueOf((char)ascii);

            }
        }
        return answer;
    }

    public static void validateWordLength(String word){
        if(word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH){
            throw new IllegalArgumentException("word는 길이가 " + MIN_WORD_LENGTH + "이상, " +
                     MAX_WORD_LENGTH + "이하인 문자열이어야 한다.");
        }
    }
}
