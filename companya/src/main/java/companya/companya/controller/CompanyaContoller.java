package companya.companya.controller;


import companya.companya.companyData.CustomerDeatail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RestController
public class CompanyaContoller {

    @Autowired
    CompanyaRepository companyaRepository;
//
    // Get all companya customer
    @GetMapping("/companya")
    public List<CustomerDeatail> index(){
        return companyaRepository.findAll();
    }
//
    // find by Id
    @GetMapping("/companya/{id}")
    public CustomerDeatail show(@PathVariable int id){
        Optional<CustomerDeatail> optCus = companyaRepository.findById(id);
        return optCus.get();
    }

    //search by username
    @PostMapping("/companya/search")
    public List<CustomerDeatail> search(@RequestBody Map<String, String> body){
        String searchInput = body.get("username");
        return companyaRepository.findByUsername(searchInput);
    }
//
    //create new cus companya
    @PostMapping("/companya-create")
    public CustomerDeatail create(@RequestParam Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        String id_card_number = body.get("id_card_number");
        String fname = body.get("fname");
        String lname = body.get("lname");
        String address = body.get("address");
        String phone = body.get("phone");
        String credit = body.get("credit_card");
        return companyaRepository.save(new CustomerDeatail(username, password, email, id_card_number, fname, lname, address, phone, credit));
    }
//
    //update companya
    @PutMapping("/companya/{id}")
    public CustomerDeatail update(@PathVariable String id, @RequestBody Map<String, String> body){
        int comoId = Integer.parseInt(id);
        Optional<CustomerDeatail> cusCH = companyaRepository.findById(comoId);
        cusCH.get().setUsername(body.get("username"));
        cusCH.get().setPassword((body.get("password")));
        cusCH.get().setEmail((body.get("email")));
        cusCH.get().setId_card_number((body.get("id_card_number")));
        cusCH.get().setFname((body.get("fname")));
        cusCH.get().setLname((body.get("lname")));
        cusCH.get().setAddress((body.get("address")));
        cusCH.get().setPhone((body.get("phone")));
        cusCH.get().setCredit_card((body.get("credit_card")));
        return companyaRepository.save(cusCH.get());
    }

    //delete motorbike
    @DeleteMapping("companya/{id}")
    public boolean delete(@PathVariable String id){
        int cusId = Integer.parseInt(id);
        companyaRepository.deleteById(cusId);
        return true;
    }
}
