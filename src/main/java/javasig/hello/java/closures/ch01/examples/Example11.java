package javasig.hello.java.closures.ch01.examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener - lambdas
 */
public class Example11 {
    public static void main(String[] args) {
        Example11 demo = new Example11();

        JButton testButton = new JButton("Test Button");

        testButton.addActionListener(demo.classicStyle());
        testButton.addActionListener(demo.java8Style());

        // Swing stuff
        JFrame frame = new JFrame("Listener Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(testButton, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private ActionListener classicStyle() {
        return new ActionListener(){
            @Override public void actionPerformed(ActionEvent ae){
                System.out.println("Click Detected by Anon Class");
            }
        };
    }

    private ActionListener java8Style() {
        return e -> System.out.println("Click Detected by Lambda Listener");
    }

}