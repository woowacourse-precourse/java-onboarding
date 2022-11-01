package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /*
        count 변수를 돈 단위로 활용
        한국 돈은 50000->10000->5000 이런 규칙이 있으므로 check 변수를 통해 해당 규칙을 활용함
        5로 나누게 될 경우 check = false, 2로 나누게 될 경우 check = true
        예외로 count 변수가 5인 경우 해당 돈 단위가 존재하지 않으며, 다음 단위가 1 뿐이므로 1로 변환해서 계산
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int count = 50000;
        boolean check = true;

        while(count > 1){
            if(count == 5){
                count = 1;
            }
            answer.add(money/count);
            money %= count;

            if(check) {
                count /= 5;
                check = false;
            }else{
                count /= 2;
                check = true;
            }
        }
        return answer;
    }
}
