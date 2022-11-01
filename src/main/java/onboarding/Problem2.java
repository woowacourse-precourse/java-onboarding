package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] arr = cryptogram.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char a : arr)
            list.add(a);

        while(true) {
            boolean check = false;                  // 반목문 나갈때의 체크 사항
            for(int i = 1 ; i < list.size(); i++) {
                char c = list.get(i-1);
                if(list.get(i).equals(c)) {         //전값과 같은 값이 있으면 삭제
                    list.remove(i);
                    list.remove(i-1);
                    check = true;
                }
            }
            if(!check)
                break;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String answer = sb.toString();
        return answer;
    }
}
