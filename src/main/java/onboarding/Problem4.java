package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = word.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==32){
                answer += " ";
            }
            else if(Character.isUpperCase(arr[i])){
                int temp = arr[i] - 65;
                int reverse = (65 + 25) - temp;
                answer += String.valueOf((char)reverse);
            }
            else{
                int temp = arr[i] - 97;
                int reverse = (97 + 25) - temp;
                answer += String.valueOf((char)reverse);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
