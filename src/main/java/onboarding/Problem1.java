package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        Person pobiObj = new Person(pobi);
        Person crongObj = new Person(crong);

        if (!isValidList(pobiObj) || !isValidList(crongObj)) {
            answer = -1;
            return answer;
        }

        Score pobiScoreObj = new Score(pobiObj);
        Score crongScoreObj = new Score(crongObj);

        int pobiScore = pobiScoreObj.getScore();
        int crongScore = crongScoreObj.getScore();

        if (pobiScore > crongScore) {
            answer = 1;
            return answer;
        }
        if (crongScore > pobiScore) {
            answer = 2;
            return answer;
        }

        return answer;
    }

    public static boolean isValidList(Person person) {
        ExceptionHandling eh = new ExceptionHandling(person);
        if (!eh.isInRange()) {
            return false;
        }
        if (!eh.isValidPageFormat()) {
            return false;
        }
        if (!eh.isConsecutivePages()) {
            return false;
        }
        return true;
    }
}

class Person {
    private int leftPage;
    private int rightPage;
    private int score;

    Person(List<Integer> pages) {
        this.leftPage = pages.get(0);
        this.rightPage = pages.get(1);
    }

    public int getLeftPage() {
        return leftPage;
    }

    public int getRightPage() {
        return rightPage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

class Score {
    private int leftPage;
    private int rightPage;

    Score(Person person) {
        this.leftPage = person.getLeftPage();
        this.rightPage = person.getRightPage();
    }

    public int getScore() {
        int leftMaxValue = getMaxValue(leftPage);
        int rightMaxValue = getMaxValue(rightPage);

        int score = Math.max(leftMaxValue, rightMaxValue);

        return score;
    }

    public int getMaxValue(int num) {
        int maxValue = Math.max(getDigitSum(num), getDigitMultiplication(num));

        return maxValue;
    }

    public int getDigitSum(int num) {
        int result = 0;

        while (num > 1) {
            result += num % 10;
            num /= 10;
        }

        return result;
    }

    public int getDigitMultiplication(int num) {
        int result = 1;

        while (num > 1) {
            result *= num % 10;
            if (result == 0) {
                break;
            }
            num /= 10;
        }

        return result;
    }
}


class ExceptionHandling {
    private int leftPage;
    private int rightPage;

    ExceptionHandling(Person person) {
        this.leftPage = person.getLeftPage();
        this.rightPage = person.getRightPage();
    }

    public boolean isConsecutivePages() {
        if (rightPage - leftPage == 1) {
            return true;
        }
        return false;
    }

    public boolean isInRange() {
        if (leftPage > 0 && leftPage <= 400 && rightPage > 0 && rightPage <= 400) {
            return true;
        }
        return false;
    }

    public boolean isValidPageFormat() {
        if (leftPage % 2 == 1 && rightPage % 2 == 0) {
            return true;
        }
        return false;
    }

}