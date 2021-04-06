import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameResult extends JFrame implements ActionListener {
    Timer repaintTimer = new Timer(100,this);

    public FrameResult(){
        repaintTimer.start();
        paint();
    }

    private void paint(){
        JPanel obrazek = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(PS.image,0,0,null);
            }

        };
        add(obrazek);
        setTitle("Result of your actions");
        setSize(1600,900);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }
}
