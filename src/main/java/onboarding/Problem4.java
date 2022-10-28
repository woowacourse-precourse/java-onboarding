package onboarding;

import java.util.HashMap;

public class Problem4 {
    static boolean isCheck(String word) {
        if(word.length()<1 || word.length()>1000) {
            return true;
        }
        return false;
    }

    static String changeWord(String word) {
        String changeWord ="" ;
        HashMap<Character, Integer> wordValue = new HashMap<>();

        wordValue.put('A', 25);
        for(int i=66; i<=90; i++) {
            wordValue.put((char)i, wordValue.get((char)(i-1))-2);
        }

        for(char c : word.toCharArray()) {
            if(97 <= c && c <= 122) {
                c = (char) (c-32);
                changeWord += (char) (c + wordValue.get(c) + 32);
            }
            else if(65 <=c && c <= 90) {
                changeWord += (char) (c + wordValue.get(c));
            }
            else changeWord += c;
        }
        return changeWord;
    }

    public static String solution(String word) {
        if(isCheck(word)) {
            return "문자열의 길이가 잘못되었습니다.";
        }
        word = word.replaceAll("[^a-zA-Z]", " ");
        return changeWord(word);
    }
}

