package onboarding;
import java.util.ArrayList;
public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> characters = new ArrayList<Character>();

        for( char cha : cryptogram.toCharArray()){
            characters.add(cha);
        }
        int length = cryptogram.length();
        int n = 1;
        while(n < length){
            if( characters.get(n) == characters.get(n-1)){
                characters.remove(n);
                characters.remove(n-1);
                n = 1;
                length -= 2;
            }
            else {
                n += 1;
            }
        }

        String answer = "";

        for(char cha : characters){
            answer += cha;
        }


        return answer;
    }
}
