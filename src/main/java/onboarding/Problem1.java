package onboarding;


import java.util.List;


class Problem1 {




    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        int pobiMax = maxNum(pobi);
        int crongMax = maxNum(crong);

        //예외 상황시 -1리턴
        if (pobiMax == 0 || crongMax == 0){
            return -1;
        }

        //maxNum로 구한 값들을 비교하고 상황에 맞는 값을 리턴
        if (pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        } else if (pobiMax == crongMax) {
            answer = 0;
        }


        return answer;
    }


    //pobi, crong 각각의 큰수를 구하는 메서드
    public static int maxNum(List<Integer> li) {
        int maxP = 0;

        int p1 = li.get(0);
        int p2 = li.get(1);

        //예외 사항 처리
        if (p2-p1 != 1) {
            return 0;
        }


        for (int p : li) {
            //예외 사항 처리
            if (p == 0 || p == 401) {
                return 0;
            }

            String page = Integer.toString(p);
            int a_tmpp = 0;
            int m_tmpp = 1;

            int max_tmp = 0;

            for (int i = 0; i < page.length(); i++) {

                int n = page.charAt(i) - '0';

                a_tmpp += n;
                m_tmpp *= n;
            }


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


}