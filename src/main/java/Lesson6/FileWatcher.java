package Lesson6;

import java.io.FileInputStream;
import java.io.IOException;

public class FileWatcher {

    private final String fileName;

    FileWatcher(final String fileName) {
        this.fileName = fileName;
    }

    public boolean contains(String string) {
        return getFullFile().toString().contains(string);
    }

    private StringBuilder getFullFile() {

        StringBuilder builder = new StringBuilder();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available() > 0) {
                builder.append((char) fileInputStream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder;

    }

}
