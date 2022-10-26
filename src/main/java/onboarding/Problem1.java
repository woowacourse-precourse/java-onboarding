package onboarding;

import java.util.List;

class Problem1 {
    /*
    (1) 전달인자(페이지 정보)에 대한 예외 처리
        1. 페이지 존재 여부 확인 (1-400 사이의 값)
        2. 서로 연결된 페이지가 맞는지 확인 (ex: [102, 103], [6, 7])
   (2) 페이지 세자리수의 곱과 페이지 세자리수의 합 중 더 큰 값을 점수로 저장
   (3) 두 사람의 점수를 비교해서 게임의 결과 return
   */
	private final static int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
		try {
			Game newGame = new Game(pobi, crong);
			return newGame.getResult();
		} catch(IllegalArgumentException exception) {
			return EXCEPTION;
		}
    }

    private static class Player {
        private  static final int LEFT_PAGE_INDEX = 0;
        private  static final int RIGHT_PAGE_INDEX = 1;
        private static final int MIN_PAGE = 1;
        private static final int MAX_PAGE = 400;
        private static final int PAGE_GAP = 1;
        private final int leftPage;
        private final int rightPage;
        public final int score;

        public Player(List<Integer> pages) {
            this.leftPage = pages.get(LEFT_PAGE_INDEX);
            this.rightPage = pages.get(RIGHT_PAGE_INDEX);
            if (arePagesExist() && arePagesLinked()) {
                this.score = Math.max(getPageMaxScore(leftPage), getPageMaxScore(rightPage));
            } else {
                throw new IllegalArgumentException();
            }
        }

        private boolean arePagesExist() {
            return (leftPage > MIN_PAGE && rightPage < MAX_PAGE);
        }

        private boolean arePagesLinked() {
            return (rightPage % 2 == 0 && rightPage - leftPage == PAGE_GAP);
        }

        private int getPageMaxScore(int page) {
            int pageSum = 0;
            int pageMultiply = 1;
            while(page != 0) {
                int currentNumber = page % 10;
                pageSum += currentNumber;
                pageMultiply *= currentNumber;
                page /= 10;
            }
            return Math.max(pageSum, pageMultiply);
        }
    }

	private static class Game{
		private final static int DRAW = 0;
		private final static int FIRST_PLAYER_WIN = 1;
		private final static int SECOND_PLAYER_WIN = 2;
		private final Player firstPlayer;
		private final Player secondPlayer;

		public Game(List<Integer> firstPlayerPages, List<Integer> secondPlayerPages) {
			firstPlayer = new Player(firstPlayerPages);
			secondPlayer = new Player(secondPlayerPages);
		}

		public int getResult() {
			if (firstPlayer.score > secondPlayer.score) {
				return FIRST_PLAYER_WIN;
			}
			if (firstPlayer.score < secondPlayer.score) {
				return SECOND_PLAYER_WIN;
			}
			return  DRAW;
		}
	}
}
