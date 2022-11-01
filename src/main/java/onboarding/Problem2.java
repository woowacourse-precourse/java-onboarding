package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> str = new ArrayList<Character>();

        for(int i=0;i<cryptogram.length();i++){
            str.add(cryptogram.charAt(i));
        }

        for(int i=0;i<str.size()-1;i++){
            if(str.get(i).equals(str.get(i+1))){
                str.remove(i+1);
                str.remove(i);
                i=0;
            }
        }
        if(str.size()>1){
            if(str.get(0)==str.get(1)){
                return "";
            }
            for(int i=0;i<str.size();i++){
                answer+=str.get(i);
            }
        }


        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(solution("zyelleyz"));
//    }
}
