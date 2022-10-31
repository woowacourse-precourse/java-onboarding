package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(isUpperCase(currentChar)){
                answer += changeUpperCase(currentChar);
            }else if(isLowerCase(currentChar)){
                answer += changeLowerCase(currentChar);
            }else{
                answer += currentChar;
            }
        }

        return answer;
    }

    private static boolean isUpperCase(char currentChar){
        if('A'<=currentChar && currentChar<='Z') {
            return true;
        }else{
            return false;
        }
    }

    private static boolean isLowerCase(char currentChar){
        if('a'<=currentChar && currentChar<='z') {
            return true;
        }else{
            return false;
        }
    }

    private static char changeUpperCase(char currentChar){
        final int UPPER_CASE_CONSTANT = 'A' + 'Z';
        int conversion = UPPER_CASE_CONSTANT - currentChar;
        char newChar = (char)conversion;
        return newChar;
    }
    private static char changeLowerCase(char currentChar){
        final int LOWER_CASE_CONSTANT = 'a' + 'z';
        int conversion = LOWER_CASE_CONSTANT - currentChar;
        char newChar = (char)conversion;
        return newChar;
    }

}
