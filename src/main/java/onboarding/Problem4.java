package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Problem4 {
    public static char[] SetAlphabet(){
        char[] alphabet = new char[26];
        for(int i =0;i < alphabet.length;i++){
            alphabet[i] = (char)('A'+i);
        }
        return alphabet;
    }//알파벳 배열에 집어넣기
    public static HashMap<Character,Character> SetMap(char[] alphabet){
        HashMap<Character,Character> map = new HashMap<Character,Character>();

        for(int i = 0;i<alphabet.length;i++){
            map.put(alphabet[i],alphabet[25-i]);
        }
        return map;
    }

    public static String ReturnSentence(List<Character> list){
        String result = "";
        for(int i = 0;i<list.size();i++) {
            result += Character.toString(list.get(i));//char 배열을 문자열로 만들어준다.
        }
        return result;
    }

    public static List<Character>  ReturnBigLetter(char[] result){
        List<Character> list = new ArrayList<>();
        for(int i = 0;i<result.length;i++) {
            if(Character.isUpperCase(result[i])){
                list.add(i,result[i]);
            }else if(Character.isLowerCase(result[i])) {
                list.add(i,Character.toUpperCase(result[i]));
            }
            else{
                list.add(i,' ');
            }
        }
        return list;
    }//hashmap에저장되어있는 알파벳이 대문자이기때문에 문자로받은값을 대문자로 다바꿔준다.

    public static List<Character> Encoding(List<Character> list,HashMap<Character,Character> map){
        List<Character> Big = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            if(list.get(i) == null){

                Big.add(i,' ');
            }
            else {
                Big.add(i, map.get(list.get(i)));
            }
        }
        return Big;
    }

    public static List<Character> SmallToSmall(char[] result,List<Character> Big){
        List<Character> Final = new ArrayList<>();
        for(int i = 0;i<result.length;i++){
            if(Character.isLowerCase(result[i])){
                Final.add(i,Character.toLowerCase(Big.get(i)));
            }else if(Big.get(i) == null){
                ;
                Final.add(i,' ');
            }
            else{
                Final.add(i,Big.get(i));
            }
        }
        return Final;
    }


    public static String solution(String word) {

        char[] result = word.toCharArray();//문자열을 char배열로 바꾼다
        char[] alphabet = SetAlphabet();//알파벳 배열에담기

        HashMap<Character,Character> map = SetMap(alphabet);
        List<Character>  list = ReturnBigLetter(result);

        List<Character> Big = Encoding(list,map);
        List<Character> Final = SmallToSmall(result,Big);

        String Finish = ReturnSentence(Final);
        return Finish;
    }

}
