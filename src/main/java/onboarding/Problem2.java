package onboarding;

public class Problem2 {

    static String Decode(String password){
        boolean check = false;
        String D_password = "";
        char before = ' ';
        char now_char = ' ';
        char next_char = ' ';

        if(password.length()<=1){
            return password;
        }
        for(int i = 0 ; i < password.length() ; i++){
            now_char = password.charAt(i);
            if(i!=password.length()-1) next_char = password.charAt(i + 1);
            if(i == password.length()-1){
                if(Character.compare(before, now_char) != 0){
                    D_password += now_char;
                }
            }
            else if(Character.compare(now_char, next_char) !=0 ){
                if(Character.compare(before, now_char) !=0 ){
                    D_password += now_char;
                }
            }else{
                check = true;
            }
            before = now_char;
        }

        if(check){
            D_password = Decode(D_password);
        }
        return D_password;
    }
    public static String solution(String cryptogram) {
        String answer = Decode(cryptogram);
        return answer;
    }
}
