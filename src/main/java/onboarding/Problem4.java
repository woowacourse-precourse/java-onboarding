package onboarding;

import org.mockito.internal.matchers.Null;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            if('a'<=word.charAt(i)&& word.charAt(i)<='z'){
                answer+=(char)('a'+'z'-word.charAt(i));
            }
            else if('A'<=word.charAt(i)&& word.charAt(i)<='Z'){
                answer+=(char)('A'+'Z'-word.charAt(i));
            }
            else{
                answer+=(char)word.charAt(i);
            }
        }
        return answer;
    }
}
