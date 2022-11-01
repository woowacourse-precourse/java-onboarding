package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int p = pageCal(pobi);
        int c = pageCal(crong);

        int answer = Integer.MAX_VALUE;
        if( (p == -1) || (c == -1)){
            answer = -1;
        }
        else if(p > c){
            answer = 1;
        }else if (p < c){
            answer = 2;
        }else{
            answer = 0;
        }
        return answer;
    }
    public static int pageCal(List<Integer> input){
        //예외처리 함수 호출
        if(exceptionCheck(input)) return -1;

        int max = Integer.MIN_VALUE;

        for(int i =0 ; i < input.size() ;i++){
            int plus = 0; //페이지 번호의 각 자리 숫자 더해서 저장
            int mul = 1; //페이지 번호의 각 자리 숫자 곱해서 저장
            int tmp = input.get(i); //페이지 번호를 가져온다
            // 페이지 번호 각 자리 숫자로 계산
            while(tmp%10 != 0){
                plus = plus + (tmp % 10);
                mul = mul * (tmp % 10);
                tmp = tmp / 10;
            }
            if( plus > mul ){ //더하기가 곱하기보다 큰 경우
                if( plus > max){ //그리고 max보다도 크면
                    max = plus; //max = plus;
                }
            }
            else{           //곱하기가 더하기보다 큰 경우
                if(mul > max){ //그리고 max 보다도 크면
                    max = mul; //max = mul;
                }
            }
        }
        return max;
    }
    public static boolean exceptionCheck(List<Integer> input){
        //페이지번호가 1부터 400 페이지까지이다. 범위를 넘어가면 예외처리
        if(input.get(0) < 1 || input.get(0) > 400) return true;
        if(input.get(1) < 1 || input.get(1) > 400) return true;
        //시작면이나 마지막 면이 나오면 안된다.
        // 시작면 [1, 2] 마지막 면 [399, 400]
        if(input.get(0) == 1) return true;
        if(input.get(0) == 399) return true;
        //input의 길이는 2이다. 2가 아니면 예외처리
        if(input.size() != 2) return true;
        //왼쪽 페이지는 홀수이어야 한다. 짝수면 예외처리
        if((input.get(0))%2 == 0) return true;
        //왼쪽페이지와 오른쪽 페이지의 번호는 1차이난다. 아니면 예외처리
        if((input.get(0)+1) != input.get(1)) return true;

        return false;
    }
}