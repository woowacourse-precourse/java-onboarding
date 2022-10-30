package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length(); i++)
            answer += getEncryptWord(word.charAt(i));

        return answer;
    }

    public static char getEncryptWord(char original) {

        if(original >= 'a' &&  original <= 'z')
            original = (char)('z' - (original - 'a'));

        if(original >= 'A' &&  original <= 'Z')
            original = (char)('Z' - (original - 'A'));

        return original;
    }
}
