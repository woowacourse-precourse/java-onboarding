package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean deleted = true;
        cryptogram = cryptogram.toLowerCase();

        if(validation(cryptogram)){
            return "";
        }

        // return orderedDeCryptogram(cryptogram);
        return deCryptogram(cryptogram);
    }

    // 스택을 이용한 경우
    public static String deCryptogram(String str){
        Stack<String> s = new Stack <>();
        StringBuilder sb = new StringBuilder();

        for(String word : str.split("")){
            if(s.isEmpty()){
                s.push(word);
            } else if(s.peek().equals(word)){
                s.pop();
            } else {
                s.push(word);
            }
        }

        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.reverse().toString();
    }

    // 절차적으로 코드를 지워나가기 위함
    public static String finalStr = "";
    public static String orderedDeCryptogram(String str){
        boolean deleted = false;
        String previous = "";
        StringBuilder sb = new StringBuilder();

        for(String word : str.split("")){
            if(previous.equals(word)){
                deleted = true;
                sb.deleteCharAt(sb.lastIndexOf(previous));
                previous = "";
                continue;
            }
            previous = word;
            sb.append(word);
        }

        finalStr = sb.toString();

        if(deleted && !finalStr.equals("")) {
            orderedDeCryptogram(finalStr);
        }

        return finalStr;
    }



    private static boolean validation(String cryptogram) {
        return cryptogram.length() < 1 || cryptogram.length() > 1000;
    }
}
