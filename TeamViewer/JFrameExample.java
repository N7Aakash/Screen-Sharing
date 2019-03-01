import java.awt.FlowLayout;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.swing.ImageIcon;





public class JFrameExample{

    public BufferedImage image;
    public Dimension dim;

    JFrame frame;
    JPanel panel;
    JLabel label;

    public JFrameExample(BufferedImage image , Dimension dim){
        this.image = image;
        this.dim = dim;


        frame = new JFrame("JFrame Example");  
        panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        label = new JLabel();
        // ImageIcon icon = new ImageIcon(image);
        // label.setIcon(icon);
        // JButton button = new JButton();  
        // button.setText("Button");  
        panel.add(label);  
        // panel.add(button);  
        frame.add(panel);  
        frame.setSize((int)dim.getWidth(), (int)dim.getHeight());  
        frame.setLocationRelativeTo(null); 
        frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
        System.out.println("exiting create frame");
    }

      

    public void updateFrame(BufferedImage image){
        // System.out.println("inside update");
        label.setIcon(null);
        ImageIcon icon = new ImageIcon(image);
        // System.out.println("step 1 done");
        label.setIcon(icon);
        // System.out.println("step 2 performed");
        frame.pack();
    }
}  