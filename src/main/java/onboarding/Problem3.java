package onboarding;

import java.util.ArrayList;
import java.util.List;


public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        // 삼육구
        answer = samYugGu(number);

        return answer;
    }

    private static int samYugGu(int number) {

        List<Integer> list = getList(number);

        int answer = 0;

        // 자릿 수가 변경될 때마다 합 변경
        int pre = 0;
        int digit = 1;

        for (int i = 0; i < list.size(); i++) {
            Integer now = list.get(i);

            // 초기 세팅 (1의 자리)
            if (i == 0) {
                answer += now/3;
                pre = 3;
            }else {
                // 해당 자릿수 만큼 반복하면서 총합값 계산
                for (int j = 1; j <= now; j++) {
                    // 해당 자릿수에서 가장 큰 수 이면서 3,6,9 규칙에 해당될 때
                    if(j == now && j % 3 == 0){
                        answer++;
                        answer += pre;
                        // 아래 자릿 수만큼 손뼉을 쳐야하기 때문에 계산해줌
                        answer += getLowerNums(list, i);
                    } else if (j % 3 == 0) {    // 3,6,9 규칙에 해당될 때 ( 현재 자릿수 단위 + 아랫자리수 총합 )
                        answer += (digit + pre);
                    }else{
                        answer += pre;
                    }
                }
                // 아래 자릿수 총합 업데이트
                pre += setPre(pre, digit);
            }
            // 단위 갱신
            digit *= 10;
        }
        return answer;
    }

    private static int setPre(int pre , int digit) {
        // 아래 자릿수 총합 계산
        return (3 * (digit + pre)) + (6 * pre);
    }

    private static int getLowerNums(List<Integer> list , int num) {

        int answer = 0;
        int tempDigit = 1;
        // 아래 자리수 구하기 (리스트 역순)
        for (int i = 0; i < num; i++) {
            answer += ( list.get(i) * tempDigit);
            tempDigit *= 10;
        }
        return answer;
    }

    private static List<Integer> getList(int number) {

        List<Integer> list = new ArrayList<>();
        // 모듈러 연산을 통한 리스트 구하기
        while (number > 0) {
            list.add(number % 10);
            number /= 10;
        }
        return list;
    }

    public static void main(String[] args) {
        int number = 3633;
        solution(number);
    }


}
