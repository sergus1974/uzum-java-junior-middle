package org.uzum.iggytoto.javacore_reflection.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class HomeWork5 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        Class clazzCat = Cat.class;

        Class[] parameterType = {int.class};
        Object [] paramValues = {0};

        Constructor c1 = Cat.class.getConstructor(parameterType);
        Cat cat = (Cat) c1.newInstance(paramValues);

        Field[] fields = clazzCat.getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("name"))
                field.set(cat, "Small cat");
            else if (field.getName().equals("age"))
                field.set(cat, 10);
            else if (field.getName().equals("feet"))
                    field.set(cat, 6);

            System.out.println(field.getName() + ":" + field.get(cat).toString());

        }

    }
}
