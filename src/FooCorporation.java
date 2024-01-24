import org.jfree.data.json.JSONUtils;

import java.util.HashMap;
import java.util.Map;

public class FooCorporation {
    static Map<String, double[]> employees = new HashMap<>();

    public static void calculatePay() {
        boolean err = false;
        for (Map.Entry<String, double[]> z : employees.entrySet()) {
            System.out.println("----------Salary for " + z.getKey() + "----------");
            for (int j = 0; j < z.getValue().length; j++) {
                if (z.getValue()[j] < 8.00) {
                    System.out.printf("Error employee %s should be paid at least 8.00 per hour\n", z.getKey());
                    err = true;
                }
                if (z.getValue()[j] > 60.00) {
                    System.out.printf("Error employee %s work hours is greater than 60 hours which is the threshold specified by Foo Corporation\n", z.getKey());
                    err = true;
                }
            }
            if (err) {
                System.out.println("We cannot display the salary for " + z.getKey() + " since there are problems with the input values");
            } else {
                double salary = z.getValue()[1] * 40;
                salary += (z.getValue()[1] > 40 ? (z.getValue()[1] - 40) * z.getValue()[0] : 0.00);
                System.out.printf("The salary for %s is PHP %f", z.getKey(), salary);
            }

//            System.out.printf("%s", (err ? "We cannot display the salary for " + z.getKey() + " since there are problems with the input values" : ""));
        }
    }

    public static void main(String[] args) {
        employees.put("Employee 1", new double[]{7.50, 35});
        employees.put("Employee 2", new double[]{8.20, 47});
        employees.put("Employee 3", new double[]{10.00, 73});

//        for (int i = 1; i <= 3; i++){
//            calculatePay(("Employee "+ i));
//        }
        calculatePay();

    }


}
