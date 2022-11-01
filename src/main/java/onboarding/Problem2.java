package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {


    public static String decryption(String cryptogram){
        List<Character> buff=new ArrayList<Character>();
        buff.add(cryptogram.charAt(0));
        for(int i=1;i<cryptogram.length();i++){
            if(buff.get(buff.size() - 1)==cryptogram.charAt(i)){
                buff.remove(buff.size() - 1);
                continue;
            }
            buff.add(cryptogram.charAt(i));
        }

        return listToString(buff);
    }

    private static String listToString(List<Character> buff) {
        String str="";

        for (int i=0;i< buff.size();i++){
            str+=buff.get(i).toString();
        }
        return str;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer=decryption(cryptogram);

        return answer;
    }
}
