# 1주차_Problem3

## 🚀 기능 요구 사항

배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.

숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- number는 1 이상 10,000 이하인 자연수이다.

### 실행 결과 예시

| number | result |
| --- | --- |
| 13 | 4 |
| 33 | 14 |

딱히 점화식도 없는것 같고 어떤 방법을 써서 369를 구현할 수 있을까 고민하다가 비효율적이지만 1씩 증가시키면서 메모이제이션으로 캐싱하는 방식으로 구현하였다.

```java
public class Problem3 {
    public static int[] memo = new int[10001];
    private static int count369(int number)
    {
        int tmp = number;
        int count = 0;

        while(tmp != 0)
        {
            int remain = tmp % 10;
            if(remain == 3 || remain == 6 || remain == 9) count++;
            tmp /= 10;
        }

        return count;
    }
    public static int solution(int number) {

        if(memo[number] != 0) return memo[number];

        int answer = 0;
        int i = 0;
        while(i <= number)
        {
            answer += count369(i);
            if(memo[answer] == 0) memo[i] = answer;
            i++;
        }

        return answer;
    }
}
```