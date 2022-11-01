package onboarding;

public class Problem4 {
    public static String solution(String sentence) {

        int uppergap = 'Z' + 'A';
        int lowergap = 'z' + 'a';

        char[] new_sentence = sentence.toCharArray();

        for(int i=0; i<new_sentence.length; i++){
            if(Character.isAlphabetic(new_sentence[i]))
            {
                if(Character.isUpperCase(new_sentence[i])) // 대문자일 때
                {
                    char tmp = (char)(uppergap - new_sentence[i]);
                    new_sentence[i] = tmp;
                }
                else // 소문자일 때
                {
                    char tmp = (char)(lowergap - new_sentence[i]);
                    new_sentence[i] = tmp;
                }
            }
        }

        String answer = "";
        for(char c : new_sentence)
            answer += c;

        return answer;
    }
}