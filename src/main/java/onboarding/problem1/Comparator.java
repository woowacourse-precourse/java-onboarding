package onboarding.problem1;

public class Comparator {

    // 리팩터링 : 인스턴스 없이 메서드 호출하기
    public static int getWinner(int pobiMax, int crongMax) {
        int result = 0;
        if (pobiMax > crongMax) {
            result = 1;
        } else if (crongMax > pobiMax) {
            result = 2; // 중복 x 지점
        } else if (crongMax == pobiMax) {
            result = 0;
        }

        return result;
    }

    public static int getBigger(int a, int b) {
        int result = 0;
        if (a > b) {
            result = a;
        } else if (b > a) {
            result = b;
        } else if (a == b) {
            result = a;
        }
        return result;
    }
}
