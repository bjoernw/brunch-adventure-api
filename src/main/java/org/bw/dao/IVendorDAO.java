package org.bw.dao;

import com.google.common.base.Optional;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.Deal;
import org.bw.model.Vendor;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public interface IVendorDAO
{
	public Optional<Vendor> getVendor(String vendorName) throws DataAccessLayerException;
	public void saveVendor(Vendor vendor) throws DataAccessLayerException;
	public Deal updateVendor(Vendor newVendorObj) throws DataAccessLayerException;
	public void deleteVendor(String vendorName) throws DataAccessLayerException;
}
