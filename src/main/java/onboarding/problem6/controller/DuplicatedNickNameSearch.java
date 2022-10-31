package onboarding.problem6.controller;

import onboarding.problem6.service.DuplicatedCrewService;
import onboarding.problem6.service.NicknameListService;

import java.util.ArrayList;
import java.util.List;

public class DuplicatedNickNameSearch {
    private List<List<String>> forms;
    private ArrayList<Integer> duplicatedCrewsIndex;
    private List<String> duplicatedCrewsEmail;

    public DuplicatedNickNameSearch setNewForms(List<List<String>> forms){
        this.forms = forms;
        return this;
    }
    public void checkCrewForm(int crewIndex){
        String currentCrewNickname= NicknameListService.getNicknameFromList(forms.get(crewIndex));
        for(int index = 0; index<currentCrewNickname.length()-1; index++){
            addDuplicatedCrew(DuplicatedCrewService.getSubString(currentCrewNickname, index), crewIndex);
        }
    }

    private void addDuplicatedCrew(String duplicatedWord, int currentCrewIndex){
        for(int checkCrewIndex = currentCrewIndex+1; currentCrewIndex<forms.size(); checkCrewIndex++){
            String checkCrewNickname = NicknameListService.getNicknameFromList(forms.get(checkCrewIndex));
            DuplicatedCrewService.addDuplicatedCrewIndex(duplicatedCrewsIndex, duplicatedWord, checkCrewNickname, checkCrewIndex, currentCrewIndex);
        }
    }
}
