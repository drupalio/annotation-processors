package org.soujava.metadata.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.soujava.medatadata.api.Mapper;

import java.util.HashMap;
import java.util.Map;

public class ReflectionMapperTest {

    private Mapper mapper;

    @BeforeEach
    public void setUp() {
        this.mapper = new ReflectionMapper();
    }

    @Test
    public void shouldCreateMap() {
        Animal animal = new Animal("id", "lion");
        final Map<String, Object> map = mapper.toMap(animal);
        Assertions.assertEquals("animal", map.get("entity"));
        Assertions.assertEquals("id", map.get("id"));
        Assertions.assertEquals("lion", map.get("native_name"));
    }

    @Test
    public void shouldCreateEntity() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "id");
        map.put("native_name", "lion");

        final Animal animal = mapper.toEntity(map, Animal.class);
        Assertions.assertEquals("id", animal.getId());
        Assertions.assertEquals("lion", animal.getName());
    }
}
