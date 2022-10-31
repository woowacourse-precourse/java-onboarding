package onboarding.problem6.service;

import onboarding.problem6.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class NicknameListService {

    public static String getNicknameFromList(List<String> crewForm){
        return crewForm.get(Constants.CREW_NICNAME);
    }
    public static void addNewNicknameToList(ArrayList<Integer> crewIndexList, int crewIndex){
        if(!isNicknameInList(crewIndexList, crewIndex)){
            crewIndexList.add(crewIndex);
        }
    }
    private static boolean isNicknameInList(ArrayList<Integer> crewIndexList, int crewIndex){
        return crewIndexList.contains(crewIndex);
    }



}
