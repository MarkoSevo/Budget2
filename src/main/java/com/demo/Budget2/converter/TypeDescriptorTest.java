package com.demo.Budget2.converter;

import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.Property;
import org.springframework.core.convert.TypeDescriptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TypeDescriptorTest extends TypeDescriptor {
    public TypeDescriptorTest(MethodParameter methodParameter) {
        super(methodParameter);
    }

    public TypeDescriptorTest(Field field) {
        super(field);
    }

    public TypeDescriptorTest(Property property) {
        super(property);
    }

    protected TypeDescriptorTest(ResolvableType resolvableType, Class<?> type, Annotation[] annotations) {
        super(resolvableType, type, annotations);
    }
}
