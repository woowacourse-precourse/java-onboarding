package onboarding;

import java.util.ArrayList;
import java.util.List;
/**
 * 1. 왼쪽이 홀수 오른쪽이 짝수인지, 왼쪽<오른쪽, 연속된 숫자인지 확인 -> 아니라면 -1을 return한다.
 * 2. pobi max와 crong max값을 구한다.
 * 3. 두개의 값을 비교해 0, 1, 2중 하나를 return한다.
 * 
 * @author 2songyi
 *
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        
    	int check = 0;
    	
    	// 페이지 유효성 체크 (조건이 안맞으면 return -1)
    	// 왼쪽이 홀수가 맞는지 확인한 후 +1한게 다음 숫자가 맞으면 통과
    	if (pobi.get(0) % 2 == 0 || pobi.get(0) + 1 != pobi.get(1)) {
    		return -1;
    	}
    	if (crong.get(0) % 2 == 0 || crong.get(0) + 1 != crong.get(1)) {
    		return -1;
    	}
    	
    	// pobi에게서 가장 큰 수 구하기
    	int p1 = plus(pobi.get(0));
    	int p2 = multi(pobi.get(0));
    	int p3 = plus(pobi.get(1));
    	int p4 = multi(pobi.get(1));
    	
    	int p_leftMax = Math.max(p1, p2);
    	int p_rightMax = Math.max(p3, p4);
    	
    	int p_max = Math.max(p_leftMax, p_rightMax);
    	
    	// crong의 가장 큰 수 구하기
    	int c1 = plus(crong.get(0));
    	int c2 = multi(crong.get(0));
    	int c3 = plus(crong.get(1));
    	int c4 = multi(crong.get(1));
    	int c_leftMax = Math.max(c1, c2);
    	int c_rightMax = Math.max(c3, c4);
    	
    	int c_max = Math.max(c_leftMax, c_rightMax);
    	
    	
    	// 값 비교 후 0, 1, 2중 하나 return 
    	if (p_max > c_max) {
    		return 1;
    	} else if (p_max < c_max) {
    		return 2;
    	} else if (p_max == c_max) {
    		return 0;
    	}
    	
    	return -1;
    }
    
    // 각 자리의 수 더하기
    public static int plus(int num) {
    	
    	int result = 0;
    	
    	 while (num > 0) {
             result += num % 10;
             num /= 10;
         }
    	return result;
    }
    
    
    // 각 자리의 수 곱하기
    public static int multi(int num) {
    	
    	int result = 1;
    	
   	 	while (num > 0) {
            result *= num % 10;
            num /= 10;
        }
   	 	return result;
   	 	
    }
    
//    public static void main(String[] args) {
//		List<Integer> pobi = new ArrayList<Integer>();
//		pobi.add(99);
//		pobi.add(102);
//		
//		List<Integer> crong = new ArrayList<Integer>();
//		crong.add(211);
//		crong.add(212);
//		
//		System.out.println(solution(pobi, crong));
//	}
}



