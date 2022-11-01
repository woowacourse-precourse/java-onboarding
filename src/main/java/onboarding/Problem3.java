package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 주어진 number만큼 for문을 돌리며
 * 1의자리가 3, 6, 9라면 count++를 한다.
 * 마지막에 count를 return한다.
 * 
 * @author 2songyi
 *
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
        	// 숫자를 하나씩 잘라서 list에 담는다.
        	List<Integer> list = arrayNum(i);
        	
        	// 그 list를 for문 돌리면서 3,6,9가 나오면 count++
        	for (int n : list) {
        		if (n == 3 || n == 6 || n == 9) {
        			answer++;
        		}
        	}
        	
        }
        return answer;
    }
    
    // 숫자 각 자리수를 배열에 담기
    public static List<Integer> arrayNum(int num) {
    	
    	List<Integer> array = new ArrayList<>();
    	
    	while (num > 0) {
    		array.add(num % 10);
    		num /= 10;
    	}
    	
    	return array;
    }
//    
//    public static void main(String[] args) {
//		System.out.println(solution(13));
//	}
}
