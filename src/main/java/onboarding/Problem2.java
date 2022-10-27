package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String str = cryptogram;

        int count = 1;
        while(count>0){

            str = changeLetter(str);
            count -= 1;

            for(int i = 0; i<str.length()-1; i++){
                if(str.charAt(i) == str.charAt(i+1)) {
                    count +=1;
                }
            }
        }

        return str;
    }

    public static String changeLetter(String name){
        List<String> list = new ArrayList<>();

        for(int i = 0; i<name.length(); i++){
            list.add(name.substring(i,i+1));
        }


        for(int i = 0; i<list.size()-1; i++){
            if (list.get(i).equals(list.get(i+1))){
                list.remove(i);
                list.remove(i);
                i=i-1;
            }
        }
        return String.join("",list);
    }

    public static void main(String[] args) {
        String str = new String("browoanoommnaon");


    }
}
