package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] cryptoArr = cryptogram.split("");
        ArrayList<String> answerList = new ArrayList<>(Arrays.asList(cryptoArr));
        ArrayList<String> tempList = new ArrayList<>();
        boolean removed = true;         // 반복시 중복 제거 여부(재실시할지 판단)
        boolean duplicated = false;     // 수정한지 여부
        while(removed){
            removed = false;
            if (answerList.size() == 0){
                return "";
            }
            String curr = answerList.get(0);
            tempList.clear();
            for(int i=1;i<answerList.size();i++) {
                String next = answerList.get(i);
                if  (curr.equals(next)) {
                    removed = true;
                    duplicated = true;
                } else if(duplicated){
                    curr = next;
                    duplicated = false;
                } else {
                    tempList.add(curr);
                    curr = next;
                }
            }
            if (!duplicated) {
                tempList.add(curr);
            }
            answerList.clear();
            answerList.addAll(tempList);
            }

        return String.join("", answerList);
    }
}
