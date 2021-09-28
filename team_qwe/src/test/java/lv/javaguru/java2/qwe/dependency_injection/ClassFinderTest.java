package lv.javaguru.java2.qwe.dependency_injection;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ClassFinderTest {

    @Test
    public void test() throws IOException {
        ClassFinder classFinder = new ClassFinder();
        List<Class<?>> classes = classFinder.findClassesInsidePackage();
        classes.forEach(aClass -> System.out.println(aClass.getName()));
    }

}