package onboarding;

import onboarding.problem1.MaxValueBookGame;
import onboarding.problem1.repository.BookInfoRepository;

import java.util.List;

class Problem1 {
    static BookInfoRepository pobiBookInfo;
    static BookInfoRepository cronBookInfo;
    static MaxValueBookGame maxValueBookGame = new MaxValueBookGame();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        MaxValueBookGame maxValueBookGame = new MaxValueBookGame();
        if (maxValueBookGame.isFailedInputValidation(pobi)
                || maxValueBookGame.isFailedInputValidation(crong)) return -1;

        saveBookGameInfo(pobi, crong);

        pobiBookInfo.setPlayerTopPoint(playerTopPoint(pobi));
        cronBookInfo.setPlayerTopPoint(playerTopPoint(crong));

        answer = pobiBookInfo.getPlayerTopPoint() > cronBookInfo.getPlayerTopPoint() ? 1 :
                pobiBookInfo.getPlayerTopPoint() < cronBookInfo.getPlayerTopPoint() ? 2 : 0;

        if (answer > Integer.MAX_VALUE) return -1;

        System.out.println("result : " + answer);

        return answer;
    }

    public static void saveBookGameInfo(List<Integer> pobi, List<Integer> crong) {
        pobiBookInfo = new BookInfoRepository(pobi);
        cronBookInfo = new BookInfoRepository(crong);
    }

    public static int playerTopPoint(List<Integer> gamePlayer) {
        int leftPageTopPoint = maxValueBookGame.returnMaxValue(
                maxValueBookGame.sumSeparatorNum(gamePlayer.get(0)),
                maxValueBookGame.multiSeparatorNum(gamePlayer.get(0)
                )
        );

        int rightPageTopPoint = maxValueBookGame.returnMaxValue(
                maxValueBookGame.sumSeparatorNum(gamePlayer.get(1)),
                maxValueBookGame.multiSeparatorNum(gamePlayer.get(1)
                )
        );

        return leftPageTopPoint > rightPageTopPoint ? leftPageTopPoint : rightPageTopPoint;
    }
}