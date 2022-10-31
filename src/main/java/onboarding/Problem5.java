package onboarding;

// 돈의 액수 money가 매개변수로 주어질 때,                                                                              입력값 액수
// 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지   입력값을 큰 수 순서대로 나누고
// 금액이 큰 순서대로 리스트/배열에 담아 return 하도록                                                                  나머지 값을 다음 큰 수로 나눈다.
// solution 메서드를 완성하라.                                                                                        몫을 저장 하여 리스트 형식으로 반환.


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = get_answer(money);

        return answer;
    }

    public static List<Integer> get_answer( int money){

        List<Integer> answer = new LinkedList<Integer>();
        int temp = 0;

        //50000
        temp = div_money(answer, money, 50000);
        //10000
        temp = div_money(answer, temp, 10000);
        //5000
        temp = div_money(answer, temp, 5000);
        //1000
        temp = div_money(answer, temp, 1000);
        //500
        temp = div_money(answer, temp, 500);
        //100
        temp = div_money(answer, temp, 100);
        //50
        temp = div_money(answer, temp, 50);
        //10
        temp = div_money(answer, temp, 10);
        //1
        temp = div_money(answer, temp, 1);

        return answer;
    }

    private static int div_money(List<Integer> answer, int temp, int toDiv) {
        answer.add(temp/toDiv);
        temp = temp%toDiv;
        return temp;
    }
}
