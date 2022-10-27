package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    /*
        1. 각각 리스트의 자리 수를 구한다
            10씩 나누어 나머지를 구하거나
            문자열로 쪼갠 후 구하거나 등등....

        2. 싹다 곱하거나 싹다 더해서 그 중에 Max값을 구한다.

        3. 포비와 크롱의 Max 값을 구해서 비교한다
            3-1. 포비 > 크롱 : 1
            3-2. 포비 < 크롱 : 2
            3-3. 포비 == 크롱 : 0
            3-4. 예외 사항 : -1
                예외사항 예시 :
                    a. 왼쪽이 짝수 || 오른쪽이 홀수
                    b. 왼쪽 + 1 != 오른쪽인 경우
                    c. 가장 마지막 면 혹은 시작면이 나오는 경우(리스트 크기가 1이하인 경우)
                    d. 페이지를 잘라먹는 꼼수 등등....
        * */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        int answer = Integer.MAX_VALUE;
//        return answer;
        if(!pageValidation(pobi) || !pageValidation(crong)){
            return -1;
        }

        int pobiMax = comparePages(pobi);
        int crongMax = comparePages(crong);

        if(pobiMax > crongMax) return 1;
        else if (pobiMax < crongMax) return 2;
        else return 0;

    }

    static int comparePages(List<Integer> player) {
        int max = 0;
        for (Integer page : player) {
            int tmp = max(page);

            if(max < tmp) max = tmp;
        }
        return max;
    }
    static int max(int page) {
        List<Integer> pageDigit = new ArrayList<>();
        while(page > 0) {
            int num = page % 10;
            pageDigit.add(num);

            page /= 10;
        }
        int sum = 0; int multi = 1;
        for (Integer integer : pageDigit) {
            sum += integer;
            multi *= integer;
        }
        return Math.max(sum, multi);
    }

    static boolean pageValidation(List<Integer> player) {
        for (Integer i : player) if (i < 1 || i > 400) {
            return false;
        }
        if(player.size() != 2) return false;

        if (player.get(0) % 2 != 1 || player.get(1) % 2 !=0) {
            return false;
        }
        return player.get(1) - player.get(0) == 1;
    }

}