package com.ele.model;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Value.Style (
        defaultAsDefault = true,
        implementationNestedInBuilder = true,
        overshadowImplementation = true
)
public @interface EleImmutable { }
