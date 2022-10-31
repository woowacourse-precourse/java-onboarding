package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int dup_index = 0;
        if(!err_check(cryptogram)) return "Error\n";
        while(true){
            //if duplicated index doesn't exist, return remain cryptogram string
            if((dup_index = Dup_Index(cryptogram)) < 0) break;
            cryptogram = Dup_Delete(cryptogram, dup_index);
        }
        return cryptogram;
    }

    private static boolean err_check(String s){
        //first constraint
        if(s.length() < 1 || s.length() > 1000) return false;
        //second constraint
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) < 97 || s.charAt(i) > 122) return false;
        return true;
    }

    private static String Dup_Delete(String s, int index){
        String before = s.substring(0, index);
        String after = s.substring(index + 2);
        String new_cryptogram = before + after;
        return new_cryptogram;
    }

    private static int Dup_Index(String s){
        for(int i=0;i<s.length() - 1;i++){
            //if two close characters are same, return for delete
            if(s.charAt(i) == s.charAt(i+1)) return i;
        }
        return -1;
    }
}
