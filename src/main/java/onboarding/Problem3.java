package onboarding;

public class Problem3 {

    /*기능 목록
    1. 한 수를 한 글자씩 나누어 입력받을 때, 그 값이 3, 6, 9면 1를 리턴한다.
    2. 이를 한 수를 가지고 반복시킨다. (예를 들어 “33”이면 십의 자리 3, 일의 자리 3을 반복시킨다. 값을 합쳐 2를 리턴한다.)
    3. 이를 1부터 주어진 수 number 까지 반복해 총합을 리턴한다.
    */

    static final String THREE = "3";
    static final String SIX = "6";
    static final String NINE = "9";

    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            answer += addClapCount(Integer.toString(i));
        }
        return answer;
    }

    private static int addClapCount(String counted_number){
        int totalClapCount = 0;
        for(String each_number : counted_number.split("")){
            totalClapCount += countClaps(each_number);
        }
        return totalClapCount;
    }


    private static int countClaps(String each_number){
        if(each_number.equals(THREE)) return 1;
        if(each_number.equals(SIX)) return 1;
        if(each_number.equals(NINE)) return 1;
        return 0;
    }
}
