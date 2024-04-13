package hr.klod.restApi.repository;

import hr.klod.restApi.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, Integer> { //Integer is CloudVendor id prop

}
