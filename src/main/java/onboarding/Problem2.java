package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        ArrayList<String> word;
        word = convertToList(cryptogram);

        int index = -2;
        while(index != -1){
            index = isDuplicated(word);
            if(index == -1){
                break;
            }
            word = removeLetter(word, index);

        }
        answer = convertToString(word);
        return answer;
    }
    // 중복 문자열 있는 지 확인
    public static int isDuplicated(ArrayList<String> word){
        for(int i = 0; i<word.size()-1; i++){
            if(word.get(i).equals(word.get(i+1))){
                return i;
            }
        }
        return -1;
    }
    // 중복 문자열 삭제
    public static ArrayList<String> removeLetter(ArrayList<String> word, int index){
        word.remove(index);
        word.remove(index);

        return word;
    }
    // string -> arrayList로 변환
    public static ArrayList<String> convertToList(String word){
        String[] wordSplit = word.split("");
        ArrayList<String> convertedList = new ArrayList<String>(Arrays.asList(wordSplit));
        return convertedList;
    }
    // arrayList -> String로 변환
    public static String convertToString(ArrayList<String> word){
        String str = "";
        for(String letter: word){
            str += letter;
        }
        return str;
    }
}
