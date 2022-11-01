package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String a = cryptogram;
        while(true){
            String b = decoding(a);
            if(a.length() == b.length()){
                return a;
            }else{
                a = b;
            }
        }
    }
    static String decoding(String value){
        String answer ="";
        ArrayList<Character> arr = new ArrayList<Character>();
        for (int i = 0; i < value.length(); i++) {
            Character cc = value.charAt(i);
            arr.add(cc);
        }
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i) == arr.get(i-1)){
                arr.remove(i);
                arr.remove(i-1);
            }

        }
        for (int i = 0; i < arr.size(); i++) {
            answer += Character.toString(arr.get(i));

        }
        return answer;
    }
}
