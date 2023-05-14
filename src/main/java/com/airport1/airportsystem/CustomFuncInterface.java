package com.airport1.airportsystem;

//Custom Functional Interface with generics
@FunctionalInterface
interface CustomFuncInterface<T, E> {
    E action(T t);
}
