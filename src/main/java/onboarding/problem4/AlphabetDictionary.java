package onboarding.problem4;

public class AlphabetDictionary implements Dictionary {

    private final Character[] characterMappingTable;

    public AlphabetDictionary(Character[] characterMappingTable) {
        this.characterMappingTable = characterMappingTable;
    }

    @Override
    public Character change(Character alphabet) {
        if(alphabet == ' ') return alphabet;
        return this.characterMappingTable[alphabet - 'A'];
    }
}
