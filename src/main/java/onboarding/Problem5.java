package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 어레이리스트 배열로 잡아주기! >> arraylist 부분은 공부안해서 책으로 살펴볼것
        List<Integer> answer = new ArrayList<>();

        // 각 회폐의 리스트 잡아주기!
        int[] MONEYLIST = {50000, 10000, 5000, 1000, 500, 100 ,50, 10, 1};

        // 반복문을 통해 몫을 arraylist에 올려주고 나머지 값은 다시 money변수로 옮기기!
        for (int i = 0; i <= 8; i ++){
            // arraylist에 올려주는 식 >> int = int / int (파이썬이랑은 다르다!)
            int a = money / MONEYLIST[i];
            answer.add(a);

            // 몫을 제외한 나머지를 money로 반환
            money = money % MONEYLIST[i];
        }

        // solution method의 값을 answer로 return(이때 return 형태는 LIST<INTEGER>형태로 반환)
        return answer;
    }
}
