package onboarding;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * <p>포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠다.
 * 책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다.
 * 책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다.
 * 페이지 번호 게임의 규칙은 아래와 같다.</p>
 * <br/>
 * 1. 책을 임의로 펼친다.<p>
 * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.<p>
 * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.<p>
 * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.<p>
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.<p>
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.<p>
 */
class Problem1 {

    /**
     * 페이지 번호의 각 자리 숫자를 모두 더하는 메소드
     */
    public static int getSum(Integer page) {
        List<Integer> pageToList = asList(page / 100, page % 100 / 10, page % 100 % 10);
        int sum = 0;
        for (int num : pageToList) {
            sum += num;
        }
        return sum;
    }


    /**
     * 페이지 번호의 각 자리 숫자를 모두 곱하는 메소드
     */
    public static int getMultiple(Integer page) {
        List<Integer> pageToList = asList(page / 100, page % 100 / 10, page % 100 % 10);
        int mult = 0;
        if (page.toString().length() == 1) {
            mult = pageToList.get(2);
        } else if (page.toString().length() == 2) {
            mult = pageToList.get(1) * pageToList.get(2);
        } else if (page.toString().length() == 3) {
            mult = pageToList.get(0) * pageToList.get(1) * pageToList.get(2);
        }
        return mult;
    }


    /**
     * 두 숫자 중, 더 큰 것을 반환하는 메소드
     */
    public static int getLargerOne(int leftScore, int rightScore) {
        return Math.max(leftScore, rightScore);
    }


    /**
     * 두 플레이어의 최종 점수를 입력받아, 결과를 반환하는 메소드
     */
    public static int getAnswer(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else return 0;
    }

    /**
     * main() 메소드
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        System.out.println("pobi 가 펼친 왼쪽 페이지: " + pobi.get(0) + ", pobi 가 펼친 오른쪽 페이지: " + pobi.get(1));
        System.out.println("crong 이 펼친 왼쪽 페이지: " + crong.get(0) + ", crong 이 펼친 오른쪽 페이지: " + crong.get(1));

        // 예외사항을 빠르게 검증
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        // 책을 정상적으로 펼쳤다고 가정할 때, 포비의 점수 얻기
        int pobiLeftSum = getSum(pobi.get(0));
        int pobiLeftMult = getMultiple(pobi.get(0));
        int pobiRightSum = getSum(pobi.get(1));
        int pobiRightMult = getMultiple(pobi.get(1));
        int pobiScore = getLargerOne(getLargerOne(pobiLeftMult, pobiLeftSum), getLargerOne(pobiRightMult, pobiRightSum));

        // 책을 정상적으로 펼쳤다고 가정할 때, 크롱의 점수 얻기
        int crongLeftSum = getSum(crong.get(0));
        int crongLeftMult = getMultiple(crong.get(0));
        int crongRightSum = getSum(crong.get(1));
        int crongRightMult = getMultiple(crong.get(1));
        int crongScore = getLargerOne(getLargerOne(crongLeftMult, crongLeftSum), getLargerOne(crongRightMult, crongRightSum));

        return getAnswer(pobiScore, crongScore);
    }
}