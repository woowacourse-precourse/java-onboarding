package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //예외 확인
        if(checkException(pobi) || checkException(crong))
            return -1;
        //포비
        List<Integer> pobiPages = new ArrayList<>();
        pobiPages.add(getMaxPageNumber(pobi.get(0)));
        pobiPages.add(getMaxPageNumber(pobi.get(1)));
        int pobiScore = maxNumber(pobiPages.get(0), pobiPages.get(1));

        //크롱
        List<Integer> crongPages = new ArrayList<>();
        crongPages.add(getMaxPageNumber(crong.get(0)));
        crongPages.add(getMaxPageNumber(crong.get(1)));
        int crongScore = maxNumber(crongPages.get(0), crongPages.get(1));

        //승자 선택
        answer = selectWinner(pobiScore, crongScore);
        return answer;
    }

    private static boolean checkException(List<Integer> list){
        //페이지가 1 미만 400 초과일 때
        for(int i=0; i< list.size(); i++){
            if(1 > list.get(i) || 400 < list.get(i))
                return true;
        }
        //오른쪽 페이지가 왼쪽페이지+1가 아닐 때
        if(list.get(0)+1 != list.get(1))
            return true;
        return false;
    }

    private static int getMaxPageNumber(int num){
        List list = separateNumber(num);
        return (maxNumber(sumNumbers(list), mulNumbers(list)));
    }

    private static List<Integer> separateNumber(int num){
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            list.add(num % 10);
            num = num /10;
        }
        return list;
    }

    private static int sumNumbers(List<Integer> list){
        int result = 0;
        for(int i=0; i< list.size(); i++){
            result += list.get(i);
        }
        return result;
    }

    private static int mulNumbers(List<Integer> list){
        int result = list.get(0);
        for(int i=1; i< list.size(); i++){
            result *= list.get(i);
        }
        return result;
    }

    private static int maxNumber(int num1, int num2){
        if(num1 > num2)
            return num1;
        return num2;
    }

    private static int selectWinner(int pobi, int crong){
        if(pobi == crong)
            return 0;
        if(pobi > crong)
            return 1;
        return 2;
    }
}