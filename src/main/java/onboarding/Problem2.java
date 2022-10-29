package onboarding;

import java.util.LinkedList;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = "";
        final int LENGTH=cryptogram.length();
        LinkedList<String> list=new LinkedList<String>();

        String[] array=cryptogram.split("");

        for(int i=0;i<LENGTH;i++) list.add(array[i]);

        while(true) {

            int[] remove_index = new int[LENGTH];

            for (int i = 0; i < LENGTH; i++) remove_index[i] = -1;

            int j = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).equals(list.get(i+1))) {
                    remove_index[j++] = i;
                }
            }
            if(j==0) {
                Object[] arr=list.toArray();
                for(int i=0;i<arr.length;i++) {
                    answer += (String) arr[i];
                }
                return answer;
            }
            int a = j-1;

            while (a>=0) {
                list.remove(remove_index[a]+1);
                list.remove(remove_index[a]);
                a--;
            }
        }
    }
}