package onboarding;

import java.util.List;

class Main {
    public static void main(String[] args) {

    }
}

/*
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
 */
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 첫 페이지, 마지막 페이지를 펼치는 경우에 대한 예외처리
        if (pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400) {
            try {
                throw new IllegalArgumentException("첫 페이지 혹은 마지막 페이지를 펼치셨습니다.");
            } catch (IllegalArgumentException e) {
                e.getMessage();
                return -1;
            }
        }

        // 왼쪽 페이지와 오른 쪽 페이지의 차이가 한 페이지를 초과해서 나거나 왼쪽 페이지가 오른쪽 페이지보다 큰 경우 예외처리
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            try {
                throw new IllegalArgumentException("왼쪽과 오른쪽 페이지가 잘못 기입되었습니다.");
            } catch (IllegalArgumentException e) {
                e.getMessage();
                return -1;
            }
        }

        int pobiMax = max(pobi.get(0), pobi.get(1));
        int crongMax = max(crong.get(0), crong.get(1));

        int answer = 2;
        if (pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax == crongMax) {
            answer = 0;
        }

        return answer;
    }

    // 각 페이지의 자릿수를 곱하거나 더했을 때의 수를 비교해서 큰 값을 전달하는 메서드
    public static int max(int numLeft, int numRight) {
        int sumPlus = 0;
        int sumMulti = 1;
        int max = 0;
        int sumPlusR = 0;
        int sumMultiR = 1;
        int maxR = 0;

        while (numLeft != 0) {
            sumPlus += numLeft % 10;
            sumMulti *= numLeft % 10;
            numLeft /= 10;
        }
        max = Math.max(sumPlus, sumMulti);
        while (numRight != 0) {
            sumPlusR += numRight % 10;
            sumMultiR *= numRight % 10;
            numRight /= 10;
        }
        maxR = Math.max(sumPlusR, sumMultiR);
        max = Math.max(max, maxR);
        return max;
    }
}