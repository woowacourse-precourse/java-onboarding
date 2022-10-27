package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return Problem2.analyze_cryptogram(cryptogram);
    }

    public static String analyze_cryptogram(String cryptogram) {
        String str = Problem2.str_search(cryptogram);
        while(str != null){
            cryptogram = str;
            str = Problem2.str_search(cryptogram);
        }
        return cryptogram;
    }
    public static String str_search(String str){
        int length = str.length();

        String result = null;
        for(int i = 0; i < length - 1; i++){
            char c = str.charAt(i);
            String substring = str.substring(i);

            //연속성 여부
            if(substring.charAt(0) != substring.charAt(1)){
                continue;
            }

            String fixed_substring = Problem2.delete_continuous(substring, c);
            str = str.substring(0, i) + fixed_substring;

            length = str.length();
            result = str;
        }
        return result;
    }


    public static String delete_continuous(String str, char c){
        int index = str.indexOf(c);
        while(index == 0){
            str = str.substring(1);
            index = str.indexOf(c);
        }
        return str;
    }
}
