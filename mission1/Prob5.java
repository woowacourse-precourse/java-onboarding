////
import java.util.Arrays;

public class Prob5 {
	
	public int[] money(int total) {
		int[] result = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }; 
		
		while(total/50000 > 0) {
			total -= 50000;
			result[0] += 1;
		}
		while(total/10000 > 0) {
			total -= 10000;
			result[1] += 1;
		}
		while(total/5000 > 0) {
			total -= 5000;
			result[2] += 1;
		}
		while(total/1000 > 0) {
			total -= 1000;
			result[3] += 1;
		}
		while(total/500 > 0) {
			total -= 500;
			result[4] += 1;
		}
		while(total/100 > 0) {
			total -= 100;
			result[5] += 1;
		}
		while(total/50 > 0) {
			total -= 50;
			result[6] += 1;
		}
		while(total/10 > 0) {
			total -= 10;
			result[7] += 1;
		}		
		result[8] = total;
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Problem 5");
		Prob5 prob5 = new Prob5();
		
		int total = 50237;
		
		int[] result = prob5.money(total);
		System.out.println(Arrays.toString(result));
				
	}
}
