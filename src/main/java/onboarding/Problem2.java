package onboarding;

public class Problem2 {
    public static boolean b = true;

    public static String remove(String str){

        for(int i = 0 ; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                str = str.substring(0,i) + str.substring(i+2);
                b = true;
                System.out.println("str = " + str);
            }

        }
        return str;
    }
    public static String solution(String cryptogram) {


        while(b){
            b = false;
            cryptogram = remove(cryptogram);
        }
        b = true;
        String answer = cryptogram;
        return answer;
    }
}