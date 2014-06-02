package org.bw.services;

import com.google.common.base.Optional;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.Deal;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public interface IDealService
{
	public Optional<Deal> getDeal(int uuid) throws DataAccessLayerException;
	public void saveDeal(Deal deal) throws DataAccessLayerException;
	public Deal updateDeal(Deal newDealObj) throws DataAccessLayerException;
	public void deleteDeal(int uuid) throws DataAccessLayerException;
}
