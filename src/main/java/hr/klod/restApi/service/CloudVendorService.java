package hr.klod.restApi.service;

import hr.klod.restApi.exception.CloudVendorException;
import hr.klod.restApi.exception.CloudVendorNotFoundException;
import hr.klod.restApi.model.CloudVendor;
import hr.klod.restApi.repository.CloudVendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorService implements CloudVendorInterface {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorService(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }



    @Override
    public void create(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public void update(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public void delete(Integer id) {
        cloudVendorRepository.deleteById(id);
    }

    @Override
    public CloudVendor getVendor(Integer id) {
        if(cloudVendorRepository.findById(id).isEmpty()){
            throw new CloudVendorNotFoundException("Requested Vendor does not exists");
        }
        return cloudVendorRepository.findById(id).get();
    }

    @Override
    public List<CloudVendor> getAll() {
        return cloudVendorRepository.findAll();
    }
}
