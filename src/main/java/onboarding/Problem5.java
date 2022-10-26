package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        /*
        * 나누는 금액이 1/2와 1/5 순서대로 줄어들고 있다.
        * 몫을 리스트에 저장하고, 나머지를 다음 계산을 위한 돈으로 할당한다.
        * */
        int divide = 100_000;
        for(int i=0; i<8; i++){
            divide = (i%2==0) ? divide/2 : divide/5;

            int[] qar = quotientAndRemainder(money, divide);
            answer.add(qar[0]);
            money = qar[1];
        }

        /*
        * 1원은 나눌 필요 없이 바로 추가한다.
        * */
        answer.add(money);

        return answer;
    }

    /*
    * qar[0] : 몫을 저장한다.
    * qar[1] : 나머지를 저장한다.
    * */
    private static int[] quotientAndRemainder(int num, int divide){
        int[] qar = new int[2];
        qar[0] = num/divide;
        qar[1] = num%divide;
        return qar;
    }
}
