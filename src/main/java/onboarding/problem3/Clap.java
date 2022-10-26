package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class Clap {
    public static int clap(int number) {
        int count=0;
        List<Integer> numbers = mapList(number);
        for (int num:numbers) {
            if (has369(num))
                count++;
        }
        return count;
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
