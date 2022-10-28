package onboarding;

import java.util.List;

class Problem1 {

    /*
    기능 목록
 1. 한 사람의 두 페이지가 바로 다음 페이지가 아니면 -1을 리턴하고 게임을 끝낸다.
 2. 페이지 수를 받아와 숫자들의 합을 구한다.
 3. 페이지 수를 받아와 숫자들의 곱을 구한다.
 4. 페이지 수의 합과 곱을 구해와 그 중 큰 값을 점수로 사용한다.
 5. 한 사람이 가질 수 있는 두 페이지중 더 큰 값을 사람의 점수로 사용한다.
 6. 두 사람의 점수를 구해와 더 큰 사람이 이긴다.
    * */
    static final int RIGHT_PAGE = 1;
    static final int LEFT_PAGE = 0;
    static final int PAGE_GAP = 1;
    static final int POBI_WINS = 1;
    static final int CRONG_WINS = 2;
    static final int DRAWS = 0;
    static final int ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isNotValidPage(pobi) || isNotValidPage(crong)) return ERROR;
        return getResult(getScore(pobi), getScore(crong));
    }
    private static boolean isNotValidPage(List<Integer> person){
        if(person.get(LEFT_PAGE) > MAX_PAGE || person.get(LEFT_PAGE) < MIN_PAGE) return true;
        if(person.get(RIGHT_PAGE) > MAX_PAGE || person.get(RIGHT_PAGE) < MIN_PAGE) return true;
        if(person.get(RIGHT_PAGE) - person.get(LEFT_PAGE) != PAGE_GAP) return true;
        return false;
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