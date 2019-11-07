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

    @PostMapping("companya/search-person")
    public List<CustomerDeatail> search(@RequestBody Map<String, String> body){
        String first_name = body.get("first_name");
        String last_name = body.get("last_name");
        return companyaRepository.findByFirstnameAndLastName(first_name, last_name);
    }

//    //search by username
//    @PostMapping("/companya/search")
//    public List<CustomerDeatail> search(@RequestBody Map<String, String> body){
//        String searchInput = body.get("username");
//        return companyaRepository.findByUsername(searchInput);
//    }
//
    //create new cus companya
    @PostMapping("/companya-create")
    public CustomerDeatail create(@RequestParam Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        String id_card_number = body.get("personal_id");
        String fname = body.get("first_name");
        String lname = body.get("last_name");
        String address = body.get("address");
        String phone = body.get("phone");
        String credit = body.get("credit_card");
        String gender = body.get("gender");
        return companyaRepository.save(new CustomerDeatail(username, password, email, id_card_number, fname, lname, address, phone, credit, gender));
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
        cusCH.get().setPersonal_id((body.get("personal_id")));
        cusCH.get().setFirst_name((body.get("first_name")));
        cusCH.get().setLast_name((body.get("last_name")));
        cusCH.get().setAddress((body.get("address")));
        cusCH.get().setPhone((body.get("phone")));
        cusCH.get().setCredit_card((body.get("credit_card")));
        cusCH.get().setGender((body.get(("gender"))));
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
