package org.bw.services;

import com.google.common.base.Optional;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.Deal;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public class DealService implements IDealService
{
	@Override
	public Optional<Deal> getDeal(int uuid) throws DataAccessLayerException
	{
		return null;
	}

	@Override
	public void saveDeal(Deal deal) throws DataAccessLayerException
	{

	}

	@Override
	public Deal updateDeal(Deal newDealObj) throws DataAccessLayerException
	{
		return null;
	}

	@Override
	public void deleteDeal(int uuid) throws DataAccessLayerException
	{

	}
}
