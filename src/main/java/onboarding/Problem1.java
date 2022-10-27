package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Integer> pobi_page = new ArrayList<Integer>();
        List<Integer> crong_page = new ArrayList<Integer>();
        int answer = Integer.MAX_VALUE;

        if (exception_check(pobi) || exception_check(crong) == -1 {
            answer = -1;
        } else{
            for (int i = 0; i < 2; i++) {
                int sum = 0;
                int mul = 1;
                int num = pobi.get(i);
                while (num != 0) {
                    sum += num % 10;
                    mul *= num % 10;
                    num /= 10;
                }
                pobi_page.add(sum);
                pobi_page.add(mul);
            }

            for (int i = 0; i < 2; i++) {
                int sum = 0;
                int mul = 1;
                int num = crong.get(i);
                while (num != 0) {
                    sum += num % 10;
                    mul *= num % 10;
                    num /= 10;
                }
                crong_page.add(sum);
                crong_page.add(mul);
            }
            answer = (Collections.max(pobi_page) > Collections.max(crong_page)) ? 1 : (Collections.max(pobi_page) == Collections.max(crong_page)) ? 0 : 2;
            return answer;
        }
    }

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<Integer>();
        List<Integer> crong= new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        pobi.add(sc.nextInt());
        pobi.add(sc.nextInt());
        crong.add(sc.nextInt());
        crong.add(sc.nextInt());

        System.out.println(solution(pobi, crong));
    }

}