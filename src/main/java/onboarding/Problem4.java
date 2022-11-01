package onboarding;

import java.util.Hashtable;

public class Problem4 {
    private Hashtable<Character,Character> frogDictionaryHashtable;
    public Problem4(){
        frogDictionaryHashtable = new Hashtable<Character,Character>();
        for(int i = 65, j = 25; i <= 90; ++i, j-=2)
            frogDictionaryHashtable.put((char)i, (char)(i+j));
        for(int i = 97, j = 25; i <= 122; ++i, j-=2)
            frogDictionaryHashtable.put((char)i, (char)(i+j));
    }
    private String frogChangeWord(final String word){
        String ret = "";
        for(int i = 0; i < word.length(); ++i) {
            if(frogDictionaryHashtable.get(word.charAt(i)) != null) {
                ret += frogDictionaryHashtable.get(word.charAt(i));
            } else{ //알파벳 이외의 문자는 변환하지 않는다.
                ret += word.charAt(i);
            }
        }
        return ret;
    }
    public static String solution(String word) {
        String answer = "";
        Problem4 p4 = new Problem4();
        answer = p4.frogChangeWord(word);
        return answer;
    }
}
