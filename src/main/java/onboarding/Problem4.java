package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = changeWord(word);
        return answer;
    }
    private static String changeWord(String input){
        String result = "";
        char temp = ' ';
        for(int i = 0; i < input.length(); i++){
            temp = input.charAt(i);
            if(((int)input.charAt(i) > 96) && (int)input.charAt(i) < 123)
                temp = (char)(122 - (int)input.charAt(i) + 'a');
            if(((int)input.charAt(i) > 64) && (int)input.charAt(i) < 91)
                temp = (char)(90 - (int)input.charAt(i) + 'A');
            result += temp;
        }
        return result;
    }
}
