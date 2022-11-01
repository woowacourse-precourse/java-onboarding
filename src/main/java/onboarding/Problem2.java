package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        ArrayList<String> mylist=new ArrayList<>(List.of(cryptogram.split("")));

        for(int i=0;i<mylist.size()-1;i++){
            if((mylist.get(i)).equals(mylist.get(i+1))){
                mylist.remove(i);
                mylist.remove(i);
                i=i-2;
            }
        }
        for(String i:mylist){
            answer+=i;
        }
        return answer;
    }
}
