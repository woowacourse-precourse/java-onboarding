package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = fun(word);
        return answer;
    }

    //TODO:fun함수 기능목록 정의(말 다듬기)
    public static String fun(String word){
        char[] arr = word.toCharArray();
        String str = "";
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=65 && arr[i]<=90){
                str += (arr[i] = (char)(155-arr[i]));
            }else if(arr[i]>=97 && arr[i]<=122){
                str += (arr[i] = (char)(219-arr[i]));
            }else if(arr[i]==32){
                str+=" ";
            }
        }
        return str;
    }
}
