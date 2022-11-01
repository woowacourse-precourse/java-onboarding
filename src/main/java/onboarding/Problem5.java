/*
 * Problem5
 *
 * v1.2
 *
 * 2022.11.01
 *
 * 저작권 주의
 */

package onboarding;
import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] exchangeMoneyArray={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int remainMoney=money;

        for (int exchangeMoney : exchangeMoneyArray) {
            answer.add(quotientAndRemainder(remainMoney, exchangeMoney, 0));
            remainMoney = quotientAndRemainder(remainMoney, exchangeMoney, 1);
        }

        return answer;
    }

    static int quotientAndRemainder(int number, int numberToDivide, int index){
        int[] array= new int[2];
        int quotient = number / numberToDivide;
        int remainder= number % numberToDivide;
        array[0]= quotient;
        array[1]= remainder;
        return array[index];
    }

}
