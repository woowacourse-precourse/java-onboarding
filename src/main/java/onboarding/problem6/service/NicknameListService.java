package onboarding.problem6.service;

import java.util.ArrayList;

public class NicknameListService {
    public static void addDuplicatedCrewIndex(ArrayList<Integer> crewIndexList, String checkWord, String nickname, int crewIndex, int currentCrewIndex){
        if(DuplicatedWordService.isDuplicatedWord(checkWord, nickname)){
            addNewNicknameToList(crewIndexList, crewIndex);
            addNewNicknameToList(crewIndexList, currentCrewIndex);
        }
    }
    private static void addNewNicknameToList(ArrayList<Integer> crewIndexList, int crewIndex){
        if(!isNicknameInList(crewIndexList, crewIndex)){
            crewIndexList.add(crewIndex);
        }
    }
    private static boolean isNicknameInList(ArrayList<Integer> crewIndexList, int crewIndex){
        return crewIndexList.contains(crewIndex);
    }


}
