package onboarding;

public class Problem4 {
	public static void main(String[] args) {
		String word = "I love you";
		
		System.out.println(solution(word));
	}
    public static String solution(String word) {
        String answer = "";
        char[] arr = word.toCharArray();
		
		
		for(int i = 0; i< arr.length; i++) {
			if(arr[i]>=97) {
				int a = 122 - arr[i];
				
				arr[i] = (char) (97 + a);
			}else if(arr[i] >= 65){
				int b = 90 - arr[i];
				
				arr[i] = (char) (65 + b);
			}
		}
		
		answer = new String(arr);

        return answer;
    }
}
