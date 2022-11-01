package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pLeft=pobi.get(0);
        int cLeft=crong.get(0);
        // 예외사항 체크
        if(pLeft != pobi.get(1)-1 || cLeft != crong.get(1)-1 || pLeft%2==0 || 
        		cLeft%2==0 || pobi.size() != 2 || crong.size() != 2 ||
        		pLeft < 1 && pLeft> 400 || cLeft < 1 && cLeft > 400) { 
        	return -1;
        }
        int pobiMax=0;
        int crongMax=0;
      //pobi의 최댓값
        if(maxSum(pLeft)>pobiMax) pobiMax=maxSum(pLeft);
        if(maxMul(pLeft)>pobiMax) pobiMax=maxMul(pLeft);
        //crong의 최댓값
        if(maxSum(cLeft)>crongMax) crongMax=maxSum(cLeft);
        if(maxMul(cLeft)>crongMax) crongMax=maxMul(cLeft);
        int answer=0;
        //pobi와 crong의 최댓값 비교
        if(pobiMax==crongMax) answer=0;
        else if(pobiMax>crongMax) answer=1;
        else answer=2;
        return answer;
    }
    // 각 자리의 숫자 더하는 메서드
    public static int sumNum(int num){
        int sum=0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    // 각 자리의 숫자 곱하는 메서드
    public static int mulNum(int num){
        int mul=1;
        while(num>0){
            if(mul!=0){
                mul *= num%10;
            }
            num /= 10;
        }
        return mul;
    }
  //각 자리의 더한 값들 비교
    public static int maxSum(int num){
        int max=0;
        if((num+1)%10 != 0){
            max=sumNum(num+1);
        }else {
            max=sumNum(num);
        }
        return max;
    }
    //각 자리의 곱한 값들 비교
    public static int maxMul(int num){
        int max=1;
        if((num+1)%10 != 0){
            max=mulNum(num+1);
        }else{
            max=mulNum(num);
        }
        return max;
    }
}
