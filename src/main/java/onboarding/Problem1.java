package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.List;

class Problem1 {
	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> pobi = new ArrayList<>(2);
		ArrayList<Integer> crong = new ArrayList<>(2);
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(2);
		
		arr.add(pobi);
		arr.add(crong);
		for(int i=0;i<2;i++) {
			int r1 = arr.get(i).get(0);
			int r2 = arr.get(i).get(1);
			
			if(r1>r2) {
				arr.get(i).clear();
				arr.get(i).add(r2);
				arr.get(i).add(r1);
			}

			i++;
		}
		
		solution(pobi,crong);
		
	}
	
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int sum =0;
		int mul = 1;
		int[] pobi_v =new int[2];
		int[] crong_v =new int[2];
		
		
		if(pobi.get(1)-pobi.get(0)==1 && crong.get(1)-crong.get(0)==1 && 
				pobi.get(0)>1 && crong.get(0)>1 && pobi.get(1)<400 && crong.get(1)<400 &&
				pobi.get(0)!=pobi.get(1) && crong.get(0)!=crong.get(1) &&
				pobi.get(0)%2==1 && crong.get(0)%2==1) {
			for(int i=0;i<2;i++) {
				List<Integer> arr = new ArrayList<>();
				if(i==0) {
					arr=pobi;
				}else {
					arr=crong;
				}
				for(int j=0;j<2;j++) {
					String num = String.valueOf(arr.get(j));
					for(int k=0;k<num.length();k++) {
						sum += Integer.parseInt(num.charAt(k)+"");
						mul *= Integer.parseInt(num.charAt(k)+"");
					}
					if(i==0) {
						pobi_v[j]=Math.max(sum, mul);
					}else {
						crong_v[j]=Math.max(sum, mul);
					}
					sum =0;
					mul = 1;
				}
				
			}
			int pobi_res = Math.max(pobi_v[0],pobi_v[1]);
			int crong_res = Math.max(crong_v[0],crong_v[1]);
			if(pobi_res>crong_res) {
				return 1;
			}else if(pobi_res < crong_res) {
				return 2;
			}else if(pobi_res == crong_res) {
				return 0;
			}
		}
		
		return -1;

	}
}


