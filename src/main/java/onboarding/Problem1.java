package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        int[] pobiMax = new int[2];      // 포비의 왼쪽, 오른쪽 페이지 max값
        int[] crongMax = new int[2];     // 크롱의 왼쪽, 오른쪽 페이지 max값


        if(isError(pobi) || isError(crong))
            answer=-1;

        else{
            for (int i = 0; i < 2; i++) {
                int n = pobi.get(i);
                int m = crong.get(i);

                pobiMax[i] = sumOrMulti(n, 0, 1);
                crongMax[i] = sumOrMulti(m, 0, 1);

            }

            for (int i = 0; i < 2; i++) {
                System.out.println("pobiMax[" + i + "] : " + pobiMax[i]);
                System.out.println("crongMax[" + i + "] : " + crongMax[i]);

                if (pobiMax[i] > crongMax[i])
                    answer = 1;
                else if (pobiMax[i] < crongMax[i])
                    answer = 2;
                else
                    answer = 0;

            }
        }

        System.out.println("answer는 " + answer + "입니다!");

        return answer;
    }

    // 각 자릿수의 합과 곱을 계산해서 max를 리턴하는 함수
    static int sumOrMulti(int n, int sum, int multi){
        int max;
        while (n > 0) {
            sum += (n % 10);
            multi *= (n % 10);

            n = n / 10;
        }

        if (sum > multi)
            max = sum;
        else
            max = multi;

        return max;
    }

    static boolean isError(List<Integer> list) {
        // 페이지 수가 잘못된 경우
        if (Math.abs(list.get(0) - list.get(1)) != 1)
            return true;

        // 시작 면 or 마지막 면이 나오는 경우
        else if(list.get(0) == null || list.get(1) == null)
            return true;
        return false;
    }
}