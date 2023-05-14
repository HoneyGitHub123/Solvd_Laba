package Reflections;

import com.airport1.airportsystem.AirEmployees;
import com.airport1.airportsystem.AirportSystem;
import com.airport1.airportsystem.Luggage;

import java.lang.reflect.*;

public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = Class.forName("com.airport1.airportsystem.AirEmployees");
        System.out.println("Name of the class using forName:" + c);
        System.out.println();

        //Using .class
        Class c1 = AirEmployees.class;
        System.out.println("Name of the class using . class:" + c1);
        System.out.println();

        AirEmployees obj = new AirEmployees("Maria", "1458", "Cabin Crew", "Associate", 40);
        Class c2 = obj.getClass();
        System.out.println("Name of the class using .getClass:" + c2);
        System.out.println();

        //To get access modifier of the class
        int modifier = c2.getModifiers();
        System.out.println("Modifier of the class:" + Modifier.toString(modifier));
        Field[] field = c.getDeclaredFields();

        //To get fields Name,its datatype and modifier
        for (Field fd : field) {
            System.out.println();
            System.out.println("Name of the field:" + fd.getName());
            int modifiers2 = fd.getModifiers();
            System.out.println("Field Modifier:" + Modifier.toString(modifiers2));
            System.out.println("Field Type:" + fd.getType());
            System.out.println("*****************************");


        }


        //To get all the methods,its modifier,parameters and return types
        Method[] methods = c2.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println();
            System.out.println("Method Name:" + m.getName());
            int modifiers = m.getModifiers();
            System.out.println("Method Modifier:" + Modifier.toString(modifiers));
            System.out.println("ReturnType of method:" + m.getReturnType());
            Class[] parameters = m.getParameterTypes();
            for (Class param : parameters) {
                System.out.println("Parameter type of the method:" + param.getName());
            }
            System.out.println("*****************************");


        }

        //To get all the constructors,its modifier and parameters
        Constructor[] constructor = c.getConstructors();
        for (Constructor con : constructor) {
            System.out.println("Constructor Name:" + con.getName());
            int modifiers3 = con.getModifiers();
            System.out.println("Field Modifier:" + Modifier.toString(modifiers3));
            Class[] parameter = con.getParameterTypes();
            for (Class param1 : parameter) {
                System.out.println("Parameter type of the constructor:" + param1.getName());
            }
            System.out.println("*****************************");

        }

        //To invoke a method using reflection
        Method testMethod = c.getMethod("getHourlyRate");
        double rate = (double) testMethod.invoke(new AirEmployees("Anna", "1460", "Cabin Crew", "Associate", 20));
        System.out.println(rate);
    }
}
