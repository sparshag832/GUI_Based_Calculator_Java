import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends WindowAdapter implements ActionListener {
    int k;
    Frame f;
    Button b[] = new Button[16];
    Panel p;
    JLabel l;
    String digits = "0123456789";
    String operators = "+-*/";
    String caption[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "0", "=", "/" };
    String op1, op2, op;

    Calculator() {
        f = new Frame("Calculator");
        f.addWindowListener(this);
        p = new Panel();
        l = new JLabel("0", SwingConstants.RIGHT);
        l.setFont(new Font("Arial", 1, 24));
        p.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
            b[i] = new Button(caption[i]);
            b[i].setFont(new Font("Arial", 1, 24));
            b[i].addActionListener(this);
            p.add(b[i]);
        }
        f.add(l, BorderLayout.NORTH);
        f.add(p);
        f.setVisible(true);
        f.setSize(300, 300);
    }

    public static void main(String ar[]) {
        Calculator c = new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        Button bt = (Button) e.getSource();
        String text = bt.getLabel();
        if (digits.contains(text)) {
            if (k == 0) {
                l.setText(text);
                k = 1;
            } else {
                l.setText(l.getText() + text);
            }

        } else if (operators.contains(text)) {
            op1 = l.getText();
            op = text;
            k = 0;
        } else if (text.equals("=")) {
            op2 = l.getText();
            calc();
        }

    }

    void calc() {
        float a, b, c;
        a = Float.parseFloat(op1);
        b = Float.parseFloat(op2);
        if (op.equals("+"))
            c = a + b;
        else if (op.equals("-"))
            c = a - b;
        else if (op.equals("*"))
            c = a * b;
        else
            c = a / b;
        l.setText("" + c);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

}