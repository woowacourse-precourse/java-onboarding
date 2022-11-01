package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDup(getListFromString(cryptogram));
        return answer;
    }
    // string을 리스트로 만든다.
    // 리스트를 돌리면서 겹치는 부분을 제거한다.


    public static String[] getListFromString(String cryptogram){
        return cryptogram.split("");
    }

    public static String removeDup(String[] cryptoList){
        List<String> removeDupList = new ArrayList<>();
        for (String str : cryptoList) {
            if(removeDupList.size()==0){
                removeDupList.add(str);
            }else {
                if(removeDupList.get(removeDupList.size()-1).equals(str)){
                    removeDupList.remove(removeDupList.size()-1);
                }else{
                    removeDupList.add(str);
                }
            }
        }
        return String.join("", removeDupList);
    }
}

