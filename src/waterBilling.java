import javax.swing.*;

public class waterBilling {
    public static void main(String[] args) {
        String  name, address;
        float units = 0, cost, costPerUnit;

        name = JOptionPane.showInputDialog("Please enter your full name");
        address = JOptionPane.showInputDialog("Please enter your barangay address");
        units = Float.parseFloat(JOptionPane.showInputDialog("Please enter the number of units of water used"));

        costPerUnit =
            switch (address.toLowerCase()) {
                case "maa" -> 1.00F;
                case "buhangin" -> 0.75F;
                case "toril" -> 1.50F;
                case "bankerohan" -> 0.25F;
                default -> 0.50F;
            };
        cost = (units * costPerUnit);

        JOptionPane.showMessageDialog(null,
            String.format(
                "Assessment\n" +
                "     Name: %s\n" +
                "     Address: %s\n" +
                "     Number of units used: %.2f\n" +
                "     Cost per unit: %.2f\n" +
                "     Total billing cost: %.2f\n",
                name, (address.substring(0,1).toUpperCase() + address.substring(1).toLowerCase()), units, costPerUnit, cost
            )
        );
    }
}
