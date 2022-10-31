package onboarding;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    static boolean check(List<Character> letter){
        for(int i=1; i<letter.size(); i++){
            if(letter.get(i) == letter.get(i-1)) return true;
        }
        return false;
    }

    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> ans = new ArrayList<Character>();

        do{
            ans.clear();
            for (int i = 0; i < cryptogram.length(); i++) {
                if (i!=cryptogram.length()-1&&cryptogram.charAt(i) == cryptogram.charAt(i+1)) continue;
                if (i!=0&&cryptogram.charAt(i) == cryptogram.charAt(i-1)) continue;
                ans.add(cryptogram.charAt(i));
            }
            cryptogram = "";
            for(int i=0; i<ans.size(); i++)
                cryptogram += ans.get(i);
        }while(check(ans));

        for(int i=0; i<ans.size(); i++)
            answer += ans.get(i);

        return answer;
    }
}
