/*
 * 1, 각 돈에 대한 배열을 만든다.
 *  5만원 | 1만원군 | 오천원권 | 천원권 | 오백원| 백원 | 오십원 | 십원 | 일원
 *  9개
 * 2, 가장 큰값에 대한 값부터 뺀 후 카운팅한다.
 * 3, 출력한다.
 */
package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    public static void main(String[] args){
        int answer = 15000;
        List<Integer> list = new ArrayList<>();
        int[] money = {50000,10000,5000,1000,500,100,50,10,1};
        int[] result = new int[10];

        for(int i = 0; i <= money.length;i++){
            int count = 0; // 지속적으로 0으로 초기화
            if(0 < answer){
                count = answer / money[i]; // 최대 몇번 나눌 수 있는지
                result[i] += count; // 나눈 값을 해당 인덱스에 저장
                answer = answer % money[i]; // 나눈 값의 나머지 값
            }
        }
        for(int j = 0; j < money.length;j++){
            System.out.print(result[j]);
            System.out.print(',');
        }
    }
}
