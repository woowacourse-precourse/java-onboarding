package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(getAnswer(pobi) && getAnswer(pobi)){
            int max1 = cal(pobi);
            int max2 = cal(crong);

            if (max1 > max2){
                answer = 1;
            } else if (max1 == max2){
                answer = 0;
            } else{
                answer = 2;
            }
        }
        else{
            answer = -1;
        }
        /*
        1. 우선 리스트 내부 숫자들이 제대로 1씩 차이나는 숫자인지 확인한다.
        2. 각 리스트를 곱한 숫자와 더한 숫자중 더 큰걸 저장
        3. 두 숫자를 비교해서 숫자를 return 하기
        * */

        return answer;
    }

    static boolean getAnswer(List<Integer> mon){
        if ((mon.get(1) - mon.get(0) == 1) && (mon.get(0)%2 == 1)){
            return true;
        }
        else{
            return false;
        }
    }

    static int cal(List<Integer> mon){
        int answer = 0;

        for(int i=0; i<2; i++){
            int num = mon.get(i);
            int mul = 1;
            int sum = 0;

            ArrayList<Integer> arrNum = new ArrayList<>();
            while(num > 0) {
                arrNum.add(num % 10);
                sum += num % 10;
                mul *= num % 10;
                num /= 10;
            }
            answer = max(sum, mul);
        }
        return answer;
    }
}