package onboarding;

import java.util.Hashtable;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Hashtable<Character, Character> alphabetTable = new Hashtable<>();

        int j = 'Z';
        for(int i = 'A'; i <= 'Z'; i++){
            alphabetTable.put((char) i, (char) j--);
        }
        j = 'z';
        for(int i = 'a'; i <= 'z'; i++){
            alphabetTable.put((char) i, (char) j--);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            if(alphabetTable.containsKey(word.charAt(i))){
                sb.append(alphabetTable.get(word.charAt(i)));
            }else{
                sb.append(word.charAt(i));
            }
        }
        answer = sb.toString();

        return answer;
    }
}
