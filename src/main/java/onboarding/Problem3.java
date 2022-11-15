package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        //1부터 number 까지 새야함!
        for (int i=1 ; i<=number ; i++){
            String s = Integer.toString(i);
            ArrayList<Character> list = new ArrayList<Character>();
            //자 분해들어갑니다. 우선 내가 센 숫자를 문자열로 쪼개버려 넥슬라이스!
            for (int j=0 ; j<s.length() ; j++){
                list.add(s.charAt(j));
            }
            // 그다음 뭐다? 하나하나 쪼개야한다 ~ 왜냐? 3 혹은 6 혹은 9가 있을때마다 박수를 쳐야하기때문에 ~~
            // 하지만 쪼갠 숫자는 문자의 숫자기 때문에 0 아스키코드 값인 48을 빼고 비교해야한다 ~
            for (int k=0 ; k<list.size() ; k++){
                if ((int)list.get(k)-48 == 3 || (int)list.get(k)-48 == 6 || (int)list.get(k)-48 == 9){
                    cnt += 1;
                }
            }
        }

        int answer = 0;
        answer = cnt;
        return answer;
    }
}
