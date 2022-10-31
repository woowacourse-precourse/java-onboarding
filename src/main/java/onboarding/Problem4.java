package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0;i<word.length();i++){
            if(word.charAt(i) == ' ') {
                answer += ' ';
                continue;
            }
            if(word.charAt(i) >= 'Z')
                answer += (char)('a'+'z'-word.charAt(i));
            else
                answer += (char)('A'+'Z'-word.charAt(i));
        }

        return answer;
    }
}
