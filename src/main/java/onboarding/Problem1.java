package onboarding;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 포비와 크롱의 리스트에 들어있는 값을 넣을 배열
        int[] pobiPage = new int[2];
        int[] crongPage = new int[2];
        // 포비와 크롱의 페이지 연산 결과를 넣을 배열
        int[] pobiResult = new int[4];
        int[] crongResult = new int[4];
        // 포비와 크롱이 구한 최댓값
        int pobiNum;
        int crongNum;

        // 포비와 크롱의 리스트에 들어있는 값을 배열에 넣음
        Iterator<Integer> pobiItr = pobi.iterator();
        Iterator<Integer> crongItr = crong.iterator();

        for(int i=0; i<pobiPage.length; i++){
            pobiPage[i] = pobiItr.next();
            crongPage[i] = crongItr.next();
        }

        // 예외 처리
        boolean isException = isException(pobiPage, crongPage);
        if(isException) {
            answer = -1;
            return answer;
        }

        // 포비의 계산결과 넣음
        pobiResult = calculateResult(pobiPage);
        // 크롱의 계산결과 넣음
        crongResult = calculateResult(crongPage);

        // 포비의 계산결과와 크롱의 계산결과를 오름차순으로 정렬함
        Arrays.sort(pobiResult);
        Arrays.sort(crongResult);

        // 누가 이겼는지 확인
        pobiNum = pobiResult[3];
        crongNum = crongResult[3];
        if(pobiNum > crongNum){
            answer = 1;
        } else if(crongNum > pobiNum){
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    /**
     * 예외 상황인지 판단하는 메소드
     * @param pobiPage 포비가 뽑은 페이지
     * @param crongPage 크롱이 뽑은 페이지
     * @return 예외 상황이면 true 반환 예외 상황이 아니면 false 반환
     */
    static boolean isException(int[] pobiPage, int[] crongPage){
        // 페이지의 값이 1 차이가 나는지 확인
        if(pobiPage[0] != pobiPage[1] - 1 || crongPage[0] != crongPage[1] - 1){
            return true;
        }

        // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지 확인
        if(pobiPage[0] % 2 != 1 || pobiPage[1] % 2 != 0 || crongPage[0] % 2 != 1 || crongPage[1] % 2 != 0){
            return true;
        }

        // 페이지가 1~400인지 확인
        for(int i=0; i<pobiPage.length; i++){
            if(pobiPage[i] > 400 || crongPage[i] > 400 || pobiPage[i] < 1 || crongPage[i] < 1){
                return true;
            }
        }

        return false;
    }

    /**
     * 왼쪽과 오른쪽의 페이지 번호의 각 자리를 이용한 연산 결과를 구하는 메소드
     * @param page
     * @return
     */
    static int[] calculateResult(int[] page){
        int[] result = new int[4];

        // 왼쪽 페이지의 각 자리의 숫자를 모두 더함
        result[0] = sum(page[0]);
        // 왼쪽 페이지의 각 자리의 숫자를 모두 곱함
        result[1] = multiple(page[0]);
        // 오른쪽 페이지의 각 자리의 숫자를 모두 더함
        result[2] = sum(page[1]);
        // 오른쪽 페이지의 각 자리의 숫자를 모두 곱함
        result[3] = sum(page[1]);

        return result;
    }

    /**
     * 각 자리의 숫자를 모두 더하는 메소드
     * @param number
     * @return
     */
    static int sum(int number){
        int result = 0;

        while(number > 0){
            result += number % 10;
            number /= 10;
        }

        return result;
    }

    /**
     * 각 자리의 숫자를 모두 곱하는 메소드
     * @param number
     * @return
     */
    static int multiple(int number){
        int result = 1;

        while (number > 0){
            result *= number % 10;
            number /= 10;
        }

        return result;
    }

}