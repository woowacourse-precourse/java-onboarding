package onboarding;

public class Problem4 {
    public static char[] change(String word){
        char[] arr=word.toCharArray();
        int cnt = 0;
        while (cnt<arr.length){
            if ((int)arr[cnt] >= 65 && (int)arr[cnt] <= 90){
                arr[cnt]= (char) (155 - (int)arr[cnt]);
                cnt += 1;
            }
            else if ((int)arr[cnt] >= 97 && (int)arr[cnt] <= 122){
                arr[cnt] = (char) (219 - (int)arr[cnt]);
                cnt += 1;
            }
            else{
                cnt++;
            }
        }
        return arr;
    }
    public static String solution(String word) {
        String answer = "";
        char[] temp = change(word);
        answer = String.valueOf(temp);
        return answer;
    }
}
