package onboarding;

import java.util.List;

//        책을 임의로 펼친다.
//        왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//        오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//        2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
//        점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
//        시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
//        포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때,
//        포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();
        int answer = Integer.MAX_VALUE;

        // 페이지수 확인
        if (!problem1.isOK(pobi)) return -1;
        if (!problem1.isOK(crong)) return -1;

        int pobiNum = problem1.scoreCalculator(pobi);
        int crongNum = problem1.scoreCalculator(crong);

        if (pobiNum > crongNum) answer = 1;
        if (pobiNum == crongNum) answer = 0;
        if (pobiNum < crongNum) answer = 2;

        return answer;
    }

    // 페이지 수가 올바르지 않으면 오류
    public boolean isOK(List<Integer> numbers) {
        if (numbers.get(0) + 1 != numbers.get(1)) {
            return false;
        }
        return true;

    }

    // 점수 계산 메서드
    public int scoreCalculator(List<Integer> numbers) {
        String numbersStr1 = numbers.get(0) + "";
        String numbersStr2 = numbers.get(1) + "";

        int numbersPlus1 = 0;
        int numbersMul1 = 1;
        int numbersPlus2 = 0;
        int numbersMul2 = 1;
        int numbersNum1 = 0;
        int numbersNum2 = 0;

        for (int i = 0; i < numbersStr1.length(); i++) {
            numbersPlus1 += Integer.parseInt(numbersStr1.charAt(i) + "");
            numbersMul1 *= Integer.parseInt(numbersStr1.charAt(i) + "");
        }
        numbersNum1 = numbersPlus1 >= numbersMul1 ? numbersPlus1 : numbersMul1;
        for (int i = 0; i < numbersStr2.length(); i++) {
            numbersPlus2 += Integer.parseInt(numbersStr2.charAt(i) + "");
            numbersMul2 *= Integer.parseInt(numbersStr2.charAt(i) + "");
        }
        numbersNum2 = numbersPlus2 >= numbersMul2 ? numbersPlus2 : numbersMul2;
        numbersNum1 = numbersNum1 >= numbersNum2 ? numbersNum1 : numbersNum2;

        return numbersNum1;
    }
}