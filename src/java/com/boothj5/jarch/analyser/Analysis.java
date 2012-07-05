package com.boothj5.jarch.analyser;

import java.util.ArrayList;
import java.util.List;

import com.boothj5.jarch.configuration.ImportSpec;

public class Analysis {
    private final List<ImportSpec> importViolations;
    private final List<RuleSetResult> ruleSetResults;
    private int numImportViolations;
    private int numModuleErrors;
    private int numLayerErrors;

    public Analysis() {
        this.numImportViolations = 0;
        this.numModuleErrors = 0;
        this.numLayerErrors = 0;
        this.importViolations = new ArrayList<ImportSpec>();
        this.ruleSetResults = new ArrayList<RuleSetResult>();
    }
    
    public void addImportViolation(ImportSpec violation) {
        importViolations.add(violation);
        numImportViolations++;
    }
    
    public void addRuleSetResult(RuleSetResult result) {
        ruleSetResults.add(result);
    }
    
    public void addNumModuleErrors(int num) {
        numModuleErrors += num;
    }
    
    public void addNumLayerErrors(int num) {
        numLayerErrors += num;
    }
    
    public List<ImportSpec> getImportViolations() {
        return importViolations;
    }
    
    public List<RuleSetResult> getRuleSetResults() {
        return ruleSetResults;
    }

    public int getNumImportViolations() {
        return numImportViolations;
    }

    public int getNumModuleErrors() {
        return numModuleErrors;
    }

    public int getNumLayerErrors() {
        return numLayerErrors;
    }
}
