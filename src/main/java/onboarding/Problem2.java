package onboarding;

import java.util.ArrayList;

//삭제할 리스트 생성
//문자열에서 삭제할 리스트를 찾아서 삭제해줌
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
        cryptogram = afterDeleteCryptogram(cryptogram, deleteList);
        deleteList.clear();
        }
    }

    /**
     *  삭제할 리스트와 문자열을 받아서 cryptogram을 변경하는 함수
     */
    private static String afterDeleteCryptogram(String cryptogram, ArrayList<String> deleteList) {
        for (int i = 0; i < deleteList.size(); i++) {
            cryptogram = cryptogram.replace(deleteList.get(i),"");
        }
        return cryptogram;
    }

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
