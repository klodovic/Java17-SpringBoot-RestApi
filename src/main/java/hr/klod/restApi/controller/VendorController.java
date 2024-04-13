package hr.klod.restApi.controller;

import hr.klod.restApi.model.CloudVendor;
import hr.klod.restApi.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    /*List<CloudVendor> vendorList = new ArrayList<CloudVendor>();
    @PostConstruct
    private void init(){

        CloudVendor c1 = new CloudVendor(1, "Vendor1", "Ilica 2", "0985664");
        CloudVendor c2 = new CloudVendor(2, "Vendor2", "Ilica 25", "09853");
        CloudVendor c3 = new CloudVendor(3, "Vendor3", "Ilica 255", "098566");
        vendorList.add(c1);
        vendorList.add(c2);
        vendorList.add(c3);
    }*/


    CloudVendorService cloudVendorService;

    public VendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Get all vendors
    @GetMapping("")
    public List<CloudVendor> getALlVendors(){
        return cloudVendorService.getAll();
    }

    //Get vendor by id
    @GetMapping("/{id}")
    public CloudVendor getVendor(@PathVariable("id") Integer id) {
        return cloudVendorService.getVendor(id);
    }

    //Create new vendor
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.create(cloudVendor);
    }

    //Update vendor
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody CloudVendor cloudVendor, @PathVariable("id") Integer id) {
        if (cloudVendorService.getVendor(id) != null){
            cloudVendorService.update(cloudVendor);
        }
    }

    //Delete vendor
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (cloudVendorService.getVendor(id) != null){
            cloudVendorService.delete(id);
        }
    }
}
