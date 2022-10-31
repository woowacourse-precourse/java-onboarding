package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Problem1 {
    public static int calculator(int page_num, char op, int result){
        while(page_num>0){
            if(op == '*'){
                result *= (page_num%10);
            }
            else if(op == '+'){
                result += (page_num%10);
            }
            page_num /= 10;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        PriorityQueue<Integer> pobiQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> crongQ = new PriorityQueue<>(Collections.reverseOrder());

        int pobi_left = pobi.get(0); int pobi_right =  pobi.get(1);
        int crong_left = crong.get(0); int crong_right = crong.get(1);

        if(Math.abs(pobi_left-pobi_right)>1 || Math.abs(crong_left-crong_right)>1){
            return -1;
        }

        pobiQ.add(calculator(pobi_left, '+', 0));
        pobiQ.add(calculator(pobi_right, '+', 0));
        pobiQ.add(calculator(pobi_left, '*', 1));
        pobiQ.add(calculator(pobi_right, '*', 1));

        crongQ.add(calculator(crong_left, '+', 0));
        crongQ.add(calculator(crong_right, '+', 0));
        crongQ.add(calculator(crong_left, '*', 1));
        crongQ.add(calculator(crong_right, '*', 1));

        int pobi_max = pobiQ.element();
        int crong_max = crongQ.element();

        if(pobi_max > crong_max){
            answer = 1;
        } else if(crong_max > pobi_max){
            answer = 2;
        } else if(pobi_max == crong_max){
            answer = 0;
        }

        return answer;
    }
}