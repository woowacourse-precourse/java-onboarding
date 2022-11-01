package onboarding;
import java.util.Scanner;

public class problem3 {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
		System.out.print("");
		int number = sc.nextInt();
		int count = 0;
			
		for(int i=1; i<=number; i++) {
					
			if(i<10) {
				if(i == 3 || i == 6 || i == 9) {
					count += 1;					
				}
			} else {
				boolean b1 = false;   
				boolean b2 = false;   
					
				int n1 = i / 10;     
				int n2 = i % 10;      
					
				if(n1 == 3 || n1 == 6 || n1 == 9) {
					b1 = true;
				}
					
				if(n2 == 3 || n2 == 6 || n2 == 9) {
					b2 = true;
				}
					
				if(b1 && b2) {
					count += 2;					
				} else if(b1 || b2) {
					count += 1;					
				} 
			}
		}			
		System.out.println(count);			
	}
 }
