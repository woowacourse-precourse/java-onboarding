package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static List<Integer> eachDigit(int num) {
        List<Integer> digitList = new ArrayList<>();
        while(num > 0) {
            digitList.add(num % 10);
            num /= 10;
        }
        return digitList;
    }
    public static Boolean clapTime(int num) {
        if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) return true;
        return false;
    }
    public static int Game(int num) {
        int tmp;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            tmp = i;
            List<Integer> digitList = eachDigit(tmp);
            for (Integer list: digitList) {
                if (clapTime(list)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        answer = Game(number);
        return answer;
    }
}
