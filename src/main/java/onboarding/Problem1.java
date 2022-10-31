package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        if (pobi.equals(List.of(1, 2)) || pobi.equals(List.of(399, 400))) {
            return -1;
        } else if (crong.equals(List.of(1, 2)) || crong.equals(List.of(399, 400))) {
            return -1;
        }

        int leftPage = toBigNumber(add(sperater(pobi.get(0))), multiply(sperater(pobi.get(0))));
        int rightPage = toBigNumber(add(sperater(pobi.get(1))), multiply(sperater(pobi.get(1))));
        int pobiNumber = toBigNumber(leftPage, rightPage);
        leftPage = toBigNumber(add(sperater(crong.get(0))), multiply(sperater(crong.get(0))));
        rightPage = toBigNumber(add(sperater(crong.get(1))), multiply(sperater(crong.get(1))));
        int crongNumber = toBigNumber(leftPage, rightPage);

        int answer = Compare(pobiNumber, crongNumber);
        return answer;
    }

    public static ArrayList<Integer> sperater(int page) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (page > 0) {
            numbers.add(page % 10);
            page /= 10;
        }
        return numbers;
    }

    public static int add(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    public static int multiply(ArrayList<Integer> numbers) {
        int sum = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            sum *= numbers.get(i);
        }
        return sum;
    }

    public static int toBigNumber(int number1, int number2) {
        if (number1 - number2 >= 0) {
            return number1;
        } else {
            return number2;
        }
    }

    public static int Compare(int pobiNumber, int crongNumber) {
        if (pobiNumber - crongNumber > 0) {
            return 1;
        } else if (pobiNumber - crongNumber < 0) {
            return 2;
        } else {
            return 0;
        }
    }
}
