package onboarding;

import java.util.List;

class Problem1 {
    static int pobiNum;

    static int crongNum;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        validatePage(pobi);
        validatePage(crong);

        pobiNum = findMaxNum(pobi);
        crongNum = findMaxNum(crong);

        if(pobiNum == crongNum){
            answer = 0;
        } else if( pobiNum > crongNum) {
            answer = 1;
        } else {
            answer = -1;
        }


        return answer;
    }

    public static Integer findMaxNum(List<Integer> pageList){
        int max = Integer.MAX_VALUE;

        for(Integer page : pageList){
            String[] pageSplits = page.toString().split("");

            int plus = 0;
            int multi = 1;

            for(String pageString : pageSplits){
                int number = Integer.parseInt(pageString);
                plus += number;
                multi *= number;

                if(plus >= multi){
                    max = plus;
                }
            }
        }
        return max;
    }

    //시작면이나 마지막 면인 경우 예외처리
    public static void validatePage(List<Integer> pageList){
        if(pageList.contains(1)){
            throw new RuntimeException("첫번째 페이지는 펼칠 수 없습니다.");
        } else if(pageList.contains(400)){
            throw new RuntimeException("마지막 페이지느 펼칠 수 없습니다.");
        }
    }

}