package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char ch; int tmp;

        for(int i=0; i<word.length(); i++){
            ch = word.charAt(i);
            if(ch >='A' && ch <= 'Z'){
                tmp = ch - 65;
                answer += (char)(90 -tmp);
            }
            else if(ch >= 'a' && ch <= 'z'){
                tmp = ch - 97;
                answer += (char)(122 -tmp);
            }
            else
                answer += ch;
        }

        return answer;
    }
}
