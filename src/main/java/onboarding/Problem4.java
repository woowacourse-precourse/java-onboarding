package onboarding;

import java.util.HashMap;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr_word = word.toCharArray();
        char[] arr_answer = new char[arr_word.length];
        HashMap<Character, Integer> alphabet_mother = new HashMap<Character, Integer>();
        HashMap<Integer, Character> alphabet_frog = new HashMap<Integer, Character>();
        int i = 0;

        for(char C = 'A'; C <= 'Z'; C++) {
            alphabet_mother.put(C, i);
            alphabet_frog.put(i, (char)('Z' - i));
            i++;
        }
        for(char c = 'a'; c <= 'z'; c++) {
            alphabet_mother.put(c, i);
            alphabet_frog.put(i, (char)('z' - i + 26));
            i++;
        }

        for(int l=0; l < arr_word.length ; l++) {
            if ((arr_word[l] >= 'A'&& arr_word[l] <= 'Z') || (arr_word[l] >= 'a'&& arr_word[l] <= 'z')) {
                arr_answer[l] = alphabet_frog.get(alphabet_mother.get(arr_word[l]));
            }else {
                arr_answer[l] = arr_word[l];
            }
        }
        answer = String.valueOf(arr_answer);
        return answer;
    }
}
