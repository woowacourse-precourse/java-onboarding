package onboarding.problem6.service;

import onboarding.problem6.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NicknameListService {
    public static ArrayList<String> crewIndexToCrewEmail(List<List<String>> form, ArrayList<Integer> crewIndexList){
        ArrayList<String> crewEmailList = new ArrayList<>();
        for(int crewIndex: crewIndexList){
            crewEmailList.add(form.get(crewIndex).get(Constants.CERW_EMAIL));
        }
        sortEmailAscending(crewEmailList);
        return crewEmailList;
    }

    public static String getNicknameFromList(List<String> crewForm){
        return crewForm.get(Constants.CREW_NICNAME);
    }
    public static void addNewNicknameToList(ArrayList<Integer> crewIndexList, int crewIndex){
        if(!isNicknameInList(crewIndexList, crewIndex)){
            crewIndexList.add(crewIndex);
        }
    }
    public static boolean checkOneWordNickname(String nickname){
        return (nickname.length()==1);
    }
    private static void sortEmailAscending(ArrayList<String> emailList){
        Collections.sort(emailList);
    }

    private static boolean isNicknameInList(ArrayList<Integer> crewIndexList, int crewIndex){
        return crewIndexList.contains(crewIndex);
    }
}
