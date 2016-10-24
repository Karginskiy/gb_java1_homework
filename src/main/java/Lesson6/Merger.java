package Lesson6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Merger {

    private final String fileNameOne;
    private final String fileNameTwo;

    Merger(final String fileNameOne, final String fileNameTwo) {
        this.fileNameOne = fileNameOne;
        this.fileNameTwo = fileNameTwo;
    }

    void merge() {

        try {
            writeInFile(fileNameOne, getFullFile(fileNameTwo));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeInFile(String fileName, byte[] buffer) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        fileOutputStream.write(buffer);
        fileOutputStream.close();

    }

    private byte[] getFullFile(String fileName) throws IOException {

        byte[] buffer = null;

        FileInputStream inputStream = new FileInputStream(fileName);
        buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();

        return buffer;

    }

}
