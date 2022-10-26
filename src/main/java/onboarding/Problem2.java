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
        List<Character> tmp = new ArrayList<>();
        tmp.add(list.get(0));
        int list_idx=1;
        int tmp_idx=0;
        while(list_idx<list.size()){
            if(list.get(list_idx)==tmp.get(tmp_idx)){
                if(list_idx==list.size()-1){
                    tmp.remove(tmp_idx);
                    break;
                }
                else{
                    if(list.get(list_idx)==list.get(list_idx+1)){
                        list_idx++;
                    }
                    else{
                        tmp.remove(tmp_idx);
                        tmp_idx--;
                        list_idx++;
                    }
                }
            }
            else{
                tmp.add(list.get(list_idx));
                tmp_idx++;
                list_idx++;
            }
        }

        for(int i=0;i<tmp.size();i++) answer.append(tmp.get(i));
        return answer.toString();
    }
}
