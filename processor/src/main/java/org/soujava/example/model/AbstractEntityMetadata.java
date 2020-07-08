package org.soujava.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class AbstractEntityMetadata implements EntityMetadata {

    private final List<FieldMetadata> fields;

    public AbstractEntityMetadata() {
        this.fields = new ArrayList<>();
    }

    @Override
    public Class<?> getClassInstance() {
        return null;
    }

    @Override
    public List<FieldMetadata> getFields() {
        return Collections.unmodifiableList(fields);
    }

    @Override
    public <T> T newInstance() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getFieldsName() {
        return getFields().stream()
                .map(FieldMetadata::getFieldName)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    @Override
    public String getColumnField(String javaField) {
        Objects.requireNonNull(javaField, "javaField is required");
        return getFields().stream()
                .filter(f -> javaField.equals(f.getFieldName()))
                .map(FieldMetadata::getName)
                .findFirst().orElse(javaField);
    }

    @Override
    public Optional<FieldMetadata> getFieldMapping(String javaField) {
        Objects.requireNonNull(javaField, "javaField is required");
        return getFields().stream()
                .filter(f -> javaField.equals(f.getFieldName()))
                .findFirst();
    }

    @Override
    public Map<String, FieldMetadata> getFieldsGroupByName() {
        return getFields().stream()
                .collect(toMap(FieldMetadata::getName, identity()));
    }

    @Override
    public Optional<FieldMetadata> getId() {
        return getFields().stream()
                .filter(FieldMetadata::isId)
                .findFirst();
    }
}
