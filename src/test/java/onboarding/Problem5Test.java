package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {

    static List<Integer> answer;
    static int[] arrMoney = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};


    @Test
    void 수도코드() {
        List<Integer> result = Arrays.asList(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(solution(50237)).isEqualTo(result);
    }

    private List<Integer> solution(int money) {
        answer = new ArrayList<Integer>();
        for (int i=0; i< arrMoney.length; i++){
            answer.add(change(money,arrMoney[i]));
            money = leftMoney(money,arrMoney[i]);
        }
        return answer;
    }

    @Test
    void 지폐_바꾸기() {
        assertThat(change(50237,50000)).isEqualTo(1);
    }

    private int change(int input, int change) {
        int answer = 0;
        if(input >= change){
            answer = input / change;
        }
        return answer;
    }

    int leftMoney(int input, int change){
        int answer = input % change;
        return answer;
    }
}