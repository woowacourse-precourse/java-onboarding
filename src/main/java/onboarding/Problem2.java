package onboarding;

import java.util.*;
public class Problem2 {
    public static String solution(String cryptogram) {

        LinkedList<Character>list_1 = new LinkedList<>();
        LinkedList<Character>list_2 = new LinkedList<>();

        for(int i = 0 ; i < cryptogram.length(); i++) {
            list_1.offer(cryptogram.charAt(i));
        }

        for(int i = 0 ; i < list_1.size()-1; i++) {

            if(list_1.get(i)==list_1.get(i+1)) {
                list_1.remove(i);
                list_1.remove(i);

                i= -1;
            }
            if(list_1.size()==0||list_1.size()==1) {
                break;
            }
        }

        list_2 = list_1;

        String input ="";

        if(list_2.size()==0) {


        }else if(list_2.size()==1) {
            input+=list_2.get(0).toString();
        }
        else if(list_2.size()>=2) {
            for (int i = 0; i < list_2.size(); i++) {
                input += list_2.get(i).toString();
            }

        }
        String answer =input;
        return answer;
    }
}
