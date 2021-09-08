package gui.unit.pkg2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author imad
 */
public class ColorGuesser extends JFrame{

    int r = 0;
    int g = 0;
    int b = 0;
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    JPanel target = new JPanel();
    JPanel sample = new JPanel();
    JButton addRed = new JButton("+");
    JButton subRed = new JButton("-");
    JButton addGreen = new JButton("+");
    JButton subGreen = new JButton("-");
    JButton addBlue = new JButton("+");
    JButton subBlue = new JButton("-");
    JLabel title = new JLabel("Color Guesser");
    JPanel centerPanel = new JPanel();

    public ColorGuesser() {
        setTitle("Color Guesser");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(bottom, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);
        centerPanel.add(sample);
        sample.setPreferredSize(new Dimension(200, 200));
        centerPanel.add(target);
        target.setPreferredSize(new Dimension(200, 200));
        add(centerPanel, BorderLayout.CENTER);

        addRed.setBackground(Color.red);
        subRed.setBackground(Color.red);
        addGreen.setBackground(Color.green);
        subGreen.setBackground(Color.green);
        addBlue.setBackground(Color.blue);
        subBlue.setBackground(Color.blue);

        bottom.setBackground(Color.black);
        bottom.add(addRed);
        bottom.add(subRed);
        bottom.add(addGreen);
        bottom.add(subGreen);
        bottom.add(addBlue);
        bottom.add(subBlue);

        top.setBackground(Color.black);
        title.setForeground(Color.white);
        title.setFont(title.getFont().deriveFont(35f));
        top.add(title);

        Color color = new Color(r, g, b);
        sample.setBackground(color);
        Color targetColor = new Color(30 * (int) (Math.random() * 9), 30 * (int) (Math.random() * 9), 30 * (int) (Math.random() * 9));
        target.setBackground(targetColor);
        setListeners();
        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
    }

    public static void main(String args[]) {
        new ColorGuesser().show();
    }

    private void setListeners() {
        addRed.addActionListener((ActionEvent ae) -> {
            if (r + 30 <= 255) {
                r += 30;
                Color color = new Color(r, g, b);
                sample.setBackground(color);
                CheckGame();
            }
        });
        subRed.addActionListener((ActionEvent ae) ->  {
            if(r-30>=0){
                r -= 30;
                Color color = new Color(r, g, b);
                sample.setBackground(color);
                CheckGame();
            }
        });
        addGreen.addActionListener((ActionEvent ae) -> {
            if (g + 30 <= 255) {
                g += 30;
                Color color = new Color(r, g, b);
                sample.setBackground(color);
                CheckGame();
            }
        });
        subGreen.addActionListener((ActionEvent ae) ->  {
            if(g-30>=0){
                g -= 30;
                Color color = new Color(r, g, b);
                sample.setBackground(color);
                CheckGame();
            }
        });
        addBlue.addActionListener((ActionEvent ae) -> {
            if (b + 30 <= 255) {
                b += 30;
                Color color = new Color(r, g, b);
                sample.setBackground(color);
                CheckGame();
            }
        });
        subBlue.addActionListener((ActionEvent ae) ->  {
            if(b-30>=0){
                b -= 30;
                Color color = new Color(r, g, b);
                sample.setBackground(color);
                CheckGame();
            }
        }); 
      
    }
    private void CheckGame(){
        if(sample.getBackground().equals(target.getBackground()))
      {
        JOptionPane.showMessageDialog(null, "You got it!. Red: " + r +" Green: " + g + " Blue: " + b);
      }
        System.out.println(r+" " + g + " "+b);
        System.out.println(target.getBackground());
    }

}
    
