package onboarding;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

    public static int addnumber(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}