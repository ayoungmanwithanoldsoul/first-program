import javax.swing.JOptionPane;

public class AgeClassificationSwitch {
    public static void main(String[] args) {

        String ageInput = JOptionPane.showInputDialog(null, "Enter your age:");
        int age = Integer.parseInt(ageInput);

        if (age >= 18) {
            JOptionPane.showMessageDialog(null, "You are eligible to vote!");

            switch (age) {
                case 60:
                    JOptionPane.showMessageDialog(null, "You are exactly 60 years old.");
                    break;
                default:
                    if (age >= 60) {
                        JOptionPane.showMessageDialog(null, "You are a senior citizen.");

                    } else if (age > 20) {
                        JOptionPane.showMessageDialog(null, "You are an adult.");
                    } else {
                        JOptionPane.showMessageDialog(null, "You are a young voter.");
                    }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You are not eligible to vote yet.");

            switch (age) {
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    JOptionPane.showMessageDialog(null, "You are a teenager.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "You are a child.");
            }
        }
    }
}
