package onboarding.problem2.service;

import java.util.ArrayList;

public class DuplicatedCharService {

    //문자열을 받고 중복된 문자가 나오는 위치를 담은 ArrayList 를 반환한다.
    public static ArrayList<int[]> getDuplicatedCharPositionList(String word){
        ArrayList<int[]> duplicatedCharPositionList = new ArrayList<int[]>();
        //추후 함수를 단독으로 사용했을 경우를 대비하여 if 조건문 작성
        if(!isDuplicatedChar(word)){
            return duplicatedCharPositionList;
        }
        for(int index = 0; index<word.length(); index++){
            int [] continuedCharPosition = getDuplicatedCharPosition(index, word);

            if(notNullPositionCheck(continuedCharPosition)){
                index = (continuedCharPosition[1]);
                duplicatedCharPositionList.add(continuedCharPosition);
            }
        }
        return duplicatedCharPositionList;
    }

    private static boolean checkDecryption(String word){
        if(word.length() != 0){
            return isDuplicatedChar(word);
        }
        return false;
    }

    // 문자열 안에 중복된 부분이 있는지 검사
    private static boolean isDuplicatedChar(String word){
        char checkChar = word.charAt(0);
        for(int index = 1; index < word.length(); index++){
            if(compareWord(checkChar, word.charAt(index))){
                return true;
            }
            checkChar = word.charAt(index);
        }
        return false;
    }

    private static boolean compareWord(char c1, char c2){
        return (c1 == c2);
    }

    private static boolean notNullPositionCheck(int[] position){
        return position != null;
    }

    private static int[] getDuplicatedCharPosition(int start, String word){
        char checkChar = word.charAt(start);
        int[] position = null;

        for(int index = (start+1); index < word.length(); index++){
            if(!compareWord(checkChar, word.charAt(index))){
                break;
            }
            position = updatePosition(position, start, index);
        }
        return position;
    }

    private static int[] updatePosition(int [] position, int start, int index){
        if(position == null){
            position = new int[]{start, index};
        }
        position[1] = index;

        return position;
    }
}
