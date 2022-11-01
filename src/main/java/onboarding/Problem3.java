package onboarding;

import java.util.ArrayList;

class Clap {
    ArrayList<Integer> numberList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();

    Clap(int number) throws RestrictException {
        if (number > 10000 || number < 1) {
            throw new RestrictException("OutOfRange");
        }
        for (int i = 1; i <= number; i++) {
            numberList.add(i);
        }
        for (Integer value : numberList) {
            int radix = 1;
            for (int i = 1; radix <= value; i++) {
                stringList.add(value.toString().split("")[i - 1]);
                radix *= 10;
            }
        }
    }
}

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
