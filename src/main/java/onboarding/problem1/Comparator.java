package onboarding.problem1;

// 리팩터링 : 클래스 크기 줄이기
public class Comparator {

    // 승자 구하기 기능
    public static int getWinner(int pobiMax, int crongMax) {

        int result = (pobiMax > crongMax) ? 1 : 2;
        if (crongMax == pobiMax) {result = 0;}

        return result;
    }
}
