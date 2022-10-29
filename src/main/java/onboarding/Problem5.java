package onboarding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int[] result = calculateMoney(money);
        List<Integer> answer = new ArrayList<>(Arrays.stream(result).boxed().collect(Collectors.toList()));
        return answer;
    }
    //ver1  greedy algorithm
    public static int[] calculateMoney(int money) {
        int[] wont = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] result = new int[9];
        while (money != 0) {
            for (int i = 0; i < wont.length; i++) {
                if (money < wont[i]) continue;
                result[i] += (money / wont[i]);
                money %= wont[i];
            }
        }
        return result;
    }

}
