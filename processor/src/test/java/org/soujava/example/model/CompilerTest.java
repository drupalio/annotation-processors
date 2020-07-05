package org.soujava.example.model;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.tools.JavaFileObject;
import java.io.IOException;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

public class CompilerTest {


    @Test
    public void shouldCompile() throws IOException {

        final JavaFileObject javaFileObject = JavaFileObjects.forResource("Person.java");

        Compilation compilation = javac()
                .withClasspathFrom(Entity.class.getClassLoader())
                .withOptions()
                .withProcessors(new EntityProcessor())
                .compile(javaFileObject);
        assertThat(compilation).succeeded();
    }

    @Test
    public void shouldReturnConstructorIssue() throws IOException {
        final JavaFileObject javaFileObject = JavaFileObjects.forResource("Person2.java");
        Assertions.assertThrows(RuntimeException.class, () ->
                javac()
                        .withClasspathFrom(Entity.class.getClassLoader())
                        .withOptions()
                        .withProcessors(new EntityProcessor())
                        .compile(javaFileObject));
    }

    @Test
    public void shouldCheckColumnCompile() {

        final JavaFileObject javaFileObject = JavaFileObjects.forResource("Person3.java");

        Compilation compilation = javac()
                .withClasspathFrom(Entity.class.getClassLoader())
                .withOptions()
                .withProcessors(new EntityProcessor())
                .compile(javaFileObject);
        assertThat(compilation).succeeded();
    }

    @Test
    public void shouldUseDefaultMethod() {

        final JavaFileObject javaFileObject = JavaFileObjects.forResource("Person5.java");

        Compilation compilation = javac()
                .withClasspathFrom(Entity.class.getClassLoader())
                .withOptions()
                .withProcessors(new EntityProcessor())
                .compile(javaFileObject);
        assertThat(compilation).succeeded();
    }

    @Test
    public void shouldReturnAccessorIssue()  {
        final JavaFileObject javaFileObject = JavaFileObjects.forResource("Person4.java");
        Assertions.assertThrows(RuntimeException.class, () ->
                javac()
                        .withClasspathFrom(Entity.class.getClassLoader())
                        .withOptions()
                        .withProcessors(new EntityProcessor())
                        .compile(javaFileObject));
    }
}
