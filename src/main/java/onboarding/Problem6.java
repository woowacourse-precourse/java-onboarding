package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = null;

        return answer;
    }

    /**
     * 6.1
     * 두 닉네임에 중복이 존재하는지 판별
     */
    public static boolean isDupWordExist(String word1, String word2) {
        int wordLength = 2;

        while (wordLength <= Math.min(word1.length(), word2.length())) {
            for (int i = 0; i <= (word1.length() - wordLength); i++) {
                String subWord = word1.substring(i, i + wordLength);

                if (hasSubWord(word2, subWord))
                    return true;
            }
            wordLength++;
        }
        return false;
    }

    /**
     * 6.1.1
     * 단어 word에 subword가 존재하는지 판별
     */
    public static boolean hasSubWord(String word, String subWord) {
        for (int i = 0; i <= (word.length() - subWord.length()); i++)
            if (word.substring(i, i + subWord.length()).equals(subWord))
                return true;

        return false;
    }


}
