package onboarding;

import java.util.Locale;

public class Problem4 {
    public static String solution(String word) {
        char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String answer = "";

        for(int i=0;i< word.length();i++){
            String test = word.toUpperCase();
            if(word.charAt(i)==' ') answer+=' ';
            else{
                char s = test.charAt(i);

                System.out.print(s);
                int k=0;
                for(int j=0;j<arr.length;j++){
                    if(s==arr[j]) {
                        k=j;
                        System.out.println(k);
                        break;
                    }
                }
                if(Character.isUpperCase(word.charAt(i))){
                    answer+=arr[arr.length-k-1];
                }
                else{
                    answer+=Character.toLowerCase(arr[arr.length-k-1]);
                }
            }
        }
        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(solution("I love you"));
//    }
}
