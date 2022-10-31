package onboarding;

import java.util.HashMap;

public class Problem4 {
    static boolean isCheck(String word) {
        return word.length()<1 || word.length()>1000;
    }

    static String wordChange(String word, HashMap<Character, Integer> wordValue) {
        String wordChange ="" ;

        wordValue.put('A', 25);
        for(int i=66; i<=90; i++) {
            wordValue.put((char)i, wordValue.get((char)(i-1))-2);
        }

        for(char c : word.toCharArray()) {
            if(97<=c && c<=122) {
                c = (char) (c-32);
                wordChange += (char) (c + wordValue.get(c) + 32);
            }
            else if(65<=c && c<=90) {
                wordChange += (char) (c + wordValue.get(c));
            }
            else wordChange += c;
        }
        return wordChange;
    }

    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Integer> wordValue = new HashMap<>();

        if(isCheck(word)) {
            System.out.print("암호문의 길이는 1이상 1000이하입니다.");
        } else {
            answer = wordChange(word, wordValue);
        }
        return answer;
    }
}