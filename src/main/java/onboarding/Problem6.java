package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
       Problem6 problem6= new Problem6();
       TypeChange typeChange = new TypeChange();

       List<String> answer = List.of("answer");
        Map<String,String> mapForms = typeChange.changeToMap(forms);
        Set<String> email = new HashSet<String>();
        
        for(String name:mapForms.keySet()) {
           if(problem6.hasOverlapChar(mapForms.keySet(),name)) email.add(mapForms.get(name));
       }//for       
        
        answer = new ArrayList<String>(email);
        answer.sort((email1,email2)-> email1.compareTo(email2));
        
        return answer;
    }// solution
    
    private boolean hasOverlapChar(Set<String> names,String name){
       for(String compareName:names) {
          if(compareName.equals(name)) continue;
          for(int nameIndex=0;nameIndex < name.length()-1;nameIndex++) {
        	  int overlapCharIndex = compareName.indexOf(name.charAt(nameIndex));
        	  if(-1 == overlapCharIndex) {nameIndex++; continue;}
        	  if(overlapCharIndex+1 == compareName.indexOf(name.charAt(nameIndex+1))) return true;
          }//while
       }//for 
       return false;
    }// overlapNameReturn
} // end class

class TypeChange {
   public Map<String,String> changeToMap (List<List<String>> forms){
      Map<String,String> mapForms = new HashMap<String, String>();
      for(List<String> userInformation :forms) {
         mapForms.put(userInformation.get(1),userInformation.get(0));
      }//for
      return mapForms;
   }// mapChange
}// end class