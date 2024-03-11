package p8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerformOperation implements ActionListener {
    JTextField tf1, tf2, tf3;
    JLabel lbl1, lbl2, lbl3;
    JButton addBtn, subBtn, mulBtn, divBtn, clearBtn;

    PerformOperation() {
        JFrame f = new JFrame();

        lbl1 = new JLabel();
        lbl1.setText("First Number: ");
        lbl1.setBounds(50, 50, 100, 35);
        tf1 = new JTextField();
        tf1.setBounds(150, 50, 150, 35);

        lbl2 = new JLabel();
        lbl2.setText("Second Number: ");
        lbl2.setBounds(50, 100, 100, 35);
        tf2 = new JTextField();
        tf2.setBounds(150, 100, 150, 35);

        lbl3 = new JLabel();
        lbl3.setText("Result: ");
        lbl3.setBounds(50, 150, 150, 35);
        tf3 = new JTextField();
        tf3.setBounds(150, 150, 150, 35);
        tf3.setEditable(false);

        addBtn = new JButton("Add");
        addBtn.setBounds(50, 200, 70, 50);

        subBtn = new JButton("Subtract");
        subBtn.setBounds(130, 200, 90, 50);

        mulBtn = new JButton("Multiply");
        mulBtn.setBounds(230, 200, 90, 50);

        divBtn = new JButton("Divide");
        divBtn.setBounds(50, 260, 90, 50);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(150, 260, 100, 50);

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        f.add(lbl1);
        f.add(lbl2);
        f.add(lbl3);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(addBtn);
        f.add(subBtn);
        f.add(mulBtn);
        f.add(divBtn);
        f.add(clearBtn);

        f.setSize(350, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new PerformOperation();
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = tf1.getText();
        String s2 = tf2.getText();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int result = 0;

        if (e.getSource() == addBtn) {
            result = a + b;
        } else if (e.getSource() == subBtn) {
            result = a - b;
        } else if (e.getSource() == mulBtn) {
            result = a * b;
        } else if (e.getSource() == divBtn) {
            // Avoid division by zero
            if (b != 0) {
                result = a / b;
            } else {
                JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                return;
            }
        } else if (e.getSource() == clearBtn) {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            return;
        }

        tf3.setText(String.valueOf(result));
    }
}
