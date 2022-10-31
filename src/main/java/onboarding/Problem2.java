package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder ans = new StringBuilder(cryptogram);

        // 같은게 없는지 확인하는 변수
        boolean check = true;
        while(check){
            check = false;
            for(int i=0; i<ans.length(); i++){
                //전의 알파벳과 동일한게 있다면 알파벳과 다른게 나올때까지 실행
                if(ans.charAt(i) == ans.charAt(i+1)){
                    for(int j=i+1; j<ans.length(); j++){
                        //두번째 알파벳부터 삭제 시작
                        if(ans.charAt(i) == ans.charAt(j))
                            ans.deleteCharAt(j--);
                    }
                    ans.deleteCharAt(i);
                    check = true;
                }
            }
            if(!check) break;
        }
        String answer = ans.toString();
        return answer;
    }
}
