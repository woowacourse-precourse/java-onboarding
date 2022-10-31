package onboarding.domain.problem3;

import java.util.ArrayList;
import java.util.List;

public class Clap {
    public static int clap(int number) {
        if (outOfRange(number))
            throw new IllegalArgumentException("1이상 10,000 이하의 자연수를 입력해주세요.");
        int count=0;
        List<Integer> numbers = mapList(number);
        for (int num:numbers) {
            if (has369(num))
                count++;
        }
        return count;
    }

    private static boolean outOfRange(int number) {
        return (number<1 && number >10000);
    }

    private static boolean has369(int num) {
        return num % 3 == 0 && num != 0;
    }

    private static List<Integer> mapList(int number) {
        List<Integer> mapped = new ArrayList<>();
        String stringNumber = Integer.toString(number);
        int num;
        for (int i=0; i<stringNumber.length();i++) {
            num = Character.getNumericValue(stringNumber.charAt(i));
            mapped.add(num);
        }
        return mapped;
    }
}
