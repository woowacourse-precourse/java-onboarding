package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        LinkedList<String> password = new LinkedList<String>();

        for(int i = 0; i < cryptogram.length(); i++){
            String cryptogram_i = cryptogram.substring(i, i+1);
            password.add(cryptogram_i);
        }

        while(true){
            int password_size = password.size();        //검사 전 문자열의 길이 저장
            removeSameStr(password);
            if(password_size == password.size()){       //검사 전과 후의 문자열의 길이가 같으면 변하지 않았다는 뜻
                break;
            }
        }

        for(int i = 0; i < password.size(); i++){
            answer += password.get(i);                  //answer에 password에 남은 문자 하나씩 더해서 붙여줌
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
