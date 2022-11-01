package onboarding;

import java.util.List;

/*
1. 페이지 번호 더하기
2. 페이지 번호 값 곱하기
3. 더한 값 과 곱한 값 비교하기
4. 페이지 차이 확인
 */
class Problem1 {
    public static int add(List<Integer> value){
        int max = 0;
        for(int i:value){
            int tmp = 0;

            for(int j=0;j<3;j++){
                tmp += i % 10;
                i = i / 10;
            }
            max = Math.max(max, tmp);
        }

        return max;
    }
    public static int multiple(List<Integer> value){
        int max = 0;
        for(int i:value){
            int tmp = 1;

            while (i!=0){
                tmp *= (i % 10);
                i = i / 10;
            }

            max = Math.max(max, tmp);
        }

        return max;
    }

    public static int compareValue(List<Integer> com){
        return Math.max(add(com),multiple(com));

    }
    public static boolean isVaild(List<Integer> value){
        return value.get(0) + 1 == value.get(1);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobipage = compareValue(pobi);
        int crongpage = compareValue(crong);
        int answer = Integer.MAX_VALUE;

        if(!isVaild(pobi) || !isVaild(crong)){
            answer = -1;
            return answer;
        }

        if (pobipage > crongpage){
            answer = 1;
        }
        if (pobipage == crongpage) {
            answer = 0;
        }
        if (pobipage < crongpage){
            answer = 2;
        }

        return answer;
    }
}