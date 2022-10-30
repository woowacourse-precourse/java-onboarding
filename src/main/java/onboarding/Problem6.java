package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	
    	String[][] idAndNikNamesForm = new String[forms.size()][2];
    	makeIdAndNikNameForm(idAndNikNamesForm, forms);
    	
    	List<String> answer = null;
    	
        return answer;
    }
	public static void makeIdAndNikNameForm(String[][] newForms, List<List<String>> forms) {
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
}
