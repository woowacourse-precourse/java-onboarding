////
public class Prob3 {
	
	public int clap(int num) {
		int cnt = 0;
		String str;
		
		for(int i=1; i<num+1; i++) {
			str = Integer.toString(i);
			
			for(int j=0; j < str.length(); j++) {
				int temp = Character.getNumericValue(str.charAt(j));
				//System.out.println(temp);
				if(temp==3 || temp==6 || temp==9) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	

	public static void main(String[] args) {
		System.out.println("Problem 3");
		
		Prob3 prob3 = new Prob3();
		int number = 33;
		
		int result = prob3.clap(number);
		System.out.println(result);
	}

}


//if(str.contains("3") || str.contains("6") || str.contains("9")) {
//cnt++;
//System.out.println(str);
//break;