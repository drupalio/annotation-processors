package org.soujava.metadata.compiler;

import java.util.List;

class EntityMetadata {

    private final Class<?> type;

    private final InstanceSupplier supplier;

    private final List<FieldMetadata> fields;

    EntityMetadata(Class<?> type, InstanceSupplier supplier, List<FieldMetadata> fields) {
        this.type = type;
        this.supplier = supplier;
        this.fields = fields;
    }


    public Class<?> getType() {
        return type;
    }

    public InstanceSupplier getSupplier() {
        return supplier;
    }

    public List<FieldMetadata> getFields() {
        return fields;
    }
}