package onboarding;

import java.util.*;
public class Problem4 {
    public static String solution(String word) {

        char word_arr [] = new char[word.length()];


        for(int i = 0 ; i <word_arr.length; i ++) {
            word_arr[i]=word.charAt(i);
        }

        HashMap<Character,Character>A_map = new HashMap<>();
        HashMap<Character,Character>a_map = new HashMap<>();

        for(int i = 0 ; i < 26; i ++) {
            A_map.put(((char)(65+i)),((char)(90-i)));
            a_map.put(((char)(97+i)),((char)(122-i)));

        }

        String input = "";

        for(int i = 0 ; i < word_arr.length; i ++) {
                if(65<=(int)word_arr[i] && (int)word_arr[i]<=90) {

                    if(A_map.containsKey(word_arr[i])) {
                        word_arr[i]=A_map.get(word_arr[i]);

                        input+=Character.toString(word_arr[i]);
                    }else {
                        input+=Character.toString(word_arr[i]);
                    }

                }else if(97<=(int)word_arr[i] && (int)word_arr[i]<=122) {

                    if(a_map.containsKey(word_arr[i])) {
                        word_arr[i]=a_map.get(word_arr[i]);

                        input+=Character.toString(word_arr[i]);
                    }
                    else {
                        input+=Character.toString(word_arr[i]);
                    }
                }else {
                    input += Character.toString(word_arr[i]);
                }
        }


        String answer =input;
        return answer;
    }
}
