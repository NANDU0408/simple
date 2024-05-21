package com.xworkz.mvc.controller;

import com.xworkz.mvc.dto.CustomerDTO;
import com.xworkz.mvc.repositories.CustomerRepo;
import com.xworkz.mvc.repositories.CustomerRepoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet( urlPatterns = {"/reg"}, loadOnStartup = 1)
public class CustomerAccessDetailsServlet extends HttpServlet {


    public CustomerAccessDetailsServlet() {
        System.out.println("Running The Hotel Form in Servlet");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("doPost method invoked");
        try {
              CustomerRepo customerRepo= new CustomerRepoImpl();

            String name = req.getParameter("name");
            System.out.println("Name: " + name);
            int age = Integer.parseInt(req.getParameter("age"));
            String gender = req.getParameter("gender");
            String dobStr = req.getParameter("dob");
            String address = req.getParameter("address");
            long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
            String idProof = req.getParameter("idProof");
            long idProofNo = Long.parseLong(req.getParameter("idProofNo"));
            long emergencyContact = Long.parseLong(req.getParameter("emergencyContact"));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = dateFormat.parse(dobStr);

            CustomerDTO customerDTO = new CustomerDTO(0, name, age, gender, dob, address, phoneNo, idProof, idProofNo, emergencyContact);
            List<CustomerDTO> customerList = new ArrayList<>();
//            customerList.add(customerDTO);

//            customerRepo.saveAllDept(customerList);

            resp.getWriter().println("Customer data saved successfully");
        } catch (ParseException e) {
            e.printStackTrace();
            resp.getWriter().println("Error parsing date");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("An error occurred");
        }

    }
}