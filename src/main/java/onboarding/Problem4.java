package onboarding;

import java.util.Hashtable;

public class Problem4 {
    private Hashtable<Character,Character> ht;
    public Problem4(){
        ht = new Hashtable<Character,Character>();
        for(int i = 65, j = 25; i <= 90; ++i, j-=2)
            ht.put((char)i, (char)(i+j));
        for(int i = 97, j = 25; i <= 122; ++i, j-=2)
            ht.put((char)i, (char)(i+j));
    }
    private String frogChangeWord(final String word){
        String ret = "";
        for(int i = 0; i < word.length(); ++i) {
            if(ht.get(word.charAt(i)) != null) {
                ret += ht.get(word.charAt(i));
            } else{
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
