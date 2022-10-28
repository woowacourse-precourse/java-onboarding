package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();

        int num50000 = money / 50000;
        System.out.println(num50000); // 1
        int leftover = money % 50000;
        System.out.println(leftover); // 237

        int num10000 = leftover / 10000;
        System.out.println(num10000); // 0
        leftover = leftover % 10000;
        System.out.println(leftover); // 237

        int num5000 = leftover / 5000;
        System.out.println(num5000); // 0
        leftover=leftover% 5000;
        System.out.println(leftover); // 237

        int num1000 =  leftover / 1000;
        System.out.println(num1000); // 0
        leftover=leftover% 1000;
        System.out.println(leftover); // 237

        int num500 =  leftover / 500;
        System.out.println(num500); // 0
        leftover=leftover% 500;
        System.out.println(leftover); // 237

        int num100 =  leftover / 100;
        System.out.println(num100); // 2
        leftover=leftover% 100;
        System.out.println(leftover); // 37

        int num50 =  leftover / 50;
        System.out.println(num50); // 0
        leftover=leftover% 50;
        System.out.println(leftover); // 37

        int num10 =  leftover / 10;
        System.out.println(num10); // 3
        leftover=leftover% 10;
        System.out.println(leftover); // 7

        int num1 =  leftover ;
        System.out.println(num1); // 7


        return answer;
    }
}
