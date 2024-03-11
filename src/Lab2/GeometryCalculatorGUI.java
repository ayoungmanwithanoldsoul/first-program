package Lab2;

import javax.swing.*;

public class GeometryCalculatorGUI extends JFrame {

    private JLabel labelShape, labelSide, labelLength, labelWidth, labelResult;
    private JTextField tfSide, tfLength, tfWidth, tfPerimeterSquare, tfPerimeterRectangle, tfAreaSquare, tfAreaRectangle;
    private JButton btnCalculate;

    public GeometryCalculatorGUI() {
        initComponents();
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new GeometryCalculatorGUI().setVisible(true));
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Geometry Calculator");

        labelShape = new JLabel("Select Shape:");
        labelSide = new JLabel("Side:");
        labelLength = new JLabel("Length:");
        labelWidth = new JLabel("Width:");
        labelResult = new JLabel("Results:");

        tfSide = new JTextField();
        tfLength = new JTextField();
        tfWidth = new JTextField();
        tfPerimeterSquare = new JTextField();
        tfPerimeterRectangle = new JTextField();
        tfAreaSquare = new JTextField();
        tfAreaRectangle = new JTextField();

        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this::calculateButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelShape)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(labelSide)
                                                .addComponent(labelLength)
                                                .addComponent(labelWidth))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(tfSide, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfLength, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfWidth, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelResult)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfAreaSquare, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(tfPerimeterSquare, GroupLayout.Alignment.LEADING)
                                        .addComponent(tfPerimeterRectangle, GroupLayout.Alignment.LEADING)
                                        .addComponent(tfAreaRectangle, GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnCalculate)
                        .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelShape)
                                .addComponent(labelResult))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelSide)
                                .addComponent(tfSide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfPerimeterSquare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelLength)
                                .addComponent(tfLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfPerimeterRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelWidth)
                                .addComponent(tfWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfAreaSquare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfAreaRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnCalculate)
                        .addContainerGap())
        );

        pack();
    }

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            double side = Double.parseDouble(tfSide.getText());
            double length = Double.parseDouble(tfLength.getText());
            double width = Double.parseDouble(tfWidth.getText());

            double perimeterSquare = 4 * side;
            double perimeterRectangle = 2 * (length + width);
            double areaSquare = side * side;
            double areaRectangle = length * width;

            tfPerimeterSquare.setText(String.valueOf(perimeterSquare));
            tfPerimeterRectangle.setText(String.valueOf(perimeterRectangle));
            tfAreaSquare.setText(String.valueOf(areaSquare));
            tfAreaRectangle.setText(String.valueOf(areaRectangle));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for the dimensions.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
