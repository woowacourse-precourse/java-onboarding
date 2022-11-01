package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //pobi와 crong의 길이는 2이다.
        if (pobi.size() != 2 && crong.size() != 2){
            return -1;
        }

        //pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
        if (pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1){
            return -1;
        }
        return compareLogic(pobi, crong);
    }

    private static int compareLogic(List<Integer> pobi, List<Integer> crong){
        int pobi_num = 0;
        int crong_num = 0;
        int answer = 0;

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(plusLogic(pobi));
        a.add(multiplyLogic(pobi));
        b.add(plusLogic(crong));
        b.add(multiplyLogic(crong));

        pobi_num = Collections.max(a);
        crong_num = Collections.max(b);

        if (pobi_num > crong_num){
            return answer = 1;
        }

        if (pobi_num < crong_num){
            return answer = 2;
        }

        if (pobi_num == crong_num){
            return answer = 0;
        }
        return answer;

    }


    private static int plusLogic(List<Integer> lst){
        List<Integer> plus = new ArrayList<>();

        for(int i = 0; i < lst.size(); i++) {
            String s = Integer.toString(lst.get(i));

            for (int j = 0; j < s.length(); j++) {
                int sum = 0;
                sum += Integer.parseInt(s.substring(i, i + 1));
                plus.add(sum);
            }
        }
        return Collections.max(plus);
    }

    private static int multiplyLogic(List<Integer> lst){
        List<Integer> multiple = new ArrayList<>();

        for(int i = 0; i < lst.size(); i++) {
            String s = Integer.toString(lst.get(i));

            for (int j = 0; j < s.length(); j++) {
                int sum = 1;
                sum *= Integer.parseInt(s.substring(i, i + 1));
                multiple.add(sum);
            }
        }
        return Collections.max(multiple);
    }
}