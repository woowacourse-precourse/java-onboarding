package onboarding;

import java.util.ArrayList;
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

        int pobiMax = 0;
        boolean checkerP = validateNums(pobi);
        for(Integer i : pobi){
            List<Integer> pobiNums = splitNum(i);
            pobiMax = Integer.max(pobiMax,addList(pobiNums));
            pobiMax = Integer.max(pobiMax,multiplyList(pobiNums));
        }

        int crongMax = 0;
        boolean checkerC = validateNums(crong);
        for(Integer i : crong){
            List<Integer> crongNums = splitNum(i);
            crongMax = Integer.max(crongMax,addList(crongNums));
            crongMax = Integer.max(crongMax,multiplyList(crongNums));
        }

        if(checkerC||checkerP) {
            answer = -1;
            return answer;
        }
        if(pobiMax>crongMax) answer = 1;
        if(pobiMax<crongMax) answer = 2;
        if(pobiMax==crongMax) answer = 0;

        return answer;
    }

    private static boolean validateNums(List<Integer> list) {
        int a = list.get(0);
        int b = list.get(1);
        if(a>b) return true;
        if(a+1 != b) return true;
        if(a<1) return true;
        if(a>400) return true;
        if(a%2==0) return true;
        if(b%2==1) return true;
        return false;
    }

    // 쪼개기 , 리스트에 넣기
    public static List<Integer> splitNum(Integer num){
        List<Integer> temp = new ArrayList<>();
        String s = Integer.toString(num);
        String[] splits = s.split("");
        for(String split:splits){
            temp.add(Integer.parseInt(split));
        }
        return temp;
    }

    //리스트의 수 전부 더하기
    public static int addList(List<Integer> list){
        int res = list.stream().mapToInt(Integer::intValue).sum();
        return res;
    }

    public static int multiplyList(List<Integer> list){
        int res = 1;
        for(int x : list){
            res *= x;
        }
        return res;
    }

}