package onboarding;

public class Problem2 {

    static String Decode(String password){
        boolean check = false;
        String D_password = "";
        char before = ' ';

        if(password.length()<=1){
            return password;
        }
        for(int i = 0 ; i < password.length() ; i++){
            if(i == password.length()-1){
                if(Character.compare(before, password.charAt(i)) != 0){
                    D_password += password.charAt(i);
                }
            }
            else if(Character.compare(password.charAt(i),password.charAt(i+1)) !=0 ){
                if(Character.compare(before, password.charAt(i)) !=0 ){
                    D_password += password.charAt(i);
                }
            }else{
                check = true;
            }
            before = password.charAt(i);
        }
//        for(int i = 1 ; i < password.length() ; i++){
//            if(Character.compare(before,password.charAt(i))==0){
//                check = true;
//                before = password.charAt(i);
//                if(i < password.length()-1) i++;
//            }else {
//                D_password = D_password + before;
//                before = password.charAt(i);
//            }
//            if(i == password.length() - 1) D_password = D_password + password.charAt(i);
//        }
        System.out.println(D_password);
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
