package onboarding;

import java.util.List;

class Problem1 {
    /**
     [기능목록]
     1. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 모두 곱하기
     2. 왼쪽 페이지를 모두 더한 값과 모두 곱한 값 중에서 가장 큰 수 구하여 자신의 점수로 사용하기
     3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 모두 곱하기
     4. 오른쪽 페이지를 모두 더한 값과 모두 곱한 값 중에서 가장 큰 수 구하여 자신의 점수로 사용하기
     5. 점수를 비교해 게임의 승자 정하기
     6. 예외사항 처리하기
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiTop = 0;
        int crongTop = 0;

        // 예외사항 처리하기
        if((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1))) {
            answer = -1;
            return answer;
        }

        for(int i = 0; i< pobi.size(); i++) {
            // 예외사항 처리하기
            if(pobi.get(i) <= 1 || pobi.get(i) >= 400 || crong.get(i) <= 1 || crong.get(i) >= 400) {
                answer = -1;
                return answer;
            }

            // 포비 왼쪽, 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 모두 곱하기
            char[] pobiChar = pobi.get(i).toString().toCharArray();
            int pobisum = 0;
            int pobimul = 1;
            for(char c : pobiChar) {
                pobisum += c - '0';
                pobimul *= c - '0';
            }
            // 모두 더한 값과 모두 곱한 값 중에서 가장 큰 수를 구하여 포비의 점수로 사용하기
            pobiTop = Math.max(Math.max(pobisum, pobimul), pobiTop);

            // 크롱 왼쪽, 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 모두 곱하기
            char[] crongChar = crong.get(i).toString().toCharArray();
            int crongsum = 0;
            int crongmul = 1;
            for(char c : crongChar) {
                crongsum += c - '0';
                crongmul *= c - '0';
            }
            // 모두 더한 값과 모두 곱한 값 중에서 가장 큰 수를 구하여 크롱의 점수로 사용하기
            crongTop = Math.max(Math.max(crongsum, crongmul), crongTop);
        }

        // 점수를 비교해 게임의 승자 정하기
        if(pobiTop > crongTop) {
            answer = 1;
        } else if(pobiTop < crongTop) {
            answer = 2;
        } else if(pobiTop == crongTop) {
            answer = 0;
        }

        return answer;
    }
}