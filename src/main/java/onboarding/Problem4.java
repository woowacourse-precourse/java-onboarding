import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public String solution(String word){
        String result = "";

        String[] array_word;
        String[] change_word = {"Z","Y","X","W","V","U","T","S","R","Q","P"
                ,"O","N","M","L","K","J","I","H","G","F","E","D","C","B","A"};

        Map<String, String> Eng = new HashMap<>();

        char[] English = new char[26];

        for (int i = 0; i <English.length;i++){
            Eng.put(Character.toString((char) ('A' + i)), change_word[i]);
        }
        array_word = word.split("");

        for(String c_word : array_word){
            boolean is_upp = Character.isUpperCase(c_word.charAt(0));//대소문자 확인

            String temp_result = Eng.get(c_word.toUpperCase());
            if (temp_result == null){// null or 공백 특수문자일때
                temp_result = " ";
            } else if (!is_upp) {//소문자
                temp_result = temp_result.toLowerCase();

            }
            result = result.concat(temp_result);
        }
        return result;
    }

    public static void main(String[] args){
        Problem4 a= new Problem4();
        System.out.println(a.solution(("I love you")));
    }



}
