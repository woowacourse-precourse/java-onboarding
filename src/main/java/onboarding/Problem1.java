package onboarding;
import java.util.List;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) { // 페이지 에러
        	answer = -1;
        } else {
        	int p_max = 0, c_max = 0;

        	String p_left = String.valueOf(pobi.get(0));
        	String p_right = String.valueOf(pobi.get(1));
        	String c_left = String.valueOf(crong.get(0));
        	String c_right = String.valueOf(crong.get(1));

        	int p_left_sum = 0, p_left_mul = 1, p_right_sum = 0, p_right_mul = 1;
        	for(int i = 0; i < p_left.length(); i++) {
        		p_left_sum += Integer.parseInt(p_left.substring(i, i+1));
        		p_left_mul *= Integer.parseInt(p_left.substring(i, i+1));
        	}
        	p_max = Math.max(p_left_sum, p_left_mul);
        	for(int i = 0; i < p_right.length(); i++) {
        		p_right_sum += Integer.parseInt(p_left.substring(i, i+1));
        		p_right_mul *= Integer.parseInt(p_left.substring(i, i+1));
        	}
        	p_max = Math.max(p_max, Math.max(p_right_sum, p_right_mul));

        	int c_left_sum = 0, c_left_mul = 1, c_right_sum = 0, c_right_mul = 1;
        	for(int i = 0; i < c_left.length(); i++) {
        		c_left_sum += Integer.parseInt(c_left.substring(i, i+1));
        		c_left_mul *= Integer.parseInt(c_left.substring(i, i+1));
        	}
        	c_max = Math.max(c_left_sum, c_left_mul);
        	for(int i = 0; i < c_right.length(); i++) {
        		c_right_sum += Integer.parseInt(c_left.substring(i, i+1));
        		c_right_mul *= Integer.parseInt(c_left.substring(i, i+1));
        	}
        	c_max = Math.max(c_max, Math.max(c_right_sum, c_right_mul));

        	if(p_max == c_max) answer = 0;
        	else if(p_max > c_max) answer = 1;
        	else answer = 2;
        }

        return answer;
    }
}