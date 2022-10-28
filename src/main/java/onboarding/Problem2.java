package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = eraseDup(cryptogram);
        return answer;
    }
    public static String eraseDup(String str){
        ArrayList<Character> arrayList=new ArrayList<>();
        arrayList.add('0');
        for (int i = 0; i < str.length(); i++) {
            if(arrayList.get(arrayList.size()-1)==str.charAt(i)){
                arrayList.remove(arrayList.size()-1);
                continue;
            }
            arrayList.add(str.charAt(i));
        }
        String tmp="";
        for (int i = 1; i < arrayList.size(); i++) {
            tmp+=Character.toString(arrayList.get(i));
        }
        return tmp;
    }
}
