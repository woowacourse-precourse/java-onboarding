package onboarding;
import java.util.Scanner;

	public class problem4 {
		public static void main(String[] args) {
			problem4 a = new problem4();
			Scanner sc = new Scanner(System.in);
	        String input=sc.nextLine();
	        
	        char[] arr;
	        arr= input.toCharArray();
	        /*소문자<->대문자*/
	        for(int i=0; i<arr.length; ++i){
	            if(65<=arr[i] && arr[i]<=90){
	                arr[i]=(char)(arr[i]-32);
	                continue;}	                
	            if (97<=arr[i] && arr[i]<=122){
	                arr[i]=(char)(arr[i]+32);
	                continue; }	            	            
	            }	       	            
	            System.out.print(a.solution(input));
	        }
		
		public String solution(String word) {
			String result ="";
			char[] wordtemp = word.toCharArray();
			int reverse, abstemp, ascii = 0;
			for(int i=0; i<wordtemp.length; i++) {
				if(Character.isUpperCase(wordtemp[i])) {
					ascii=65;
				}else if(Character.isLowerCase(wordtemp[i])) {
					ascii=97;
				}else {
					result = result+' ';
					continue;
				}
				abstemp = Math.abs(ascii - wordtemp[i]);
				reverse = (ascii+25)-abstemp;
				result = result +String.valueOf((char)reverse);
			}
			return result;
		}
	}
			
