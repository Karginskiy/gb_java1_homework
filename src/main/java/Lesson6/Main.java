package Lesson6;

public class Main {

    public static void main(String[] args) {

        // Merge of 2 files.

        Merger merger = new Merger("F:\\WebProjects\\gb_java1_homework\\src\\main\\java\\Lesson6\\files\\text", "F:\\WebProjects\\gb_java1_homework\\src\\main\\java\\Lesson6\\files\\text2");
        merger.merge();

        FileWatcher fileWatcher = new FileWatcher("F:\\WebProjects\\gb_java1_homework\\src\\main\\java\\Lesson6\\files\\text");
        System.out.println(fileWatcher.contains("lala"));

    }

}
