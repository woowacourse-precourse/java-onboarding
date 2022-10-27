package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Problem1 {

    public static int maxNum(List<Integer> li) {
        int maxP = 0;


        for (int p : li) {
            String page = Integer.toString(p);
            int a_tmpp = 0;
            int m_tmpp = 1;

            int max_tmp = 0;

            for (int i = 0; i < page.length(); i++) {

                //각 자리 수 중 0이 있을 경우는 예외사항(?)
                int n = page.charAt(i) - '0';
                if (n == 0) { return 0; }
                a_tmpp += n;
                m_tmpp *= n;
            }
            System.out.println(p);
            System.out.println("a_tmpp="+a_tmpp);
            System.out.println("m_tmpp = " + m_tmpp);


            if (a_tmpp >= m_tmpp) {
                max_tmp = a_tmpp;
            }
            else {
                max_tmp = m_tmpp;
            }

            if (max_tmp >= maxP) {
                maxP = max_tmp;
            }

        }

        return maxP;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax = maxNum(pobi);
        int crongMax = maxNum(crong);


        System.out.println("pobiMax=" + pobiMax);
        System.out.println("crongMax=" + crongMax);


        if (pobiMax == 0 || crongMax == 0) {
            return -1;
        }


        if (pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        } else if (pobiMax == crongMax) {
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args){

        List<Integer> pobi = new ArrayList<Integer>();
        List<Integer> crong = new ArrayList<Integer>();


        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 2; i++){
            pobi.add(sc.nextInt());
        }


        //nextInt = 공백 구분분
        for (int i = 0; i < 2; i++){
            crong.add(sc.nextInt());
        }


        System.out.println(solution(pobi,crong));



    }
}