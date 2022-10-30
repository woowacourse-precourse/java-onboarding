package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem3 {
    public static int solution(int number) {
        try {
            validate(number);
            int answer = 0;
            for (int i = 1; i <= number; i++) {
                answer += count369ByNumber(i);
            }
            return answer;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    static int count369ByNumber(int number) {
        ArrayList<String> arrayListOfNumber = convertNumberToArrayList(number);
        int count = countByArrayListOfNumber(arrayListOfNumber);
        return count;
    }

    static int countByArrayListOfNumber(ArrayList<String> arrayListOfNumber) {
        int count = 0;
        count += Collections.frequency(arrayListOfNumber, "3");
        count += Collections.frequency(arrayListOfNumber, "6");
        count += Collections.frequency(arrayListOfNumber, "9");
        return count;
    }

    static ArrayList<String> convertNumberToArrayList(int number) {
        String stringOfNumber = Integer.toString(number);
        ArrayList<String> arrayListOfStringNumber= new ArrayList<>(Arrays.asList(stringOfNumber.split("")));
        return arrayListOfStringNumber;
    }

    static void validate(int number) throws Exception {
        if (number < 1 || number > 10000) {
            throw new Exception("1 이상 10000 이하의 자연수만 계산할 수 있습니다");
        }
    }
}
