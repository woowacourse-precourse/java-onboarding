package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char ch;
        for(int i = 0; i < word.length(); i++){
            ch = word.charAt(i);
            if(ch >= 'A' && ch < 'N'){
                answer += (char)(ch + (25 - 2 * (ch - 'A')));
            }
            else if (ch >= 'a' && ch < 'n'){
                answer += (char)(ch + (25 - 2 * (ch - 'a')));
            }
            else if (ch >= 'N' && ch <= 'Z'){
                answer += (char)(ch - (1 + 2 * (ch - 'N')));
            }
            else if (ch >= 'n' && ch <= 'z'){
                answer += (char)(ch - (1 + 2 * (ch - 'n')));
            }
            else{
                answer += ch;
            }
        }
        return answer;
    }
}
