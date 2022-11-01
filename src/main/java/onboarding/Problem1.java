package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        //연산값 저장
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        int sum = 0;
        int product = 1;


        //예외인 경우 -1 return
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            answer = -1;
        } else {
            for (int pages : pobi) {
                String page = Integer.toString(pages);
                for (char num : page.toCharArray()) {
                    sum += Character.getNumericValue(num);
                    product *= Character.getNumericValue(num);
                }
                p.add(sum);
                p.add(product);
                sum = 0;
                product = 1;
            }
            for (int pages : crong) {
                String page = Integer.toString(pages);
                for (char num : page.toCharArray()) {
                    sum += Character.getNumericValue(num);
                    product *= Character.getNumericValue(num);
                }
                c.add(sum);
                c.add(product);
                sum = 0;
                product = 1;
            }

            int pmax = Collections.max(p);
            int cmax = Collections.max(c);

            if (pmax == cmax) answer = 0;
            else if (pmax > cmax) answer = 1;
            else answer = 2;
        }
        return answer;
    }
}