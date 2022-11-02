package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String s){
        int len = 0;
        String text = s;
        for(int i =0; i<s.length(); i++ ){
            text = removeChar(text);
            if(len == text.length()) break;
        }
        return text;
    }
    public static String  removeChar(String s){
        char[] array = s.toCharArray();
        int len = array.length;
        char tempChar = 0;

        ArrayList<Character> tempList = new ArrayList<Character>();
        for (int i = 0; i < len - 1; i++) {
            if (array[i] != array[i + 1]) {
                tempChar = array[i];
                tempList.add(tempChar);
            } else i++;
        }
        if (array[len - 2] != array[len - 1]) {
            tempChar = array[len - 1];
            tempList.add(tempChar);
        }
        StringBuilder text = new StringBuilder();
        for(Character ch : tempList){
            text.append(ch);
        }

        String result =  text.toString();
        return result;

    }

}
