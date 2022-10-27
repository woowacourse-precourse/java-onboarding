package onboarding;

import java.util.List;
import java.util.ArrayList;
public class NanoPage{

    public List<Integer> left_page;
    public List<Integer> right_page;

    public Page(List<Integer> people){
        left_page = page_split(people.get(0));
        right_page = page_split(people.get(1));
    }

    public List<Integer> page_split(int num){
        List<Integer> result_page = new ArrayList<Integer>();

        while(num > 0){
            result_page.add(num % 10);
            num /= 10;
        }
        return result_page;
    }

}
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        Page pobi_page = new NanoPage(pobi);
        Page crong_page = new Page(crong);


        return answer;
    }
}

