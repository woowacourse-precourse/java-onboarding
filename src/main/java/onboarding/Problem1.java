package onboarding;

import java.util.List;

class Problem1 {
    // 함수 Sum을 만들어 자릿수의 합을 구현해준다
    public static int Sum(int n){
        int a = 0;
        while(n > 0){
            a += n%10;
            n = n/10;

        }
        return a;
    } // 함수 Mul을 만들어 자릿수의 곱을 구현해준다
    public static int Mul(int n){
        int a = 1;
        while(n > 0){
            a *= n%10;
            n = n/10;
        }
        return a;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong)
    // (예외사항) pobi와 crong 왼쪽 페이지 번호 , 오른쪽 페이지 번호가 순서대로 들어있지 않는 경우 , -1을 return 한다
    {
        if(pobi.get(1) - pobi.get(0) !=1 || crong.get(1) - crong.get(0) !=1){
            return -1;
        }

        //pobi와 crong의 왼쪽 페이지 번호 자릿수의 덧셈의 최대값 , 왼쪽 페이지 번호 자릿수의 곱셈의 최대값 ,
        // 왼쪽 페이지 번호 덧셈의 최대값 곱셈의 최대값 중의 최대값을 totalpobi에 넣어준다
        int pobiLeftSum = Sum(pobi.get(0));
        int pobiLeftMul = Mul(pobi.get(0));

        int pobiRightSum = Sum(pobi.get(1));
        int pobiRightMul = Mul(pobi.get(1));

        int pobiLeftMax = Math.max(pobiLeftSum , pobiLeftMul);

        int pobiRightMax = Math.max(pobiRightSum , pobiRightMul);

        int totalpobi = Math.max(pobiLeftMax , pobiRightMax);


        //pobi와 crong의 오른쪽 페이지 번호 자릿수의 덧셈의 최대값 ,
        // 오른쪽 페이지 번호 자릿수의 곱셈의 최대값 오른쪽 페이지 번호 덧셈의 최대값 곱셈의 최대값 중의 최대값을 totalcrong에 넣어준다
        int crongLeftSum = Sum(crong.get(0));
        int crongLeftMul = Mul(crong.get(0));

        int crongRightSum = Sum(crong.get(1));
        int crongRightMul = Mul(crong.get(1));

        int crongLeftMax = Math.max(crongLeftSum , crongLeftMul);

        int crongRightMax = Math.max(crongRightSum , crongRightMul);

        int totalcrong = Math.max(crongLeftMax , crongRightMax);


        // if 조건문 totalpobi 가 totalcrong 값보다 크면 return 1 , totalcrong이 크면 return 2 , else return 0 (값이 같은경우)
        if (totalpobi > totalcrong){
            return 1;
        }
        else if (totalcrong > totalpobi) {
            return 2;
        }
        else{
            return 0;
        }

    }


}