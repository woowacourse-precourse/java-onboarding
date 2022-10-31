package onboarding;
import java.util.*;

import static java.lang.String.valueOf;

public class Problem4 {
    public static String solution(String word) {
        HashMap<String, String> wordHash = new HashMap<String, String>();
        HashMap<String, String> wordHash2 = new HashMap<String, String>();

        ArrayList<String> list = new ArrayList<String> ();
        ArrayList<String> list2 = new ArrayList<String> ();
        ArrayList<String> list3 = new ArrayList<String> ();
        ArrayList<String> list4 = new ArrayList<String> ();
        for(int i=65; i<=90; i++){
            String a = valueOf((char) i);
            list.add(a);
        }
        String c = valueOf((char) 32);
        list.add(c);




        for(int i=90; i>=65; i--){
            String b = valueOf((char) i);
            list2.add(b);

        }
        list2.add(c);

        for(int i=97; i<=122; i++){
            String b = valueOf((char) i);
            list3.add(b);

        }
        for(int i=122; i>=97; i--){
            String b = valueOf((char) i);
            list4.add(b);

        }
        for(int i=0; i<26; i++){
            wordHash.put(list.get(i),list2.get(i));
            wordHash.put(list3.get(i),list4.get(i));
        }



        int length = word.length();
        String[] arrWord = word.split("");
        String[] arrAnswer = new String[length];
        for(int i = 0; i< length; i++){

            arrAnswer[i]=wordHash.get(arrWord[i]);

        }
        for(int i= 0; i<length;i++){
            if(arrAnswer[i]==null){
                arrAnswer[i]=" ";
            }
        }
        String answer = String.join("",arrAnswer);




        System.out.println(answer);

        return answer;
    }

}
