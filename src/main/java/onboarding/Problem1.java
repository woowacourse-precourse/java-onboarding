package onboarding;

import java.util.List;

class Problem1 {

    // 2~4 과정을 진행해 최대 점수를 결정
    public static int compare(List<Integer> li, int max){
        // 왼쪽 페이지 번호와 오른쪽 페이지 번호에 대해 다음 내용 실행
        for (int i = 0; i < li.size(); i++){
            int add = 0, mult = 1, temp = 0, num = li.get(i);
            // 각 자리 숫자를 모두 더한 수와 모두 곱한 수를 구함
            while (num != 0){
                temp = num % 10;
                add += temp;
                mult *= temp;
                num /= 10;
            }
            // 구한 두 수 중 더 큰 값과 최대 점수를 비교
            if ((add >= mult) && (add >= max)){
                max = add;
            }
            else if ((mult > add) && (mult >= max)){
                max = mult;
            }
        }
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 예외 : 각 리스트가 연속된 숫자가 아니거나, 시작 면 또는 마지막 면을 펼친 경우
        if ((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1)) ||
        (pobi.get(0) <= 1) || (pobi.get(1) >= 400) || (crong.get(0) <= 1) || (crong.get(1) >= 400)){
            return -1;
        }

        int pobi_max = 0, crong_max = 0;
        pobi_max = compare(pobi, pobi_max);
        crong_max = compare(crong, crong_max);
        
        // 누가 이기느냐에 따라 결과값 결정
        if (pobi_max > crong_max)
            answer = 1;
        else if (crong_max > pobi_max)
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}