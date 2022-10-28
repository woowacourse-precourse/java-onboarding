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
                if(c <= 'M') {
                    rem = 65 + ('Z' - c);
                }
                else if(c > 'M') {
                    rem = 90 - (c - 'A');
                }
                result += (char)(rem);
            }
            else if(Character.isLowerCase(c)) {
                if(c <= 'm') {
                    rem = 97 + ('z' - c);
                }
                else if(c > 'M') {
                    rem = 122 - (c - 'a');
                }
                result += (char)(rem);
            }
            else if(c == ' ') {
                result += c;
            }
        }
        return result;
    }
}
