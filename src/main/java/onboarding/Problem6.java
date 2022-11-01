package onboarding;

import ExceptionValidation.P6ExceptionValidation;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collection.*;
import static java.util.Collections.sort;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        for(List<String> form: forms){
            String email = form.get(0);
            String userName = form.get(1);
            if(!(P6ExceptionValidation.p6ExceptionValidation(email, userName))){
                return Collections.emptyList();
            }
        }
    }

}

