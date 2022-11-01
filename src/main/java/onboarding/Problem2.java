package onboarding;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;




public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";


        int cnt=1;
        while(cnt!=0) {
            cnt=0;
            ArrayList<Character> list = new ArrayList<Character>();
            List<Character> ex = new ArrayList<>();
            String a="";
            for (int i = 0; i < cryptogram.length(); i++) {
                char currentCharacter = cryptogram.charAt(i);//getting the character at current index
                if (ex.isEmpty()) {
                    ex.add(currentCharacter);
                    a+=(currentCharacter);
                    continue;
                }
                if (ex.get(ex.size() - 1) == currentCharacter) {
                    cnt += 1;
                    ex.remove(ex.size() - 1);
                    ex.add(currentCharacter);
                    a=a.substring(0, a.length() - 1);
                } else {
                    a+=(currentCharacter);
                    ex.add(currentCharacter);
                }
            }
            cryptogram = a;
        }

        answer=cryptogram;
        return answer;
    }
}
