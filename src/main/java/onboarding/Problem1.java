package onboarding;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }
    public static int getbignumber(List<Integer> list){
        int leftpage = Math.max(addnumber(list.get(0)), multi_number((list.get(0))));
        int rightpage = Math.max(addnumber(list.get(1)), multi_number((list.get(1))));
        return Math.max(leftpage, rightpage);
    }

    public static int addnumber(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static boolean is_valid(List<Integer> list){
        if (list.get(0) < 1 || list.get(0) > 400 || list.get(0) % 2 == 0
                || list.get(1) < 1 || list.get(1) > 400 || list.get(1) % 2 == 1)
            return false;
        if (list.get(1) - list.get(0) != 1)
            return false;
        return true;
    }

    public static int multi_number(int n){
        int sum = 1;
        while (n > 0){
            sum *= n % 10;
            n /= 10;
        }
        return sum;
    }
}