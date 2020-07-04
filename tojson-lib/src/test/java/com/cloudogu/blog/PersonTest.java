package com.cloudogu.blog;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import java.io.IOException;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

public class PersonTest {


    @Test
    public void classPath_default() throws IOException {
        Compilation compilation = javac()
                .withClasspathFrom(JsonObject.class.getClassLoader())
                .withOptions()
                .withProcessors(new ToJsonProcessor())
                .compile(
                        JavaFileObjects.forResource("Person.java"));
        assertThat(compilation).succeeded();
    }
}
