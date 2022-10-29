package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public static List<Character> dltRedund(String cryptogram){
        int i = 0;
        List<Character> temp = new ArrayList<>();
        char prev = '0';
        boolean end = false;
        while(i < cryptogram.length()) {
            char item = cryptogram.charAt(i);
            if(i==0){
                temp.add(item);
                prev = item;
            }
            else {
                if (item == prev){
                    if (item == temp.get(temp.size()-1)) {
                        temp.remove(temp.size()-1);
                        //temp.add(item);
                        prev = item;}
                }
                else {
                    temp.add(item);
                    prev = temp.get(temp.size()-1);
                }

            }
            i++;
        }
        return temp;
    }
    public static String listToString(List<Character> temp){
        // char list to string
        String str = "";
        for (Character item : temp) {
            str += item + "";
        }
        return str;
    }
    public static boolean checkEnd(String str, String cryptogram){
        if(str.equals(cryptogram)) {
            return true;
        }
        return false;
    }

    public static String solution(String cryptogram) {

        // 0. 재귀 사용해서 끝까지 중복 제거
        // 1. 중복 삭제 기능
        // 2. List를 String으로 바꾸는 기능
        // 3. 원래 값과 비교해서 재귀 끝내는 조건 확인하는 기능
        String answer = "answer";
        List<Character> temp = dltRedund(cryptogram);

        if (checkEnd(listToString(temp), cryptogram)){
            answer = listToString(temp);
        }
        else {
            answer = solution(listToString(temp));
        }

        return answer;
    }

}