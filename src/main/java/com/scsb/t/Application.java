package com.scsb.t;

import com.scsb.t.dao.EmployeeDAO.*;
import com.scsb.t.dao.EmployeeDAO;
import com.scsb.t.dao.EmployeeDAOImpl;
import com.scsb.t.entity.EmployeeLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.scsb.t.FormServlet;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletException;
import java.util.List;

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws ServletException {
    SpringApplication.run(Application.class, args);

  }
/*
在项目啟動後執行的功能，SpringBoot提供的一種簡單的實現方案就是添加一个model並實現CommandLineRunner接口，實現功能的代碼放在實現的run方法中
也就是項目一起動之後，就立即需要執行的動作
當你在 Spring Boot 應用程式中使用 @Bean 註解來創建 bean，Spring 會試圖自動注入 bean 的構造函數或方法的參數。在你的情況下，你試圖自動注入 String[] args，但 Spring 容器中沒有這種類型的 bean。解決這個問題的一種方法是使用 ApplicationArguments 代替 String[] args，這是 Spring Boot 提供的一個封裝，用於存儲應用程式的命令行參數。
使用 ApplicationArguments，你可以獲取原始的 String[] args（如果需要的話），但在大多數情況下，你可能不需要直接訪問它。如果你真的需要，你可以使用 args.getSourceArgs() 方法來獲取它。
*/
  @Bean
  public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO){
//    JAVA Lambda expression
    return runner -> {
      //createEmployee(employeeDAO);
      //readEmployee(employeeDAO);
      //queryForEmployees(employeeDAO);
      findAllByEmpId(employeeDAO);
    };
  }

  private void findAllByEmpId(EmployeeDAO employeeDAO) {
    List<EmployeeLogin> theEmployees = employeeDAO.findAllByEmpId("E0002");
    for(EmployeeLogin tempEmployee: theEmployees){
      System.out.println(tempEmployee);
    }
  }

  private void queryForEmployees(EmployeeDAO employeeDAO) {
    List<EmployeeLogin> theEmployees = employeeDAO.findAll();
    for(EmployeeLogin tempEmployee: theEmployees){
      System.out.println(tempEmployee);
    }
  }

  private void readEmployee(EmployeeDAO employeeDAO) {

    //create the employee object
//    System.out.println("create new employee object");
//    EmployeeLogin tempEmployee1 = new EmployeeLogin("E0002", "陳勤", "6666");
//    //save the employee object
//    System.out.println("save the employee object");
//    employeeDAO.save(tempEmployee1);
//    //display id for the saved employee
//    String Empid = tempEmployee1.getEmp_id();
//    System.out.println(tempEmployee1.getEmp_id());
    //retrieve student based on the id:primary key
    EmployeeLogin myEmployee = employeeDAO.findById("E0002");
    //display employee
    System.out.println(myEmployee);

  }

  private void createEmployee(EmployeeDAO employeeDAO) {
    //create the employee object
    System.out.println("create new employee object");
    EmployeeLogin tempEmployee = new EmployeeLogin("E0001", "吳俊易", "1234");
    //save the employee object
    System.out.println("save the employee object");
    employeeDAO.save(tempEmployee);
    //display id for the saved employee
    System.out.println(tempEmployee.getEmp_id());

  }

}