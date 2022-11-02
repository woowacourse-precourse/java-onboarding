package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        Map<String, String> alphabetMap = conversionMapSet();

        for(int i=0; i<word.length(); i++){

            Character.toString((char)word.toCharArray()[i]);

            if(alphabetMap.containsKey(Character.toString((char)word.toCharArray()[i]))){
                answer += alphabetMap.get(Character.toString((char)word.toCharArray()[i]));
            }else{
                answer += Character.toString((char)word.toCharArray()[i]);
            }
        }

        return answer;
    }

    public static Map<String, String> conversionMapSet(){
        Map<String, String> alphabetMap = new HashMap<String, String>();

        for(int i=0; i<26; i++){
            alphabetMap.put(""+(char)(65+i), ""+(char)(90-i));
            alphabetMap.put(""+(char)(97+i), ""+(char)(122-i));
        }

        return alphabetMap;
    }

}

