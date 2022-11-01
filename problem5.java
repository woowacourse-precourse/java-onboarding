package onboarding;
import java.util.Scanner;

public class problem5 {
	public static void main(String[] args) {
		problem5 a = new problem5();
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		
		System.out.print(a.solution(m));

		
}
	public int solution(int money) {
		int a, b, c, d, e, f, g, h, i=0;
				
		a = money/50000;				//50000
		b = money%50000/10000; 			//10000
		c = money%10000/5000;			//5000
		d = money%10000%5000/1000;		//1000
		e = money%1000/500;				//500
		f = money%1000%500/100;			//100
		g = money%100/50;				//50
		h = money%100%50/10;			//10
		i = money%10;					//1
		
		System.out.println("[" + a + "," + b + "," + c + "," + d + ","
								+e + "," +f + "," + g + "," + h + "," + i+ "]");
		return money;
	}
}