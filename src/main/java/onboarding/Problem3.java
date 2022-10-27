package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
//        System.out.println(get369removedString(String.valueOf(number)));
        return answer;
    }
    
    private static String get369removedString(String numToString) {
    	String result = "";
    	result = numToString.replaceAll("3", "")
    			.replaceAll("6", "")
    			.replaceAll("9", "");
    	return result;
    }
    
}
