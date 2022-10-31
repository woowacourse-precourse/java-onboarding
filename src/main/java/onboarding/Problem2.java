package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] arr = cryptogram.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            arrayList.add(String.valueOf(arr[i]));
        }

        int count = -1;
        while(count!=0){
            int size = arrayList.size();
            count = 0;
            for(int i=0; i<size; i++){
                if(i+1 < arrayList.size() && arrayList.get(i).equals(arrayList.get(i+1))){
                    arrayList.remove(i+1);
                    arrayList.remove(i);
                    count ++;
                }
            }
        }
        String answer = "";
        for(int i=0; i<arrayList.size(); i++){
            answer += arrayList.get(i);
        }
        return answer;
    }
}
