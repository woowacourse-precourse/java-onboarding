package onboarding.problem6.service;

import java.util.ArrayList;

public class NicknameListService {
    public static boolean isNicknameInList(ArrayList<Integer> crewIndexList, int crewIndex){
        return crewIndexList.contains(crewIndex);
    }

}
