import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(100);

            System.out.println("Generated Number: " + num);

            if (num % 2 == 0)
                new SquareThread(num).start();
            else
                new CubeThread(num).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SquareThread extends Thread {
    int num;

    SquareThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Square of " + num + " = " + (num * num));
    }
}

class CubeThread extends Thread {
    int num;

    CubeThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Cube of " + num + " = " + (num * num * num));
    }
}

public class Main {
    public static void main(String[] args) {
        NumberGenerator t = new NumberGenerator();
        t.start();
    }
}


