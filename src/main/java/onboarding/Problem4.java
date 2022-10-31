package onboarding;

public class Problem4 {

    public static boolean isAlphabet(char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            return true;
        }
        else {
            return false;
        }
    }

    public static char convertChar (char ch){
        char minChar;
        char maxChar;
        if (ch >= 'a' && ch <= 'z'){
            minChar = 'a';
            maxChar = 'z';
        }
        else {
            minChar = 'A';
            maxChar = 'Z';
        }
        int toAdd = maxChar - ch;
        char convertedChar = (char) (minChar + toAdd);
        return convertedChar;
    }

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if (isAlphabet(currentChar)){
                answer += convertChar(currentChar);
            }
            else {
                answer += currentChar;
            }
        }

        return answer;
    }
}
