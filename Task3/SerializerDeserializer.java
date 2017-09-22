package Task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class SerializerDeserializer {

    public static String serialize(Object object) {
        Class<?> objectClass = object.getClass();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(objectClass.getName());

        for (Field field : objectClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Save.class)) {

                stringBuilder.append("\r\n");

                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }

                stringBuilder.append(field.getName()).append(" : ");

                try {
                    if (field.getType() == int.class) {
                        stringBuilder.append(field.getInt(object));
                    } else if (field.getType() == String.class) {
                        stringBuilder.append(field.get(object));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();

                }
            }
        }

        return stringBuilder.toString();
    }

    public static Object deserializer(String className, ArrayList<String> lines) {
        Object object = null;
        try {
            Class<?> objectClass = Class.forName(className);
            Constructor constructor = objectClass.getConstructor();
            object = constructor.newInstance();

            System.out.println("Created class: " + object.getClass().getSimpleName());

            for (String line : lines) {
                String[] raw = line.split(":");
                if (raw.length <= 2) {
                    String fieldName = raw[0].replaceAll("\\s+$", "");
                    String fieldValue = raw[1];
                    String outputString = fieldName;

                    Field field = objectClass.getDeclaredField(fieldName);
                    if (Modifier.isPrivate(field.getModifiers())) {
                        field.setAccessible(true);
                        outputString += " is private";
                    } else outputString += " is public";

                    if (field.getType() == int.class) {
                        field.setInt(object, Integer.parseInt(fieldValue));
                    } else if (field.getType() == String.class) {
                        field.set(object, fieldValue);
                    }

                    outputString += ", type = " + field.getType().getSimpleName() + ", value = " + fieldValue;

                    System.out.println(outputString);
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return object;
    }
}
