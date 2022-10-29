package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        LinkedList<String> password = new LinkedList<String>();

        for(int i = 0; i < cryptogram.length(); i++){
            String cryptogram_i = cryptogram.substring(i, i+1);
            password.add(cryptogram_i);
        }

        return answer;
    }

    public static LinkedList<String> removeSameStr(LinkedList<String> password){
        for(int i = 0; i < password.size() - 1; i++){
            String password_i = password.get(i);
            String password_i_next = password.get(i+1);

            if(password_i.equals(password_i_next)) {
                password.remove(i);
                password.remove(i);         //위에서 제거하면 i+1에 있던 문자가 i로 옮겨짐, 제거
                break;
            }
        }

        return password;
    }
}
