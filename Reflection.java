import Task1.TaskOne;
import Task3.TaskThree;
import Task3.TestClass;
import Task2.FileSaver;

public class Reflection {

    public static void main(String[] args) {
        //Task one ---------------------------------------------------
        System.out.println("*****************************************");
        System.out.println("\nTask One:\n");
        TaskOne.startTaskOne();
        //Task two ---------------------------------------------------
        System.out.println("*****************************************\n");
        System.out.println("Task Two:\n");
        FileSaver.save();
        //Task three -------------------------------------------------
        System.out.println("*****************************************\n");
        System.out.println("Task Three:");
        TaskThree.serialize();
        TaskThree.deserialize(TestClass.class);
        System.out.println("*****************************************");
    }
}
