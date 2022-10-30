package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length() ; i++){
            int cur = word.charAt(i);
            int converted;
            if(cur == ' ') converted = cur;
            else if(cur >= 'A' && cur <= 'Z') converted = 'A' + (26 - (cur - 'A' + 1));
            else converted = 'a' + (26 - (cur - 'a' + 1));
            answer += (char)converted;
        }
        return answer;
    }
}


// 90 -> 65
// 89 -> 66