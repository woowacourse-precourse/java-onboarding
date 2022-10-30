package onboarding;

import java.util.ArrayList;
import java.util.List;

class User {
    private int left;
    private int right;
    private int score;
    private int length;

    public User(){

    }
    public User(int left, int right, int length) {
        this.left = left;
        this.right = right;
        this.length = length;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setLeft(int left) {
        this.left = left;
    }
    public void setRight(int right) {
        this.right = right;
    }
    public int getLeft() {
        return left;
    }
    public int getRight() {
        return right;
    }
    public int getScore() {
        return score;
    }
    public int getLength() {
        return length;
    }
}

class Problem1 {
    public enum Book {
        left(0),
        right(1),
        first(1),
        last(400),
        length (2);

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


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Game.errror.result;

        User pobi_user = new User(pobi.get(Book.left.page), pobi.get(Book.right.page), pobi.size());
        User crong_user = new User(crong.get(Book.left.page), crong.get(Book.right.page), crong.size());


        if (checkedException(pobi_user, crong_user)) {
            getScore(pobi_user);
            getScore(crong_user);
            answer = compareScore(pobi_user.getScore(), crong_user.getScore());
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
        int sum = calculation(findPlaceValue(number), '+');
        int multiplication = calculation(findPlaceValue(number), '*');

        return Math.max(sum,  multiplication);
    }
    public static void getScore(User user) {
        int leftScore = findScore(user.getLeft());
        int rightScore = findScore(user.getRight());

        int userScore = Math.max(leftScore, rightScore);

        user.setScore(userScore);
    }
    /*
    * 예외 처리
    */
    public static boolean checkedException(User pobi, User crong) {
        if (!checkedUser(pobi) || !checkedUser(crong))
            return false;

        return true;
    }
    public static boolean checkedUser(User user) {
        String errorMessage = "LIST SIZE ERROR";

        if (user.getLength() != Book.length.page)
            throw new IllegalArgumentException(errorMessage);

        if (!(user.getLeft() >= Book.first.page && user.getLeft() <= Book.last.page))
            return false;
        if (!(user.getRight() >= Book.first.page && user.getRight() <= Book.last.page))
            return false;
        if ((user.getLeft() % 2) == 0)
            return false;
        if ((user.getLeft() + 1) != user.getRight())
            return false;

        return true;
    }
}
