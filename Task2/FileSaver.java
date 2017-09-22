package Task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FileSaver {

    public static void save(){
        Class<?> textContainerCls = TextContainer.class;
        if (textContainerCls.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Class have annotation *SaveTo*.");

            try {
                Method saveMethod = textContainerCls.getMethod("save", String.class);
                if (saveMethod.isAnnotationPresent(Saver.class)){
                    System.out.println("Method have annotation *Saver*.");

                    SaveTo saveTo = textContainerCls.getAnnotation(SaveTo.class);
                    String path = saveTo.path();

                    saveMethod.invoke(new TextContainer(), path);

                    System.out.println("Text was added in " + path +".");

                } else System.out.println("Method don't have annotation *SaveTo*.");

            } catch (NoSuchMethodException e) {
                System.out.println("There are no method with name *save*.");
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        } else System.out.println("Class don't have annotation *SaveTo*.");
    }
}
