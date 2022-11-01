package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String[] strarr = cryptogram.split("");
        List<String> strlist = new ArrayList<>(Arrays.asList(strarr));
        findAndRemoveRedundancyLoop(strlist);
        StringBuilder sb = new StringBuilder();
        for(String item : strlist){
            sb.append(item);
        }
        answer = sb.toString();
        return answer;
    }
    public static boolean findAndRemoveRedundancy(List<String> strlist){
        int flag = 0;   //연속문자 3이상 검사
        boolean flagRemove = false;
        String redunChar = "A";
        int cnt = strlist.size();
        for(int i=0; i<cnt - 1; i++){
            if(flag == 1){
                if(strlist.get(i).equals(redunChar)){
                    strlist.remove(i);
                    i-=1;
                    cnt--;
                }
                else {
                    flag = 0;
                }
            }
            else if(strlist.get(i).equals(strlist.get(i+1))){
                redunChar = strlist.get(i);
                strlist.remove(i);
                strlist.remove(i);
                flag = 1;
                i-=1;
                cnt-=2;
                flagRemove = true;
            }
        }
        return flagRemove;
    }
    public static void findAndRemoveRedundancyLoop(List<String> strlist){
        while (findAndRemoveRedundancy(strlist));
    }

}
