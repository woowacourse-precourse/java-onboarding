package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int age = number;
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0,number);
        for(int i = 1;i<number;i++){
            list.add(i,age-=1);
        }

        for(int i = 0;i<list.size();i++) {
            int quotient = list.get(i)/10;
            int remainder = list.get(i)%10;
            if((remainder == 3&&quotient!=3) || (remainder == 6 &&quotient!=6)|| (remainder == 9&&quotient!=9)) {
                answer = answer+1;

            }
            if ((quotient== 3&&remainder==3)|| (quotient == 6&&remainder==6) || (quotient ==9 && remainder ==9)) {
                answer = answer + 2;

            }
            if((quotient==3 && remainder!=3)|| (quotient==6 && remainder!=6)||(quotient==9 && remainder!=9)) {
                answer = answer+1;
            }
        }

        return answer;
    }
}
