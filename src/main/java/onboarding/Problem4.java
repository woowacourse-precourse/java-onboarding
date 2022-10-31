package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = changeString(word);
        return answer;
    }
    static String changeString(String tmp) {
        String result = "";
        for(int i=0; i<tmp.length(); i++) {
            char c = tmp.charAt(i);
            int rem = 0;
            if(Character.isUpperCase(c)) {
                rem = 'Z' - c + 'A';
                result += (char)(rem);
            }
            else if(Character.isLowerCase(c)) {
                rem = 'z' - c + 'a';
                result += (char)(rem);
            }
            else if(c == ' ') {
                result += c;
            }
        }
        return result;
    }
}
