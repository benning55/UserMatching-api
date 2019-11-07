package companyb.companyb.controller;

import companyb.companyb.companyData.CustomerDeatail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RestController
public class CompanybController {

    @Autowired
    CompanybRepository companybRepository;
    //
    // Get all companyb customer
    @GetMapping("/companyb")
    public List<CustomerDeatail> index(){
        return companybRepository.findAll();
    }
    //
    // find by Id
    @GetMapping("/companyb/{id}")
    public CustomerDeatail show(@PathVariable int id){
        Optional<CustomerDeatail> optCus = companybRepository.findById(id);
        return optCus.get();
    }

    //search by username
    @PostMapping("/companyb/search")
    public List<CustomerDeatail> search(@RequestBody Map<String, String> body){
        String searchInput = body.get("username");
        return companybRepository.findByUsername(searchInput);
    }
    //
    //create new cus companyb
    @PostMapping("/companyb-create")
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
        String gender = body.get("gender");
        return companybRepository.save(new CustomerDeatail(username, password, email, id_card_number, fname, lname, address, phone, credit, gender));
    }
    //
    //update companyb
    @PutMapping("/companyb/{id}")
    public CustomerDeatail update(@PathVariable String id, @RequestBody Map<String, String> body){
        int comoId = Integer.parseInt(id);
        Optional<CustomerDeatail> cusCH = companybRepository.findById(comoId);
        cusCH.get().setUsername(body.get("username"));
        cusCH.get().setPassword((body.get("password")));
        cusCH.get().setEmail((body.get("email")));
        cusCH.get().setId_card_number((body.get("id_card_number")));
        cusCH.get().setFname((body.get("fname")));
        cusCH.get().setLname((body.get("lname")));
        cusCH.get().setAddress((body.get("address")));
        cusCH.get().setPhone((body.get("phone")));
        cusCH.get().setCredit_card((body.get("credit_card")));
        return companybRepository.save(cusCH.get());
    }

    //delete motorbike
    @DeleteMapping("companyb/{id}")
    public boolean delete(@PathVariable String id){
        int cusId = Integer.parseInt(id);
        companybRepository.deleteById(cusId);
        return true;
    }
}
