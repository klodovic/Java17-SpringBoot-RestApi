package hr.klod.restApi.controller;

import hr.klod.restApi.model.CloudVendor;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    List<CloudVendor> vendorList = new ArrayList<CloudVendor>();
    @PostConstruct
    private void init(){

        CloudVendor c1 = new CloudVendor(1, "Vendor1", "Ilica 2", "0985664");
        CloudVendor c2 = new CloudVendor(2, "Vendor2", "Ilica 25", "09853");
        CloudVendor c3 = new CloudVendor(3, "Vendor3", "Ilica 255", "098566");
        vendorList.add(c1);
        vendorList.add(c2);
        vendorList.add(c3);
    }


    //Get all vendors
    @GetMapping("")
    public List<CloudVendor> getALlVendors(){
        return vendorList;
    }

    //Get vendor by id
    @GetMapping("/{id}")
    public Optional<CloudVendor> getVendor(@PathVariable Integer id){
        return vendorList.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    //Create new vendor
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody CloudVendor cloudVendor){
        vendorList.add(cloudVendor);
    }

    //Update vendor
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody CloudVendor cloudVendor, @PathVariable Integer id){
        vendorList.removeIf(v -> v.getId().equals(id));
        vendorList.add(cloudVendor);
    }

    //Delete vendor
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        vendorList.removeIf(v -> v.getId().equals(id));
    }
}
