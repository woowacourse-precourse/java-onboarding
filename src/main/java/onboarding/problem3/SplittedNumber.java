package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class SplittedNumber {
    private List<Integer> splittedNumber;

    SplittedNumber(int number) {
        splittedNumber = splitNumToList(number);
    }

    List<Integer> splitNumToList(int number) {
        List<Integer> splitted = new ArrayList<>();
        while (number != 0) {
            splitted.add(0, number % 10);
            number /= 10;
        }
        return splitted;
    }
    int getCountOfThree() {
        return (int)splittedNumber.stream()
                .filter(digit -> digit % 3 == 0)
                .filter(digit -> digit != 0)
                .count();
    }
    public int length() {
        return splittedNumber.size();
    }
    public int getAsInt() {
        int result = 0;
        int size = length() - 1;
        for (int i = 0; i < length(); i++) {
            result += splittedNumber.get(i) * Math.pow(10, size);
            size--;
        }
        return result;
    }
}
