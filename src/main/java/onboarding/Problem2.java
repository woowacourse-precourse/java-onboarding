package onboarding;

import java.util.ArrayList;
import java.util.Arrays;


public class Problem2 {
    public static ArrayList<String> detectRepetition(ArrayList<String> wordList){
        String pre = "";
        Boolean isEnded = true;
        for (int i=1;i< wordList.size();i++){
            pre = wordList.get(i-1);
            String now = wordList.get(i);

            if(pre.equals(now)){
                isEnded = false;
                wordList.remove(i);
                wordList.remove(i-1);
            }

        }
        if (isEnded){return wordList;}
        else{return detectRepetition(wordList);}

    }
    public static String solution(String cryptogram) {
        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(cryptogram.split("")));
        ArrayList<String> tmp =detectRepetition(wordList);
        String answer = String.join("",tmp);

        return answer;
    }
}
