package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if((pobi.get(0) == pobi.get(1) - 1) && (crong.get(0) == crong.get(1) - 1)) {
        	int pobi_left = pobi.get(0);
			int pobi_right = pobi.get(1);
			int crong_left = crong.get(0);
        	int crong_right = crong.get(1);

			ArrayList<Integer> pobi_left_list = new ArrayList<>();
			ArrayList<Integer> crong_left_list = new ArrayList<>();
			ArrayList<Integer> pobi_right_list = new ArrayList<>();
			ArrayList<Integer> crong_right_list = new ArrayList<>();

			int sum_pobi_left=0, sum_pobi_right=0, sum_crong_left=0, sum_crong_right=0;
			int mul_pobi_left=1, mul_crong_left=1, mul_pobi_right=1, mul_crong_right=1;

			int max_pobi, max_crong;

        	while(pobi_left > 0) {
				pobi_left_list.add(pobi_left % 10);
        		pobi_left /= 10;
        	}
        	while(crong_left > 0) {
				crong_left_list.add(crong_left % 10);
        		crong_left /= 10;
        	}
			while(pobi_right > 0) {
				pobi_right_list.add(pobi_right % 10);
				pobi_right /= 10;
			}
			while(crong_right > 0) {
				crong_right_list.add(crong_right % 10);
				crong_right /= 10;
			}

			for(int i : pobi_left_list) sum_pobi_left += i;
			for(int i : crong_left_list) sum_crong_left += i;
			for(int i : pobi_right_list) sum_pobi_right += i;
			for(int i : crong_right_list) sum_crong_right += i;

			for(int i : pobi_left_list) mul_pobi_left *= i;
			for(int i : crong_left_list) mul_crong_left *= i;
			for(int i : pobi_right_list) mul_pobi_right *= i;
			for(int i : crong_right_list) mul_crong_right *= i;

			max_pobi = sum_pobi_left;
			if(max_pobi < sum_pobi_right) max_pobi = sum_pobi_right;
			if(max_pobi < mul_pobi_right) max_pobi = mul_pobi_right;
			if(max_pobi < mul_pobi_left) max_pobi = mul_pobi_left;

			max_crong = sum_crong_left;
			if(max_crong < sum_crong_right) max_crong = sum_crong_right;
			if(max_crong < mul_crong_left) max_crong = mul_crong_left;
			if(max_crong < mul_crong_right) max_crong = mul_crong_right;

			if(max_pobi > max_crong) answer = 1;
			else if(max_pobi == max_crong) answer = 0;
			else answer = 2;

        }else answer = -1;
        return answer;
    }
}