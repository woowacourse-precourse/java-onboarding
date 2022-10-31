package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            String numStr = Integer.toString(i);
            int threeCount = getNumberCount(numStr, "3");
            int sixCount = getNumberCount(numStr, "6");
            int nineCount = getNumberCount(numStr, "9");
            answer += (threeCount + sixCount + nineCount);
        }

        return answer;
    }

    public static int getNumberCount(String numStr, String targetNum) {
        return numStr.length() - numStr.replace(targetNum, "").length();
    }
}

/*
<<요구사항>>
1. 1이상 10,000이하의 자연수가 입력으로 들어온다
2. 1부터 그 수까지 하나씩 대면서, 각 숫자마다 3/6/9의 개수만큼 손뼉을 친다
3. 손뼉을 친 총 횟수를 리턴한다
 */

/*
<<기능 목록>>
- [V] 1부터 number까지 순회한다
- [V] 각 순회해서 해당 숫자를 문자열로 바꾼다.
- [V] 바뀐 문자열에서 3, 6, 9를 센다
- [V] 센 횟수를 answer에 더한다
 */
