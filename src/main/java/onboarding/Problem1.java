package onboarding;

import java.util.List;

/*
    포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠다. 
    책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다. 
    책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다. 
    페이지 번호 게임의 규칙은 아래와 같다.

    책을 임의로 펼친다.
    왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
    오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
    2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
    점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
    시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
    포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 
    포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.

    제한사항
    pobi와 crong의 길이는 2이다.
    pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
    실행 결과 예시
    pobi	crong	result
    [97, 98]	[197, 198]	0
    [131, 132]	[211, 212]	1
    [99, 102]	[211, 212]	-1

    [solution]
    1. 덧셈, 곱셈 모두 수행
    2. max 값 구하고 비교
    3. 결과 반환 (1,2,0,-1)

    [edge cases]
    [99,100] -> max: 81 (9 * 9)
    딱히 없는 듯.
 */
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Solver1 solver1 = new Solver1();
        return solver1.solve(pobi, crong);
    }
}

class Solver1 {

    public int solve(List<Integer> pobi, List<Integer> crong) {
        try {
            if (pobi.get(0) + 1 != pobi.get(1))
                throw new IllegalArgumentException("Invalid input from Pobi");

            if (crong.get(0) + 1 != crong.get(1))
                throw new IllegalArgumentException("Invalid input from Crong");
                
            final int pobiSumMax = Math.max(getDigitSum(pobi.get(0)), getDigitSum(pobi.get(1)));
            final int pobiMulMax = Math.max(getDigitMul(pobi.get(0)), getDigitMul(pobi.get(1)));
            final int pobiMax = Math.max(pobiSumMax, pobiMulMax);

            final int crongSumMax = Math.max(getDigitSum(crong.get(0)), getDigitSum(crong.get(1)));
            final int crongMulMax = Math.max(getDigitMul(crong.get(0)), getDigitMul(crong.get(1)));
            final int crongMax = Math.max(crongSumMax, crongMulMax);

            if (pobiMax > crongMax)
                return 1;
            else if (crongMax > pobiMax)
                return 2;
            else
                return 0;
                
        } catch (Exception e) {
            return -1;
        }
    }

    private int getDigitSum(int x) {
        int res = 0;
        while (x > 10) {
            res += x % 10;
            x /= 10;
        }
        return res + x;
    }

    private int getDigitMul(int x) {
        int res = 1;
        while (x > 10) {
            res *= x % 10;
            x /= 10;
        }
        return res * x;
    }
}