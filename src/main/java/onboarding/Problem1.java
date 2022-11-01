package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        
    	int answer = Integer.MAX_VALUE;
    	
    	if(isRight(pobi,crong)) {
    		
    		int pobimax = calnum(pobi);
    		int crongmax = calnum(crong);
    		
    		if(pobimax > crongmax) {
    			answer = 1;
    		} else if (pobimax < crongmax) {
    			answer = 2;
    		} else if(pobimax==crongmax) {
    			answer = 0;
    		}
    		
    		
    	} else {
    		answer = -1;
    	}
        
        return answer;

    }

   
    // 예외사항 판단 하는 메소드
    public static boolean isRight(List<Integer> pobi, List<Integer> crong) {
    	// 페이지가 1부터 400까지 인지 확인(1과 400은 제외)
    	if(inRange(pobi.get(0)) && inRange(pobi.get(1)) && inRange(crong.get(0)) && inRange(crong.get(1))) {
    	} else {
    		return false;
    	}
    	
    	// 왼쪽 홀수 오른쪽 짝수 확인
    	if(pobi.get(0)%2==1 && pobi.get(1)%2==0 && crong.get(0)%2==1 && crong.get(1)%2==0) {
    	} else {
    		// 아니면 false
    		return false; 
    	}
    	
    	// 왼쪽 다음 페이지가 오른쪽인지 확인
    	if(((pobi.get(0)+1)==pobi.get(1)) && ((crong.get(0)+1)==crong.get(1))) {
    	} else {
    		return false;
    	}
    	
    	
    	return true;
    }
    
    // 각자리 숫자를 모두 더하는 메소드
    public static int plusNum(int num) {
    	int sum = 0;
    	
    	while(num != 0) {
    		sum += num%10;
    		num /= 10;
    	}
    	
    	return sum;
    }
    
    // 각자리 숫자를 모두 곱하는 메소드
    public static int multiNum(int num) {
    	int mul = 1;
    	
    	while(num != 0) {
    		mul *= num%10;
    		num /= 10;
    	}
    	
    	return mul;
    }
    
    
    // 각자의 최대 점수를 반환하는 메소드
    public static int calnum(List<Integer> person) {
    	int max_score = Integer.MIN_VALUE;
    	
    	max_score = Math.max(max_score, plusNum(person.get(0)));
    	max_score = Math.max(max_score, plusNum(person.get(1)));
    	max_score = Math.max(max_score, multiNum(person.get(1)));
    	max_score = Math.max(max_score, multiNum(person.get(1)));
    	
    	return max_score;
    }

    
    // 페이지가 1~400 페이지인지 확인
    // 시작면이나 마지막면이 나오도록 책을 펼치지 않기 때문에
    // 1과 400도 false 반환
    public static boolean inRange(int num) {
    	if(num > 1 && num < 400) {
    		return true;
    	} else {
    		return false;
    	}
    }
}