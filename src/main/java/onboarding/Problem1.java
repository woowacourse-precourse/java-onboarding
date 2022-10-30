/*
포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠다. 책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다. 책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다. 페이지 번호 게임의 규칙은 아래와 같다.

1. 책을 임의로 펼친다.
2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.

포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.

### 제한사항

- pobi와 crong의 길이는 2이다.
- pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.

### 실행 결과 예시

| pobi | crong | result |
| --- | --- | --- |
| [97, 98] | [197, 198] | 0 |
| [131, 132] | [211, 212] | 1 |
| [99, 102] | [211, 212] | -1 |


$ 예외처리
 1, int의 범위는 1 ~ 400
 2, 페이지는 랜덤으로 펼친다.
 3, 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
  - 왼쪽 페이지 번호, 오른쪽 페이지 번호가 순차적으로 들어오는지 확인 해야한다.
 4, pobi와 crong의 길이가 2이다 -> 2보다 많은 길이가 들어오는 것을 방지

 $ 구현
 1, 순서대로 구현한다....
 2. 왼쪽, 오른쪽 각 자리를 더하거나 , 곱해서 , 더큰수를 담는다.
 */
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // int PobiMax = maxScore(pobi);
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    
    public int addtion(int pageNumber){
        int additionSum = 0;
        while(0 < pageNumber){
            additionSum += pageNumber % 10;
            pageNumber /= 10;
        }
        return additionSum;
    }
    public static int Multiplicaion(int pageNumber){
        int MultiplicaionSum = 1;

        while(0 < pageNumber){
            MultiplicaionSum *= pageNumber % 10;
            pageNumber /= 10;
        }
        return MultiplicaionSum;
    }
    public static void main(String[] args){
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
    }
}