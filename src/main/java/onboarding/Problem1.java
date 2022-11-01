package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 1, 6. 임의로 펼친 책 Page 범위가 올바른지 체크한다. (2~399)
        if (pobi.get(0) <= 1) return -1;
        if (crong.get(0) <= 1) return -1;
        if (pobi.get(1) >= 400) return -1;
        if (crong.get(1) >= 400) return -1;

        // 정상적인 페이지가 맞는지 확인한다. (찢어지지 않았는지 확인)
        if (pobi.get(1) - pobi.get(0) != 1) return -1;
        if (crong.get(1) - crong.get(0) != 1) return -1;


        // 2~4. 각자 펼쳐본 왼쪽 페이지, 오른쪽 페이지 번호에서 각 자리 숫자를 더하거나 곱해 가장 큰 수를 구한다.
        int pobiMaxNumber = calcMaxPageNumber(pobi);
        int crongMaxNumber = calcMaxPageNumber(crong);

        // 5. 점수를 비교하여 가장 높은 사람이 게임의 승자가된다.
        // pobi 승리시 1
        if (pobiMaxNumber > crongMaxNumber)
            answer = 1;
        // crong 승리시 2
        if (pobiMaxNumber < crongMaxNumber)
            answer = 2;
        // 무승부시 0
        if (pobiMaxNumber == crongMaxNumber)
            answer = 0;

        return answer;
    }

    public static int calcMaxPageNumber(List<Integer> pages){
        int maxNum = 0;
        int tmpMaxNum = 0;
        int addResult = 0;
        int mulResult = 1;
        // 자릿수를 담는 리스트 pageNums 선언하기.
        ArrayList<Integer> pageNums = new ArrayList<>();

        // 2, 3. 왼쪽 페이지 ( i = 0 ), 오른쪽 페이지( i = 1 )의 자릿수를 더하거나 곱한 최대값을 뽑는다.
        for ( int i = 0; i <= 1; i++ ){
            // 초기화
            pageNums.clear();
            addResult = 0;
            // 곱하기 할 때 0인 경우를 고려.
            mulResult = 1;

            // 페이지 선언
            int page = pages.get(i);
            // 긱 자릿수 별로 저장한다.
            // page의 자릿수가 있는 경우까지 pageNum에 자릿수를 원소에 집어 넣는다.
            while(page != 0){
                int tmp = page % 10;
                pageNums.add(tmp);
                page /= 10;
            }
            // 각 자릿수별로 더하거나 곱한 결과 저장한다.
            for (Integer pageNum : pageNums) {
                addResult += pageNum;
                mulResult *= pageNum;
            }

            /* 덧셈 결과와 곱셈 결과 비교해서 가장 큰 수를 tmp_max_num에 저장한다. */
            if (mulResult >= addResult)
                tmpMaxNum = mulResult;
            if (addResult > mulResult)
                tmpMaxNum = addResult;


            // 만약 계산한 최댓값이 이전 최댓값보다 큰 경우 최댓값 변경하기.
            if (tmpMaxNum > maxNum)
                maxNum = tmpMaxNum;
        }

        return maxNum;
    }
}
