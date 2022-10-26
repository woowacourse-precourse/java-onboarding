package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isErrorList(pobi) || isErrorList(crong))
            return -1;
        int pobiScore = getMaxInList(pobi);
        int crongScore = getMaxInList(crong);
        if (pobiScore == crongScore)
            return 0;
        return (pobiScore > crongScore) ? 1 : 2;
    }

    public static int getMaxInList(List<Integer> list) {
        int leftPage = Math.max(addEachNumber(list.get(0)), multiplyEachNumber(list.get(0)));
        int rightPage = Math.max(addEachNumber(list.get(1)), multiplyEachNumber(list.get(1)));
        return Math.max(leftPage, rightPage);
    }

    public static int addEachNumber(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static int multiplyEachNumber(int number) {
        int multiple = 1;
        while (number != 0) {
            multiple *= number % 10;
            number /= 10;
        }
        return multiple;
    }

    public static boolean isErrorList(List<Integer> list) {
        if (list.size() != 2
                || list.get(0) == null || list.get(0) <= 1 || list.get(0) >= 400 || list.get(0) % 2 == 0
                || list.get(1) == null || list.get(1) <= 1 || list.get(1) >= 400 || list.get(1) % 2 == 1)
            return true;
        return list.get(1) - list.get(0) != 1;
    }
}
/*
문제 설명
  1. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구함
  2. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구함
  3. 1번과 2번 중 가장 큰 수를 본인의 점수로 함
  4. 점수를 비교해서 높은 사람이 게임의 승자가 됨
  5. 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부 0, 예외사항 -1 리턴

제한사항 및 주의할점
  - pobi와 crong의 길이는 2
  - pobi와 crong에는 [왼쪽페이지번호, 오른쪽페이지번호]가 순서대로 들어있음
  - 페이지 번호는 1이상 400이하
  - 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
  - 연속되는 페이지 번호만 존재함
  - 시작 면이나 마지막 면이 나오도록 책을 펼치지 않음

예외 체크할 점 (순서대로, 아래 사항이 맞다면 예외 발생)
  - list가 비었는가?
  - list의 사이즈가 2가 아닌가?
  - list 안의 Integer는 null인가?
  - list 안의 Integer는 1보다 같거나 작고, 400보다 같거나 큰가? (시작면, 마지막면 예외처리)
  - list 안의 왼쪽 페이지는 짝수인가?
  - list 안의 오른쪽 페이지는 홀수인가?
  - list.get(1) - list.get(0) == 1 이 아닌가?
 */