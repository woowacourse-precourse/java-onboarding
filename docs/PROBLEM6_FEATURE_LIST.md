## 슈도 코드

```
problem6(list<list<string>> forms){
    // parsing emails, nicknames
    emails = getEmailsFromForms(forms);
    nicknames = getNicknamesFromForms(forms);
    // get duplicated substrings of nickname length 2
    duplicated = getDuplicatedSubstringSet(nicknames);
    ans = []
    // of all nicknames
    for(int i in nicknames.size()){
        // of all substrings
        for(int j in nicknames.size() - 1){
            nickname = nicknames[i];
            nicknameSubstring = substring(nickname, j, 2);
            // if substring is in duplicated
            if(nicknameSubstring in duplicated){
                // add that user's email
                ans.add(emails[i]);
            } 
        }
    }
    return ans;
}
```

## 기능 요구 사항
- ~~주어진 List<List<String>> forms에서 email list를 얻어내는 List<String> getEmailsFromForms(forms)~~
- ~~주어진 List<List<String>> forms에서 nickname list를 얻어내는 List<String> getNicknamesFromForms(forms)~~
- ~~주어진 List<String> nicknames에서 중복된 substring set을 반환하는 Set<String> getDuplicatedSubstringSet(nicknames)~~
- ~~중복된 닉네임 substring을 사용하는 유저를 찾아 그 이메일을 모두 찾는 로직~~

TODO
- ~~테스트 확인~~
- ~~상수화~~