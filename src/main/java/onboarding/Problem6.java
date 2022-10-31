package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	
    	Map<String, List<String>> twoLengthNikAndIds = new HashMap<>();
    	Set<String> idAboutDuplicateNik = new HashSet<>();
    	String[][] idAndNikNamesForm = new String[forms.size()][2];
    	
    	makeIdAndNikNameForm(idAndNikNamesForm, forms);
    	putTwoLengthNikAndIds(idAndNikNamesForm, twoLengthNikAndIds);
    	addIdAboutDuplicateNikName(twoLengthNikAndIds, idAboutDuplicateNik);
    	List<String> finalNik = new ArrayList<>(idAboutDuplicateNik);
    	makeEmailForm(finalNik);
    	sortAscending(finalNik);
    	
        return finalNik;
    }
	private static void makeIdAndNikNameForm(String[][] newForms, List<List<String>> forms) {
    	String[] iDAndEmailForm = null;
    	String nikName = null;
    	int idx = 0;
    	for(List<String> form: forms) {
    		iDAndEmailForm = form.get(0).split("@");
    		nikName = form.get(1);
    		newForms[idx][0] = iDAndEmailForm[0];
    		newForms[idx][1] = nikName;
    		idx += 1;
    	}
    }
    private static void putTwoLengthNikAndIds(String[][] form, Map<String, List<String>> twoLengthNikAndIds) {
    	String emailId = null;
    	String nikName = null;
    	String twoLengthNikName = null;
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<form.length; i++) {
    		emailId = form[i][0];
    		nikName = form[i][1];
    		for(int p1=0, p2=1; p2<nikName.length(); p1++, p2++) {
    			sb.append(nikName.charAt(p1));
    			sb.append(nikName.charAt(p2));
    			twoLengthNikName = sb.toString();
    			
    			if(!twoLengthNikAndIds.containsKey(twoLengthNikName)) {
        			twoLengthNikAndIds.put(twoLengthNikName.toString(), new ArrayList<>());    				
    			}
    			twoLengthNikAndIds.get(twoLengthNikName).add(emailId);
        		sb.setLength(0);
    		}
    	}
    }
    private static void addIdAboutDuplicateNikName(Map<String, List<String>> twoLengthNikAndIds, Set<String> idAboutDuplicateNik) {
    	
    	for(List<String> ids: twoLengthNikAndIds.values()) {
    		if(ids.size() < 2) {
    			continue;
    		}
    		for(String id: ids) {
    			idAboutDuplicateNik.add(id);
    		}
    	}
    }
    private static void sortAscending(List<String> finalNik) {
    	Collections.sort(finalNik);
	}
    private static void makeEmailForm(List<String> nikList) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<nikList.size(); i++) {
    		sb.append(nikList.get(i));
    		sb.append("@email.com");
    		nikList.set(i, sb.toString());
    		sb.setLength(0);
    	}
    }
}

