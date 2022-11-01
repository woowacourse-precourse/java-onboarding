package onboarding;

import java.util.ArrayList;

public class Problem3 {
    static ArrayList<Integer> CLAP = new ArrayList<>();
    CLAP.add(3);
    CLAP.add(6);
    CLAP.add(9);

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static ArrayList<Integer> digitList(int num) {
        ArrayList<Integer> digitList = new ArrayList<>();
        while (num > 0) {
            digitList.add(num % 10);
            num /= 10;
        }
        return digitList;
    }

    private static int findNumOfClap(ArrayList<Integer> digitList) {
        int clap = 0;
        for (Integer num : digitList) {
            clap += isClap(num);
        }
        return clap;
    }

    private static Integer isClap(Integer num) {
        if (CLAP.contains(num)) {
            return 1;
        }
        return 0;
    }
}
