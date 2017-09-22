package Task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SaveTo(path = "d:\\text.txt")
public class TextContainer {

    public String text = "Some text...";

    @Saver
    public void save(String path){
        File file;
        FileOutputStream fop = null;

        try {
            file = new File(path);
            fop = new FileOutputStream(file);

            if (!file.exists()){
                file.createNewFile();
            }

            byte[] bytes = text.getBytes();

            fop.write(bytes);
            fop.flush();
            fop.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
