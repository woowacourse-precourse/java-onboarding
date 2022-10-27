package onboarding;

//import java.util.Collections;
import java.util.List;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //first check if pobi and crongs pages are valid
        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);
        int crong_left = crong.get(0);
        int crong_right = crong.get(1);
        //checking pobis pages
        if (pobi_left % 2 != 1 || pobi_left < 1 || pobi_left > 400) {
            return -1;
        }
        if (pobi_right != pobi_left + 1) {
            return -1;
        }
        //checking crongs pages
        if (crong_left % 2 != 1 || crong_left < 1 || crong_left > 400) {
            return -1;
        }
        if (crong_right != crong_left + 1) {
            return -1;
        }

        int pobi_max = addDigits(pobi_left);
        pobi_max = Math.max(pobi_max, multiplyDigits(pobi_left));
        pobi_max = Math.max(pobi_max, addDigits(pobi_right));
        pobi_max = Math.max(pobi_max, multiplyDigits((pobi_right)));
        /*using array
        int[] addMulList = new int[]{addDigits(pobi_left), multiplyDigits(pobi_left), addDigits(pobi_right), multiplyDigits(pobi_right)};
        int pobi_max = Collections.max(addMulList);
        */

        int crong_max = addDigits(crong_left);
        crong_max = Math.max(crong_max, multiplyDigits(crong_left));
        crong_max = Math.max(crong_max, addDigits(crong_right));
        crong_max = Math.max(crong_max, multiplyDigits((crong_right)));

        if (pobi_max > crong_max) {
            return 1;
        } else if (crong_max > pobi_max) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int addDigits(int number) {
        int result = 0;
        while (number > 0) {
            result += (number % 10);
            number = number/10;
        }
        return result;
    }

    private static int multiplyDigits(int number) {
        int result = 1;
        while (number > 0) {
            result *= (number % 10);
            number = number/10;
        }
        return result;
    }
}