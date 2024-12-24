import java.awt.*;
import java.awt.event.*;

public class DivisionMain1 extends Frame implements ActionListener {
    TextField num1, num2;
    Button dResult;
    Label outResult;
    String out = "";
    double resultNum;
    int flag = 0;

    public DivisionMain1() {
        setLayout(new FlowLayout());

        dResult = new Button("RESULT");
        Label number1 = new Label("Number 1:", Label.RIGHT);
        Label number2 = new Label("Number 2:", Label.RIGHT);

        num1 = new TextField(5);
        num2 = new TextField(5);

        outResult = new Label("Result:", Label.RIGHT);

        add(number1);
        add(num1);
        add(number2);
        add(num2);
        add(dResult);
        add(outResult);

        num1.addActionListener(this);
        num2.addActionListener(this);
        dResult.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setTitle("Division Program");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        int n1, n2;
        try {
            if (ae.getSource() == dResult) {
                n1 = Integer.parseInt(num1.getText());
                n2 = Integer.parseInt(num2.getText());

                if (n2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }

                out = n1 + " / " + n2 + " = ";
                resultNum = (double) n1 / n2;
                out += String.valueOf(resultNum);
                repaint();
            }
        } catch (NumberFormatException e1) {
            flag = 1;
            out = "Number Format Exception! " + e1.getMessage();
            repaint();
        } catch (ArithmeticException e2) {
            flag = 1;
            out = "Divide by 0 Exception! " + e2.getMessage();
            repaint();
        }
    }

    public void paint(Graphics g) {
        if (flag == 0) {
            g.drawString(out, outResult.getX() + outResult.getWidth() + 10, outResult.getY() + 20);
        } else {
            g.drawString(out, 100, 200);
            flag = 0;
        }
    }

    public static void main(String[] args) {
        new DivisionMain1();
    }
}
