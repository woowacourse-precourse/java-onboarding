package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = word.toCharArray();
        arr[0]=Character.toUpperCase(arr[0]);
        int reverse, abstmp, ascii =0;
        for(int i=0; i<arr.length; i++){
            if(Character.isUpperCase(arr[i])) ascii= 65;
            else if(Character.isLowerCase(arr[i])) ascii=97;
            else {
                answer = answer + ' ';
                continue;
            }
            abstmp = Math.abs(ascii-arr[i]);
            reverse = (ascii+25) - abstmp;
            answer = answer + String.valueOf((char) reverse);
        }
        return answer;
    }
}
