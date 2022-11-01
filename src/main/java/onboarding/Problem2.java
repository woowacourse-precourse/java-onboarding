package onboarding;

import java.util.ArrayList;
import java.util.List;

/*기능 요구 사항*/
/* 1. 연속하는 중복 문자들을 삭제한 결과를 return
<solution>
 * - 반복문을 통해 중복되는 문자가 없을 때까지 반복하여 return
 * - 중복되는 문자가 있는지 확인하는 함수 사용 : check()
 * - ans : 연속 되지 않는 경우 list에 넣어 관리
 * - cryptogram : 암호문은 계속 해독해나가기 때문에 변경
 */
public class Problem2 {
    /* 중복되는 문자가 있는지 확인하는 함수 */
    static boolean check(List<Character> letter){
        for(int i=1; i<letter.size(); i++){
            if(letter.get(i) == letter.get(i-1)) return true;
        }
        return false;
    }
    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> ans = new ArrayList<Character>();

        do{
            ans.clear();
            for (int i = 0; i < cryptogram.length(); i++) {
                if (i!=cryptogram.length()-1&&cryptogram.charAt(i) == cryptogram.charAt(i+1)) continue;
                if (i!=0&&cryptogram.charAt(i) == cryptogram.charAt(i-1)) continue;
                ans.add(cryptogram.charAt(i));
            }
            cryptogram = "";
            for(int i=0; i<ans.size(); i++)
                cryptogram += ans.get(i);
        }while(check(ans));

        for(int i=0; i<ans.size(); i++)
            answer += ans.get(i);

        return answer;
    }
}
