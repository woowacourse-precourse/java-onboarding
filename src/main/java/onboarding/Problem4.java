package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        Problem4 solve = new Problem4();
        solve.procException(solve.hasException(word));

        return solve.getChangedWord(word);
    }
    private void procException(Boolean isException) {
        if (isException) {
            throw new RuntimeException("Error Occur");
        }
    }
    private boolean hasException(String word){
        if(word.length()<1 || word.length()>10000)
            return true;
        return false;
    }

    private String getChangedWord(String word){
        String result;
        char[] newWord = word.toCharArray();
        for(int i = 0; i < newWord.length; i++){
            if('A' < newWord[i] && newWord[i] < 'Z')
                newWord[i] = (char)('Z'+'A'-newWord[i]);
            else if('a' < newWord[i] && newWord[i] < 'z')
                newWord[i] = (char)('z'+'a'-newWord[i]);
        }
        result = new String(newWord);
        return result;

    }
}
