package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        //암호문 리스트로 변환
        List<String> cryptogramList = wordToList(cryptogram);
        answer = DeleteCoupleWord(cryptogramList);
        return answer;
    }
    public static List wordToList(String word){
        return new ArrayList<>(Arrays.asList(word.split("")));
    }

    public static String DeleteCoupleWord(List<String> cryptogramList){
        while (true) {
            int check = 0;
            for (int i = 1; i < cryptogramList.size(); i++) {
                //리스트 순회 하면서 연속된 문자 제거
                if (cryptogramList.get(i).equals(cryptogramList.get(i - 1)) ) {
                    cryptogramList.remove(i);
                    cryptogramList.remove(i-1);
                    check = 1;
                    i-=2;
                }
            }
            //연속된 문자가 없으면 종료
            if (check == 0) {
                break;
            }
        }
        return String.join("", cryptogramList);
    }
}
