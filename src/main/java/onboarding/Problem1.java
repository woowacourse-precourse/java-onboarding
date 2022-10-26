package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        pobi.add(97);
        pobi.add(98);

        List<Integer> crong = new ArrayList<>();
        crong.add(197);
        crong.add(198);

        System.out.println(solution(pobi, crong));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int max = 0;

        for (int page : pobi) {
            int sum = 0;
            int multi = 1;

            while (page != 0) {
                int result = page % 10;
                sum += result;
                multi *= result;
                page /= 10;
            }

            int biggerThanNumber = Math.max(sum, multi);
            if (biggerThanNumber > max) {
                max = biggerThanNumber;
            }
        }

        return 0;
    }
}