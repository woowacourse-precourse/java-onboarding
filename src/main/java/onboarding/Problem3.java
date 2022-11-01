package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    private static ArrayList<Integer> decompose(Integer number) {
        //자릿수로 분해하기
        ArrayList<Integer> decomposedList = new ArrayList<>();
        while (number > 0) {
            decomposedList.add(number % 10);
            number /= 10;
        }
        return decomposedList;
    }

    private static int include369(ArrayList<Integer> arrNumber) {
        //3, 6, 9가 있는 개수만큼 값 더하기
        int total = 0;
        for (Integer arrNum : arrNumber) {
            if (arrNum == 3 || arrNum == 6 || arrNum == 9) {
                total++;
            }
        }
        return total;
    }


    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            ArrayList<Integer> arrNumber = decompose(i);
            answer += include369(arrNumber);
        }
        return answer;
    }
}
