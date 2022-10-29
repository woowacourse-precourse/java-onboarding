package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pageCheck(pobi) == -1 || pageCheck(crong) == -1) {
            return -1;
        }

        int pobiLeftNumber = addEachNumber(pobi.get(0));
        int pobiRightNumber = addEachNumber(pobi.get(1));
        int crongLeftNumber = addEachNumber(crong.get(0));
        int crongRightNumber = addEachNumber(crong.get(1));

        return answer;
    }

    private static int pageCheck(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);

        if(leftPage <= 1 || rightPage >= 400)
            return -1;

        if(rightPage - leftPage != 1)
            return -1;

        return 0;
    }

    private static int addEachNumber(int num){
        int sum = 0;

        while(num != 0){
            sum += num % 10;
            num /= 10;
        }

        System.out.println("sum 의 값 : " + sum);
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        System.out.println(solution(pobi, crong));
    }

}