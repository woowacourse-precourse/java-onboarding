package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer= new StringBuilder();
        List<Character>list = new ArrayList<>();
        for(int i=0;i<cryptogram.length();i++){
            list.add(cryptogram.charAt(i));
        }
        while(true){
            int idx=0;
            int cnt=0;
            while(cnt<list.size()-1){

                if(list.get(cnt)==list.get(cnt+1)){
                    list.remove(cnt);
                    list.remove(cnt);
                    idx=1;
                }
            cnt++;
            }
            if(idx==0) break;
        }
        for(int i=0;i<list.size();i++) answer.append(list.get(i));
        return answer.toString();
    }
}
