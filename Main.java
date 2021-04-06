import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameResult result = new FrameResult();
                FrameGui GUI = new FrameGui();
            }
        });
    }
}
