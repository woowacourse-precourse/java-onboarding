package onboarding;

import java.util.ArrayList;
import java.util.stream.Collectors;
public class Problem4 {

    private static char convert(char c){
        int cAscii = (int)c;
        char newChar;

        if(cAscii>=65&&cAscii<=90){ //A-Z
            newChar = (char)(155-cAscii); //65+90-cAscii;
        }
        else if(cAscii>=97&&cAscii<=122){ //A-Z
            newChar = (char)(219-cAscii); //97+122-cAscii;
        }
        else{
            newChar = c;
        }

        return newChar;
    }


    public static String solution(String word) {
        ArrayList<Character> charArr = new ArrayList<>();

        for(int i=0;i<word.length();i++){
            charArr.add(convert(word.charAt(i)));
        }

        String answer = charArr.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());
        return answer;
    }
}
