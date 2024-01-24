import java.io.Serializable;

public class SalesEmployee implements Serializable{
   int employeeId;
   String employeeName;
   int employeeSales;
   
   SalesEmployee(int employeeId, String employeeName, int employeeSales) {
       this.employeeId = employeeId;
       this.employeeName = employeeName;
       this.employeeSales = employeeSales;
   } 
   public String toString(){
       return employeeId+" "+employeeName+" "+employeeSales;
   }
}

