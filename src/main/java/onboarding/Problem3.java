package onboarding;
import java.util.ArrayList;
import java.util.List;
public class Problem3 {
    public static int solution(int number) {

        if(number < 1 || number > 10000) return -1;
        int count = 0;

        for (int i = 1; i <= number; i++) {
            count += get369Count(i);
        }
        return count;
    }

    static int get369Count(int number) {
        List<Integer> newList = new ArrayList<Integer>();
        int count = 0;

        while (number > 0) {
            newList.add(number % 10);
            number /= 10;
        }

        for (int i : newList) {
            if(i % 3 == 0 && i != 0) count++;
        }
        return count;
    }
}
