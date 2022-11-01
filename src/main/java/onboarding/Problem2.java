package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String[] arr = cryptogram.split("");
        for(int i=0; i<arr.length-1; i++){
            if(arr[i].equals(arr[i+1])){
                arr[i]=arr[i].replace(arr[i], "");
                arr[i+1]=arr[i+1].replace(arr[i+1], "");
                
                arr = Arrays.stream(arr)
                    .filter(item -> !item.equals(""))
                    .toArray(String[]::new);
                
                i=-1;
            }
        }
        String newcryptogram = String.join("",arr);
        answer = newcryptogram;

        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cryptogram = sc.nextLine();
        sc.close();
        System.out.println(solution(cryptogram));
    }
}