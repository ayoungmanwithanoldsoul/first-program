import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
public class newProg {

    public static void main(String[] args) {
        File ff = new File("C:\\Users\\HP ELITEBOOK\\IdeaProjects\\FirstProgram\\src\\output.txt");
        String fname;
        String lname;
        String classification = null;
        int age;
        float weight, height, BMI = 0;
        fname = JOptionPane.showInputDialog("What is your first name? ");
        lname = JOptionPane.showInputDialog("What is your last name? ");
        age = Integer.parseInt((JOptionPane.showInputDialog("Please enter your age")));
        weight = Float.parseFloat((JOptionPane.showInputDialog("Please enter your weight in kilograms")));
        height = Float.parseFloat((JOptionPane.showInputDialog("Please enter your height in meters or centimeters ")));

        BMI = ((height > 10) ? (weight / ((height/100) * (height/100))) : (weight / (height * height)));
        if (BMI <18.5){
            classification = "Underweight";
        }
        else if (BMI >= 18.5 && BMI <= 24.9){
            classification = "Normal";
        }
        else if (BMI >= 25.0 && BMI <= 29.9){
            classification = "Overweight";
        }
        else if (BMI >= 30.0){
            classification = "Obese";
        }

        JOptionPane.showMessageDialog(null,
                String.format("First Name: %s \nLast Name: %s \nAge: %d \nWeight %.1f \nHeight: %.2f \nBMI: %.2f \nClassification: %s",
                        fname,
                        lname,
                        age,
                        weight,
                        height,
                        BMI,
                        classification));

        try {
            FileWriter ffwriter = new FileWriter(ff, true);
            System.out.println("excecuted");
            ffwriter.write(
                    String.format("%s \nFirst Name: %s \nLast Name: %s \nAge: %d \nWeight %.1f \nHeight: %.2f \nBMI: %.2f \nClassification: %s",
                            "\n--------------------------",
                            fname,
                            lname,
                            age,
                            weight,
                            height,
                            BMI,
                            classification));
            ffwriter.close();
            JOptionPane.showMessageDialog(null,"Saved Successfully");

        } catch (IOException e1) {
            System.out.println("file not found");
            e1.printStackTrace();
        }
    }

}