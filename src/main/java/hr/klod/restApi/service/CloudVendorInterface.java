package hr.klod.restApi.service;

import hr.klod.restApi.model.CloudVendor;

import java.util.List;

public interface CloudVendorInterface {
    public void create(CloudVendor cloudVendor);
    public void update(CloudVendor cloudVendor);
    public void delete(Integer id);
    public CloudVendor getVendor(Integer id) throws ClassNotFoundException;
    public List<CloudVendor> getAll();
}
