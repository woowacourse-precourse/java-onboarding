package onboarding;

import java.util.List;

/*
1. 페이지가 잘못된 경우(홀,짝 순서가 아님/ 1이상 차이남) -1 return
2. 잘 된 경우
    a. 포비의 경우
        가. 1의 자리부터 한 자리씩 올려가며 모든 자리를 곱하거나, 더함
        나. 이전 최대, 모든 자리 곱한 값, 모든 자리 더한 값 중 최대값을 포비의 최대값에 저장
        다. 왼쪽, 오른쪽 두 번 반복, 두번 중 최대값이 포비의 최대값에 저장됨
    b. 크롱의 경우
        가. a 반복
    c. 포비와 크롱의 최대값 중 포비가 크면 1, 크롱이 크면 2 return
*/
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0) + 1 != pobi.get(1) ||
                crong.get(0) + 1 != crong.get(1) ||
                pobi.get(0) % 2 != 1 ||
                crong.get(0) % 2 != 1)
            answer = -1;
        else {
            int pobiMax = 0;
            int crongMax = 0;
            for (int i = 0; i < 2; i++) {
                int pobiPlus = 0;
                int pobiMulti = 1;
                int pobiPage = pobi.get(i);
                while (pobiPage != 0) {
                    pobiPlus += pobiPage % 10;
                    pobiMulti *= pobiPage % 10;
                    pobiPage /= 10;
                }
                pobiMax = Math.max(pobiMax, Math.max(pobiPlus, pobiMulti));

                int crongPlus = 0;
                int crongMulti = 1;
                int crongPage = crong.get(i);
                while (crongPage != 0) {
                    crongPlus += crongPage % 10;
                    crongMulti *= crongPage % 10;
                    crongPage /= 10;
                }
                crongMax = Math.max(crongMax, Math.max(crongPlus, crongMulti));
            }
        }

        return answer;
    }
}