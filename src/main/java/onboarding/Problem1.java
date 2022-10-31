package onboarding;

import java.util.List;

class Problem1 {
    static final int RIGHT_PAGE = 1;
    static final int LEFT_PAGE = 0;
    static final int PAGE_GAP = 1;
    static final int POBI_WINS = 1;
    static final int CRONG_WINS = 2;
    static final int DRAWS = 0;
    static final int ERROR = -1;
    static final int MAX_PAGE = 400;
    static final int MIN_PAGE = 1;
    static final String LEFT_PAGE_TOO_SMALL = "왼쪽 페이지가 최소값인 1보다 작습니다.";
    static final String LEFT_PAGE_TOO_BIG = "왼쪽 페이지가 최대값인 400보다 큽니다.";
    static final String RIGHT_PAGE_TOO_SMALL = "오른쪽 페이지가 최소값인 1보다 작습니다.";
    static final String RIGHT_PAGE_TOO_BIG = "오른쪽 페이지가 최대값인 400보다 큽니다.";



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isNotValidPage(pobi) || isNotValidPage(crong)) return ERROR;
        return getResult(getScore(pobi), getScore(crong));
    }
    private static boolean isNotValidPage(List<Integer> person){
        checkExceptionOnPerson(person);
        if(person.get(RIGHT_PAGE) - person.get(LEFT_PAGE) != PAGE_GAP) return true;
        return false;
    }

    private static void checkExceptionOnPerson(List<Integer> person){
        checkExceptionOnLeftPage(person);
        checkExceptionOnRightPage(person);
    }

    private static void checkExceptionOnLeftPage(List<Integer> person){
        if(person.get(LEFT_PAGE) > MAX_PAGE) throw new IllegalArgumentException(LEFT_PAGE_TOO_BIG);
        if(person.get(LEFT_PAGE) < MIN_PAGE) throw new IllegalArgumentException(LEFT_PAGE_TOO_SMALL);
    }

    private static void checkExceptionOnRightPage(List<Integer> person){
        if(person.get(RIGHT_PAGE) > MAX_PAGE) throw new IllegalArgumentException(RIGHT_PAGE_TOO_BIG);
        if(person.get(RIGHT_PAGE) < MIN_PAGE) throw new IllegalArgumentException(RIGHT_PAGE_TOO_SMALL);
    }

    private static int getResult(int pobis, int crongs){
        if(pobis == crongs) return DRAWS;
        if(pobis > crongs) return POBI_WINS;
        return CRONG_WINS;
    }

    private static int getScore(List<Integer> person){
        int firstPage = getBiggerResult(person.get(0));
        int secondPage = getBiggerResult(person.get(1));
        return Math.max(firstPage, secondPage);
    }

    private static int getBiggerResult(int page){
        return Math.max(getSumOfPage(page), getMultiplyOfPage(page));
    }

    private static int getSumOfPage(int page){
        int result = 0;
        for(String number_each : Integer.toString(page).split("")){
            result += Integer.parseInt(number_each);
        }
        return result;
    }

    private static int getMultiplyOfPage(int page){
        int result = 1;
        for(String number_each : Integer.toString(page).split("")){
            result *= Integer.parseInt(number_each);
        }
        return result;
    }
}