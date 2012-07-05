package com.boothj5.jarch.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JArchConfigCreator {

    private static JArchConfig createConfig(String basePackage, ImportSpec importSpec, String layerSpec, Layer layer1, Layer layer2, 
            Module module1, Module module2) {
        RuleSet ruleSet = RuleSetCreator.createRuleSet(basePackage, module1, module2);
        LayerSpec spec = LayerSpecCreator.createLayerSpec(layerSpec, layer1, layer2);
        List<ImportSpec> importSpecs = Arrays.asList(importSpec);
        Map<String, LayerSpec> layerSpecs = new HashMap<String, LayerSpec>();
        layerSpecs.put(spec.getName(), spec);
        
        return new JArchConfig(importSpecs, layerSpecs, Arrays.asList(ruleSet));
    }
    
    public static JArchConfig createValidConfig() {
        ImportSpec importSpec = new ImportSpec("test-import", "some.package.class", "some.other.package.class");
        Layer controller = new Layer("controller", Arrays.asList("service"));
        Layer service = new Layer("service", new ArrayList<String>());
        Module common = new Module("common", null, new ArrayList<String>());
        Module thing = new Module("thing", "spring", Arrays.asList("common"));

        return createConfig("com.boothj5.jarch", importSpec, "spring", controller, service, common, thing);
    }
    
    public static JArchConfig createConfigWithInvalidLayerSpec() {
        ImportSpec importSpec = new ImportSpec("test-import", "some.package.class", "some.other.package.class");
        Layer controller = new Layer("controller", Arrays.asList("service", "whoops"));
        Layer service = new Layer("service", new ArrayList<String>());
        Module common = new Module("common", null, new ArrayList<String>());
        Module thing = new Module("thing", "spring", Arrays.asList("common"));
        
        return createConfig("com.boothj5.jarch", importSpec, "spring", controller, service, common, thing);
    }
    
    public static JArchConfig createConfigWithInvalidModuleLayerSpec() {
        ImportSpec importSpec = new ImportSpec("test-import", "some.package.class", "some.other.package.class");
        Layer controller = new Layer("controller", Arrays.asList("service"));
        Layer service = new Layer("service", new ArrayList<String>());
        Module common = new Module("common", "whoops", new ArrayList<String>());
        Module thing = new Module("thing", "spring", Arrays.asList("common"));
        
        return createConfig("com.boothj5.jarch", importSpec, "spring", controller, service, common, thing);
    }

    public static JArchConfig createConfigWithInvalidModuleDependency() {
        ImportSpec importSpec = new ImportSpec("test-import", "some.package.class", "some.other.package.class");
        Layer controller = new Layer("controller", Arrays.asList("service"));
        Layer service = new Layer("service", new ArrayList<String>());
        Module common = new Module("common", null, Arrays.asList("whoops"));
        Module thing = new Module("thing", "spring", Arrays.asList("common"));
        
        return createConfig("com.boothj5.jarch", importSpec, "spring", controller, service, common, thing);
    }

    public static JArchConfig createConfigWithCircularDependency() {
        ImportSpec importSpec = new ImportSpec("test-import", "some.package.class", "some.other.package.class");
        Layer controller = new Layer("controller", Arrays.asList("service"));
        Layer service = new Layer("service", new ArrayList<String>());
        Module common = new Module("common", null, Arrays.asList("thing"));
        Module thing = new Module("thing", "spring", Arrays.asList("common"));
        
        return createConfig("com.boothj5.jarch", importSpec, "spring", controller, service, common, thing);
    }
}
