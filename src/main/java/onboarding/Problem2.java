package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String[] arr = cryptogram.split("");

        boolean flag = true;

        while(flag){
            answer = "";
            flag = false;

            for(int i = 0;i<arr.length;i++){
                if(i == arr.length-1){
                    answer = answer + arr[i];
                    break;
                }
                if(!arr[i].equals(arr[i+1])){
                    answer = answer + arr[i];
                }else{
                    i++;
                    flag = true;
                }
            }
            arr = answer.split("");
        }


        return answer;
    }
}
