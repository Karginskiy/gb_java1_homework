public class PrintFigure {
    static Figure f;

    public static void main(String[] args) {
        System.out.print(f.KRESTIK.count + " " + f.Nolik.count + " ");
    }
}

enum Figure {
    KRESTIK, Nolik;
    int count = 0;

    Figure() {
        System.out.print("x ");
        count = count + 1;
    }
}

// What result will shown?
// x x 1 1. But why? :)