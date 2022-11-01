package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] words = word.toCharArray();

        for(char ch : words){
            if(ch >= 'A' && ch <= 'Z'){
                sb.append((char)('Z' - (ch - 'A')));
            }
            else if(ch >= 'a' && ch <= 'z'){
                sb.append((char)('z' - (ch - 'a')));
            }
            else
                sb.append(ch);
        }
        answer = sb.toString();

        return answer;
    }
}
