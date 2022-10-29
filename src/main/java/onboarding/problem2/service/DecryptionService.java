package onboarding.problem2.service;

import onboarding.problem2.domain.DuplicateCryptedText;

import java.util.ArrayList;

public class DecryptionService {
    public static void decryption(DuplicateCryptedText cryptedText){

    }

    public static boolean checkDecryption(String word){
        if(word.length() != 0){
            return isConsecutiveChar(word);
        }
        return false;
    }

    // 문자열 안에 중복된 부분이 있는지 검사
    public static boolean isConsecutiveChar(String word){
        char checkChar = word.charAt(0);
        for(int index = 1; index < word.length(); index++){
            if(compareWord(checkChar, word.charAt(index))){
                return true;
            }
            checkChar = word.charAt(index);
        }
        return false;
    }

    public static boolean compareWord(char c1, char c2){
        return (c1 == c2);
    }

    public static boolean notNullPositionCheck(int[] position){
        return position != null;
    }

    public static int[] getContinuedCharPosition(int start, String word){
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

    public static int[] updatePosition(int [] position, int start, int index){
        if(position == null){
            position = new int[]{start, index};
        }
        position[1] = index;

        return position;
    }
}
