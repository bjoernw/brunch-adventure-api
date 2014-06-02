package org.bw.dao;

import com.google.common.base.Optional;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.Deal;
import org.bw.model.Vendor;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public class VendorDAO implements IVendorDAO
{
	@Override
	public Optional<Vendor> getVendor(String vendorName) throws DataAccessLayerException
	{
		return null;
	}

	@Override
	public void saveVendor(Vendor vendor) throws DataAccessLayerException
	{

	}

	@Override
	public Deal updateVendor(Vendor newVendorObj) throws DataAccessLayerException
	{
		return null;
	}

	@Override
	public void deleteVendor(String vendorName) throws DataAccessLayerException
	{

	}
}
