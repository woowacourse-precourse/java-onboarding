package onboarding.problem6.service;

import java.util.ArrayList;

public class NicknameListService {
    public static void addNewNicknameToList(ArrayList<Integer> crewIndexList, int crewIndex){
        if(!isNicknameInList(crewIndexList, crewIndex)){
            crewIndexList.add(crewIndex);
        }
    }
    private static boolean isNicknameInList(ArrayList<Integer> crewIndexList, int crewIndex){
        return crewIndexList.contains(crewIndex);
    }

}
