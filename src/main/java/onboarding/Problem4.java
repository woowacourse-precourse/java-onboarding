package onboarding;

public class Problem4 {
    public static char[] change(String word){
        char[] arr=word.toCharArray();
        int cnt = 0;
        while (cnt<arr.length){
            if (arr[cnt]>=65 && arr[cnt]<=90){ //대문자면

            }
            else if (arr[cnt]>=97 && arr[cnt]<=122){ //소문자면

            }
            else{ //알파벳이 아니면

            }
        }
        return arr;
    }
    public static String solution(String word) {
        String answer = "";
        change(word);
        return answer;
    }
}
