package onboarding;

import org.mockito.internal.matchers.Null;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (!answer.equals(search(answer))){
            answer = search(answer);
        }
        return answer;
    }

    public static String search(String cipherText){
        char preWord = ' ';
        for (int i = 0; i < cipherText.length(); i++){
            if (preWord == cipherText.charAt(i)){
                return cipherText.substring(0,i-1) + cipherText.substring(i + 1);
            }
            preWord = cipherText.charAt(i);
        }
        return cipherText;
    }
}
