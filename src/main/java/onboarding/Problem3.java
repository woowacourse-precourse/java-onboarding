package onboarding;

/**
 * 배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.
 * 숫자 number가 매개변수로 주어질 때, 1부터 number 까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 * number 는 1 이상 10,000 이하인 자연수이다.
 */

/**
 * 설계
 * 1부터 n 까지 반복문 돌리면서 3, 6, 9의 개수만큼 카운트
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = count(number);

        return answer;
    }

    public static int count(int number) {
        int count = 0; // 박수 개수를 카운트

        for(int i=1; i<=number; i++) {   // 1부터 n까지 돌면서 3, 6, 9의 수를 파악하기 위해 문자열 변환
            String n = Integer.toString(i);
            for(int j=0; j<n.length(); j++) {
                if(n.charAt(j) == '3' || n.charAt(j) == '6' || n.charAt(j) == '9') // 각 문자열에 3, 6, 9 가 있을 때 count
                    count++;
            }
        }

        return count;
    }
}
