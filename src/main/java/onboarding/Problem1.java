package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        int pobiMax= -1;
        int crongMax= -1;
        
        //리스트에 저장된 페이지가 비정상적일 경우 -1리턴
        //페이지가 양쪽 번호가 아닐경우 -1
        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) {
        	return -1;
        }
        //페이지 범위가 1보다 작고 400보다 큰 경우 -1
        else if(pobi.get(0) < 1 || pobi.get(1) <1 || crong.get(0) <1 || crong.get(1) <1 || pobi.get(0)> 400 || pobi.get(1) >400 || crong.get(0) >400 || crong.get(1) >400) {
        	return -1;
        }
        //첫페이지, 마지막 페이지가 나올 경우 -1
        else if((pobi.get(0) == 1 && pobi.get(1)==2) || (pobi.get(0) == 399 && pobi.get(1)==400) ||  (crong.get(0) == 1 && crong.get(1)==2) || (crong.get(0) == 399 && crong.get(1)==400)) {
        	return -1;
        }
        //pobi가 펼친 페이지에서 최대값 구하기
        for(int i=0; i<2; i++) {
        	String strNum[] = String.valueOf(pobi.get(i)).split("");
        	
        	int sum=0;
        	int multiple =1;
        	for(int a=0; a<strNum.length; a++) {
        		
        		sum += Integer.parseInt(strNum[a]);
        		multiple *= Integer.parseInt(strNum[a]);
        	}
        	pobiMax = Math.max(pobiMax, Math.max(sum, multiple));
        	
        }
        //crong이 펼친 페이지에서 최대값 구하기        
        for(int i=0; i<2; i++) {
        	String strNum[] = String.valueOf(crong.get(i)).split("");
        	
        	int sum=0;
        	int multiple =1;
        	for(int a=0; a<strNum.length; a++) {
        		
        		sum += Integer.parseInt(strNum[a]);
        		multiple *= Integer.parseInt(strNum[a]);
        	}
        	crongMax = Math.max(crongMax, Math.max(sum, multiple));
        	
        }
        
        if(pobiMax > crongMax) {
        	answer = 1;
        }else if(pobiMax < crongMax) {
        	answer = 2;
        }else {
        	answer = 0;
        }
        
        /*
        answer 출력값
        포비가 이기면 1
        크롱이 이기면 2
        무승부 0
        예외 -1
        */        
        return answer;
    }
}