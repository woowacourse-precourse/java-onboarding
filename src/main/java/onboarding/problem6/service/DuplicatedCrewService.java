package onboarding.problem6.service;

import onboarding.problem6.utils.Constants;

import java.util.ArrayList;

public class DuplicatedCrewService {
    public static boolean isDuplicatedWord(String duplicateWord, String word){
        return word.contains(duplicateWord);
    }
    public static void addDuplicatedCrewIndex(ArrayList<Integer> crewIndexList, String checkWord, String nickname, int crewIndex, int currentCrewIndex){
        if(isDuplicatedWord(checkWord, nickname)){
            NicknameListService.addNewNicknameToList(crewIndexList, crewIndex);
            NicknameListService.addNewNicknameToList(crewIndexList, currentCrewIndex);
        }
    }

    public static String getSubString(String word, int from){
        return word.substring(from, from + Constants.LEAST_DUPLICATED_WORD_LENGTH);
    }
}
