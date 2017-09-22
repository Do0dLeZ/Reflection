package Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TaskOne {

    public static void startTaskOne(){
        Class<?> cls = TaskOne.class;
        try {
            Method sumMethod = cls.getMethod("getSum", int.class, int.class);
            if (sumMethod.isAnnotationPresent(Test.class)) {
                System.out.println("Method have tests annotation.");

                Test test = sumMethod.getAnnotation(Test.class);
                sumMethod.invoke(new TaskOne(), test.first(), test.second());

            } else System.out.println("Method don't have tests annotation.");

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(first = 1, second = 2)
    public void getSum(int first, int second){
        System.out.format("first = %d, second = %d", first, second);
        System.out.println();
    }
}
