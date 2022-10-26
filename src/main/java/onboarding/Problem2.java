package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] charArr = cryptogram.toCharArray();
        boolean flag = false;

         do {
            flag = false;
            for (int i = 1; i < charArr.length; i++) {
                if (charArr[i] == charArr[i - 1]) {
                    charArr = remove(charArr, i);
                    charArr = remove(charArr, i - 1);
                    flag = true; // remove 가 발생했으면 flag 에 true 대입
                }
            }
        } while (flag == true); // 더이상 remove 가 발생하지 않으면 반복문 종료

        return new String(charArr);
    }

    /**
     * char 배열을 리스트로 변경하고, 인자로 전달된 index를 제거한다. 그리고 리스트를 배열로 변경해 리턴한다.
     * @param arr
     * @param index
     * @return
     */
    private static char[] remove(char[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        // char array -> char list 변환
        ArrayList<Character> charList = arrToList(arr);
        charList.remove(index);
        return listToArr(charList);
    }

    /**
     * char array 를 char list 로 변환하는 메서드
     * @param charArr
     * @return
     */
    private static ArrayList<Character> arrToList(char[] charArr) {
        // char array -> string 변환
        String s = new String(charArr);

        // string -> list 변환
        ArrayList<Character> charList = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }

        return charList;
    }

    /**
     * char list 를 char array 로 변환하는 메서드
     * @param charList
     * @return
     */
    private static char[] listToArr(ArrayList<Character> charList) {
        char[] result = new char[charList.size()];
        for (int i = 0; i < charList.size(); i++) {
            result[i] = charList.get(i);
        }

        return result;
    }

}
