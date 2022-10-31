package onboarding;

import java.util.List;

/*
필요한 기능
1. 처음 pobi, crong 리스트에 들어있는 수에 대한 검증
    -> pobi.get(0) % 2 == 1 && pobi.get(0) + 1 == pobi.get(1) && 1<=pobi.get(0)<pobi.get(1)<=400
    -> crong도 이와 동일
2. 페이지의 각 자리의 수를 분리함
3. 분리된 각 숫자들에 대한 합을 return 하는 함수
4. 분리된 각 숫자들에 대한 곱을 return 하는 함수
5. 두 값 중 큰 값을 골라냄 (Math.max())
6. 2-5를 두번 시행하여 pobi의 max 찾아냄.
7. crong에게도 똑같은 시행으로 max 찾아냄.
8. pobi와 crong의 비교를 통한 승패 결정

 */


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        for(Integer i : pobi){
            List<Integer> pobiNums = splitNum(i);
        }

        return answer;
    }
    // 쪼개기 , 리스트에 넣기
    public static List<Integer> splitNum(Integer num){
        List<Integer> temp =List.of();
        int n = (int)(Math.log10(num)+1);
        while(num!=0){
            int x = num /(int) Math.pow(10,n-1);
            temp.add(x);
            num = num % (int)Math.pow(10,n-1);
        }
        return temp;
    }

}