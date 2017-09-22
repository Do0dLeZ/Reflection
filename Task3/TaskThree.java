package Task3;

import java.io.*;
import java.util.ArrayList;

public class TaskThree {
    private static final String filePath = "d:\\configurationFile.txt";

    public static void serialize() {
        TestClass testClass = new TestClass();
        testClass.setParameterOne("changed");
        testClass.setParameterTwo("Hello world");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {

            String serializedString = SerializerDeserializer.serialize(testClass);
            bufferedWriter.write(serializedString);

            System.out.println("\nSerialized into '" + filePath
                    + "' with data : "
                    + "\n---------------------------------- \n"
                    + serializedString
                    + "\n----------------------------------\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(Class requiredClass) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String className = bufferedReader.readLine();

            String line;
            ArrayList<String> parametersAndValues = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                parametersAndValues.add(line);
            }
            System.out.println("Deserialize:");

            Object object = SerializerDeserializer.deserializer(className, parametersAndValues);

            if (object.getClass().equals(requiredClass))
                System.out.println("IS required class");
            else
                System.out.println("Class is not required");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
