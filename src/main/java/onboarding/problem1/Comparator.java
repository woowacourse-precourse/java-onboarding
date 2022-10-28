package onboarding.problem1;

// 리팩터링 : 클래스 크기 줄이기
public class Comparator {

    // 리팩터링 : else 키워드 제거
    public static int getWinner(int pobiMax, int crongMax) {

        int result = (pobiMax > crongMax) ? 1 : 2;
        if (crongMax == pobiMax) {result = 0;}

        return result;
    }

    public static int getBigger(int a, int b) {

        int result = (a > b) ? a : b;
        if (a==b){result = a;}

        return result;

    }
}
