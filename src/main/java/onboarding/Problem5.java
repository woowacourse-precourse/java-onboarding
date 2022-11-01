package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5
 * @author Davin An
 * @version 1.0
 */
public class Problem5 {

    /**
     * Converts amount of money into currency units
     * @param money Amount of money to convert
     * @return List containing the amount for each unit
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int j : unit) {
            answer.add(money / j);
            money %= j;
        }
        return answer;
    }

    public static void main(String[] args) {}
}
