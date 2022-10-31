package onboarding;

import java.util.LinkedList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int pobiMax = Integer.MIN_VALUE;
        int crongMax = Integer.MIN_VALUE;

        /* 오른쪽 페이지와 왼쪽 페이지의 차이가 1이 아닐 경우 예외처리 */
        if((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)){
            return -1;
        }

        LinkedList<Integer> pobiPage = new LinkedList<>();
        LinkedList<Integer> crongPage = new LinkedList<>();

        /*
          페이지를 넣어준다
          왼쪽 페이지가 두자리일 경우 index 참조에 문제가 생길 수 있으므로
          i가 0일 경우 Page에 addFirst로 넣어준다
         */
        for(int i=0; i<2; i++) {
            int tmp = pobi.get(i);
            while (tmp > 0) {
                if(i == 0)
                    pobiPage.addFirst(tmp % 10);
                else
                    pobiPage.addLast(tmp % 10);
                tmp /= 10;
            }
            tmp = crong.get(i);
            while (tmp > 0) {
                if(i == 0)
                    crongPage.addFirst(tmp % 10);
                else
                    crongPage.addLast(tmp % 10);
                tmp /= 10;
            }
        }

        int tmp;
        for(int i=0; i<2; i++){
            int n = pobiPage.size();
            tmp = 1;
            for(int j=0; j<n/2; j++){
                if(i == 0)
                    tmp += pobiPage.get(j);
                else
                    tmp *= pobiPage.get(j);
            }
            pobiMax = Math.max(pobiMax, tmp);
            tmp = 1;
            for(int k=n/2; k<n; k++){
                if(i == 0)
                    tmp += pobiPage.get(k);
                else
                    tmp *= pobiPage.get(k);
            }
            pobiMax = Math.max(pobiMax, tmp);
        }

        for(int i=0; i<2; i++){
            int n = crongPage.size();
            tmp = 1;
            for(int j=0; j<n/2; j++){
                if(i == 0)
                    tmp += crongPage.get(j);
                else
                    tmp *= crongPage.get(j);
            }
            crongMax = Math.max(crongMax, tmp);
            tmp = 1;
            for(int k=n/2; k<n; k++){
                if(i == 0)
                    tmp += crongPage.get(k);
                else
                    tmp *= crongPage.get(k);
            }
            crongMax = Math.max(crongMax, tmp);
        }

        if(pobiMax > crongMax)
            answer = 1;
        else if(pobiMax < crongMax)
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}