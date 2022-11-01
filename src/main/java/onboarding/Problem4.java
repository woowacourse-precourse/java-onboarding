package onboarding;

public class Problem4 {
    public static char frogword(char c){
        char result = c;
        if (c>=65 && c<=90){
            int ascii = c - 65;
            result = (char) (90-ascii);
        } else if (c >= 97 && c<=122) {
            int ascii = c - 97;
            result = (char) (122-ascii);
        }
        return result;
    }
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char c = frogword(word.charAt(i));
            answer+=c;
        }
        return answer;
    }

}