package onboarding;

import java.util.*;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Random rd = new Random();

        int r_page, l_page, l_add, l_mul, r_add, r_mul, p_result, c_result;
        while (true) {
            r_page = 2 * rd.nextInt(200);
            l_page = r_page - 1;
            if (r_page > 3 || r_page < 399) {
                break;
            }
            ;
        }
            pobi.add(l_page);
            pobi.add(r_page);
            while (true) {
                r_page = 2 * rd.nextInt(200);
                l_page = r_page - 1;
                if (r_page > 3 || r_page < 399) {
                    break;
                }
                ;
            }
            ;
            crong.add(l_page);
            crong.add(r_page);

            l_add = (pobi.get(0) / 100) + ((pobi.get(0) % 100) / 10) + (pobi.get(0) % 10);
            l_mul = (pobi.get(0) / 100) * ((pobi.get(0) % 100) / 10) * (pobi.get(0) % 10);
            r_add = (pobi.get(1) / 100) + ((pobi.get(1) % 100) / 10) + (pobi.get(1) % 10);
            r_mul = (pobi.get(1) / 100) * ((pobi.get(1) % 100) / 10) * (pobi.get(1) % 10);
            p_result = Math.max(Math.max(l_add, l_mul), Math.max(r_add, r_mul));
            l_add = (crong.get(0) / 100) + ((crong.get(0) % 100) / 10) + (crong.get(0) % 10);
            l_mul = (crong.get(0) / 100) * ((crong.get(0) % 100) / 10) * (crong.get(0) % 10);
            r_add = (crong.get(1) / 100) + ((crong.get(1) % 100) / 10) + (crong.get(1) % 10);
            r_mul = (crong.get(1) / 100) * ((crong.get(1) % 100) / 10) * (crong.get(1) % 10);
            c_result = Math.max(Math.max(l_add, l_mul), Math.max(r_add, r_mul));

            if (p_result > c_result) {
                answer = 1;
            } else if (p_result < c_result) {
                answer = 2;
            } else if (p_result == c_result) {
                answer = 0;
            } else {
                answer = -1;
            }

            return answer;
        }




}