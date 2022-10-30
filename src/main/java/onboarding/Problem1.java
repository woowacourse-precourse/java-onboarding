package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public enum Book {
        left(0),
        right(1),
        first(1),
        last(400);

        private final int page;

        Book(int page) {
            this.page = page;
        }
        public int getNum() {
            return page;
        }
    }
    public enum Game {
        tie(0),
        pobiWin(1),
        crongWin(2),
        errror(-1);

        private final int result;

        Game(int result) {
            this.result = result;
        }
        public int getResult() {
            return result;
        }
    }

    static final int listLength = 2;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Game.errror.result;

        exceptionHandling(pobi);
        exceptionHandling(crong);

        if (checkedException(pobi.get(Book.left.page), pobi.get(Book.right.page)) &&
                checkedException(crong.get(Book.left.page), crong.get(Book.right.page))) {
            int pobiScore = Math.max(findScore(pobi.get(Book.left.page)), findScore(pobi.get(Book.right.page)));
            int crongScore = Math.max(findScore(crong.get(Book.left.page)), findScore(crong.get(Book.right.page)));
            answer = compareScore(pobiScore, crongScore);
        }

        return answer;
    }

    public static int calculation(List<Integer> num_list, char type) {
        int result = 0;

        //곱셈일 경우 초기화
        if (type == '*')
            result = 1;

        for (int i = 0; i < num_list.size(); i++) {
            if (type == '+')
                result += num_list.get(i);
            if (type == '*')
                result *= num_list.get(i);
        }

        return result;
    }
    //점수 비교해 결과 반환
    public static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore == crongScore)
            return Game.tie.result;
        if (pobiScore > crongScore)
            return Game.pobiWin.result;
        if (pobiScore < crongScore)
            return Game.crongWin.result;

        return Game.errror.result;
    }
    //자리수를 알아내 리스트에 저장
    public static List<Integer> findPlaceValue(int num) {
        List<Integer> num_list = new ArrayList<>();

        while(num > 0) {
            num_list.add(num % 10);
            num /= 10;
        }

        return num_list;
    }
    public static int findScore(int number) {
        int sumResult = calculation(findPlaceValue(number), '+');
        int multiplicationResult = calculation(findPlaceValue(number), '*');

        return Math.max(sumResult,  multiplicationResult);
    }

    /*
    * 예외 처리
    */
    public static boolean checkedException(int leftPage, int rightPage) {

        if (!(leftPage >= Book.first.page && leftPage <= Book.last.page))
            return false;
        if (!(rightPage >= Book.first.page && rightPage <= Book.last.page))
            return false;
        if ((leftPage % 2) == 0)
            return false;
        if ((leftPage + 1) != rightPage)
            return false;
        return true;
    }
    public static void exceptionHandling(List<Integer> list) {
        String errorMessage = "LIST SIZE ERROR";

        if (list.size() != 2)
            throw new IllegalArgumentException(errorMessage);
    }
}
