package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<Integer> delete_list = new ArrayList<Integer>();   // 없어져야 할 index 정보

        // 2개 연속되는 문자가 없어질 때까지 진행
        while (true){
            for (int i=0; i<cryptogram.length()-1; i++){
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)){ // 동일한 문자가 연속해서 나올 경우 list에 추가
                    delete_list.add(i);
                    delete_list.add(i+1);
                    i+=1;
                }
            }
            String tmp = "";

            for (int i=0; i<cryptogram.length(); i++) {
                if (!delete_list.contains(i))   //중복되지 않은 값으로만 이루어진 string을 다시 생성
                    tmp += cryptogram.charAt(i);
            }
            cryptogram = tmp;

            //연속되는 문자가 없는 경우
            if (delete_list.isEmpty())
                break;

            delete_list.clear();
        }

        return cryptogram;
    }
}