package com.boothj5.jarch.configuration;

public class ImportSpec {

    private final String name;
    private final String deny;
    private final String suggest;
    
    public ImportSpec(String name, String deny, String suggest) {
        this.name = name;
        this.deny = deny;
        this.suggest = suggest;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDeny() {
        return deny;
    }
    
    public String getSuggest() {
        return suggest;
    }
}
