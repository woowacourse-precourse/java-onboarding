package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = checkAfterChar(cryptogram);
        return answer;
    }

    public static String checkAfterChar(String cryptogram) {


        ArrayList<String> deleteList = new ArrayList<>();
        while (true){

        findDeleteList(cryptogram, deleteList);
        if(cryptogram==""||deleteList.isEmpty()){
        return cryptogram;
        }
//        cryptogram = afterDeleteCryptogram(cryptogram, deleteList);
        deleteList.clear();
        }
    }
//
//    private static String afterDeleteCryptogram(String cryptogram, ArrayList<String> deleteList) {
//        for (int i = 0; i < deleteList.size(); i++) {
//            cryptogram = cryptogram.replace(deleteList.get(i),"");
//        }
//        return cryptogram;
//    }

    /**
     * 연속되는 문자열을 찾아서 미리 만들어둔 deleteList로 반환하는 함수
     */
    private static void findDeleteList(String cryptogram, ArrayList<String> deleteList) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                String deleteString = cryptogram.charAt(i) + "" + cryptogram.charAt(i + 1);
                deleteList.add(deleteString);
            }
        }

    }
}
