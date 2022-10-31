package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(true){
            List<Integer> rangeList = findDuplicationRange(cryptogram);
            if(rangeList.size() == 0)
                break;
            cryptogram = removeDuplication(cryptogram, rangeList);
        }
        answer = cryptogram;
        return answer;
    }

    private static List<Integer> findDuplicationRange(String word){
        List<Integer> list = new ArrayList<>();
        String[] splitWord = word.split("");
        int start = 0;
        int end = 0;
        for(int i=1; i< word.length(); i++){
            if(splitWord[i-1].equals(splitWord[i])){
                end++;
            }
            if(!splitWord[i-1].equals(splitWord[i]) || i == word.length()-1){
                if(end - start >0){
                    list.add(start);
                    list.add(end);
                }
                start = i;
                end = start;
            }
        }
        return list;
    }

    private static String removeDuplication(String word, List<Integer> list){
        for (int i=list.size()-1; i>0; i-=2){
           word =  word.substring(0, list.get(i-1)) + word.substring(list.get(i)+1);
    }
        return word;
    }
}
