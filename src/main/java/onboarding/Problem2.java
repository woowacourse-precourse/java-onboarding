package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        // save cryptogram string as a List
        List<String> cryptogramArray = Arrays.asList(cryptogram.split(""));

        // add word to List if same word is not in front or back
        // if same word is not in front or back add count
        // count 0 means no word duplicated
        while(true){
            ArrayList<String> temp = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < cryptogramArray.size(); i++) {
                if(i==0){
                    if(!(cryptogramArray.get(i+1).equals(cryptogramArray.get(i)))){
                        temp.add(cryptogramArray.get(i));
                    } else {
                        count++;
                    }
                } else if(i == cryptogramArray.size()-1){
                    if(!(cryptogramArray.get(i-1).equals(cryptogramArray.get(i)))){
                        temp.add(cryptogramArray.get(i));
                    } else {
                        count++;
                    }
                } else {
                    if(!(cryptogramArray.get(i-1).equals(cryptogramArray.get(i))) && !(cryptogramArray.get(i).equals(cryptogramArray.get(i+1)))){
                        temp.add(cryptogramArray.get(i));
                    } else {
                        count++;
                    }
                }
            }
            cryptogramArray = temp;
            if(count == 0) break;
        }

        return answer;
    }
}
