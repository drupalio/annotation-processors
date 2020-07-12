package org.soujava.metadata.processor;

import java.util.List;

public class ClassMappingsModel {

    private final List<String> entities;

    public ClassMappingsModel(List<String> entities) {
        this.entities = entities;
    }

    public List<String> getEntities() {
        return entities;
    }

    public String getQualified() {
        return "org.soujava.metadata.processor.DefaultClassMappings";
    }
}