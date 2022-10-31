package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static List<Integer> getNumList(int num) {
        List<Integer> numList = new ArrayList<>();
        while(num>0) {
            numList.add(num%10);
            num/=10;
        }
        return numList;
    }

    public static int solution(int number) {
        int cnt = 0;

        for(int i = 1; i <= number; i++) {
            List<Integer> numList = getNumList(i);
            for (Integer n : numList) {
                if (n == 3 || n == 6 || n == 9) {
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
}
