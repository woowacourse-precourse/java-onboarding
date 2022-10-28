package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        try {
            strcheck(cryptogram);
            while(check(cryptogram)){
                answer = step1(cryptogram);
            }
        }catch (StringIndexOutOfBoundsException r){
            r.printStackTrace();
        }

        return answer;
    }

    public static String step1(String str){
        start(str);
        end(str);
        delete(str);
        return str;
    }

    public static boolean check(String str){
        return start(str) == 0;
    }

    public static int start(String str){
        int start = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i+1)){
                start = i;

            }
        }
        return start;
    }

    public static int end(String str){
        int end = 0;
        int count = 0;

        for(int i = start(str); i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i+1)){
                end += (i+1);
                count++;
            }
        }
        return end;
    }

    public static String delete(String str){
        String delete = str.substring(start(str),end(str));
        str = str.replaceFirst(delete,"");
        return str;
    }

    public static void strcheck(String  str){
        if(str.length()<1 || str.length()>1000){
            throw new RuntimeException();
        }
    }

}
