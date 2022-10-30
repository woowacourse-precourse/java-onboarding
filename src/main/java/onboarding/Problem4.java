package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {

    // using ASCII table, the sum of given letter  and the convert should be 155
    // if uppercase, 219 if lowercase
    public static String solution(String word) {

        List<Character> charArr = new ArrayList<>();

        for(int c: word.toCharArray()){
            int temp = c;
            if( (temp >= 65 && temp <=90 ) ){
                charArr.add((char)(155-c));
            } else if((temp >= 97 &&  temp <=122)){
                charArr.add((char)(219-c));
            } else{
                charArr.add((char)c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: charArr){
            sb.append(c);
        }

        return sb.toString();
    }
}
