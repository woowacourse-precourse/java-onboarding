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

    public List<Integer> getLeft_page() {
        return left_page;
    }

    public List<Integer> getRight_page() {
        return right_page;
    }
}
class Problem1 {
    static int max_score(Page page)
    {
        int[] page_sum_mult = {0, 1, 0, 1};
        int max = 0;
        for (int i : page.getLeft_page()){
            page_sum_mult[0] += i;
            page_sum_mult[1] *= i;
        }
        for (int i : page.getRight_page()){
            page_sum_mult[2] += i;
            page_sum_mult[3] *= i;
        }
        for(int i: page_sum_mult)
            max = Math.max(i, max);
        return max;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        Page pobi_page = new NanoPage(pobi);
        Page crong_page = new Page(crong);
        int pobi_score = max_score(pobi_page);
        int crong_score = max_score(crong_page);

        if (pobi_score > crong_score)
            answer = 1;
        else if (crong_score > pobi_score)
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}

