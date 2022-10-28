package onboarding;

import onboarding.problem4.AlphabetDictionary;
import onboarding.problem4.Dictionary;
import onboarding.problem4.TreeFrog;

public class Problem4 {
    public static String solution(String word) {
        final Character[] characterMappingTable = {'Z','Y','X','W','V','U'
            ,'T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C'
            ,'B','A',null,null,null,null,null,null,'z','y','x','w','v','u','t','s'
            ,'r','q','p','o','n','m','l','k','j','i','h', 'g','f','e','d','c','b','a'};

        Dictionary dictionary = new AlphabetDictionary(characterMappingTable);
        TreeFrog treeFrog = new TreeFrog(dictionary);
        return treeFrog.makeTreeFrogWord(word);
    }
}
