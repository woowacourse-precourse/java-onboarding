/**
 * 기능 요구사항 :
 * 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 * number는 1 이상 10,000 이하인 자연수이다.
 * <p>
 * 구현 기능 :
 * 1. 주어진 숫자에서 3 / 6 / 9 몇개 들어있는지 받는 메서드 get369Num()
 * 2. get369Num() solution() 에서 1부터 number까지 호출하고 그 값을 return
 */

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0; // 3 / 6 / 9의 총 개수 저장

        for (int i = 1; i <= number; i++) {
            answer += get369Num(i);
        }

        return answer;
    }

    /**
     * 인자로 주어진 number에서 3 / 6 / 9가 몇 개 포함되어 있는지를 return한다.
     * @param number
     * @return
     */
    public static int get369Num(int number) {
        int count = 0; // 3 / 6 / 9의 개수 counter

        while (number > 0) {
            /* 끝자리가 3이거나 6이거나 9이면 박수 한번 추가 */
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                count += 1;
            }

            number /= 10;
        }

        return count;
    }
}
