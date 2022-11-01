package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = fun(word);
        return answer;
    }

    //TODO: 리팩토링 필요
    public static String fun(String word){
        char[] arr = word.toCharArray();
        StringBuilder str = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=65 && arr[i]<=90){
                str.append(arr[i] = (char) (155 - arr[i]));
            }else if(arr[i]>=97 && arr[i]<=122){
                str.append(arr[i] = (char) (219 - arr[i]));
            }else if(arr[i]==32){
                str.append(" ");
            }else
                str.append(arr[i]);
        }
        return str.toString();
    }
}
