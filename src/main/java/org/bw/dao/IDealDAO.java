package org.bw.dao;

import com.google.common.base.Optional;
import org.bw.dao.mappers.DealObjectMapper;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.Deal;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public interface IDealDAO
{
	@RegisterMapper(DealObjectMapper.class)
	@SqlQuery("Select dealId from tblDeals join tblVendors on tblDeals.vendorId = tblVendors.vendorId where tblDeals.dealId = :dealId")
	public Optional<Deal> getDeal(@Bind("dealId") int dealId) throws DataAccessLayerException;

	public void saveDeal(Deal deal) throws DataAccessLayerException;
	public Deal updateDeal(Deal newDealObj) throws DataAccessLayerException;
	public void deleteDeal(int uuid) throws DataAccessLayerException;
}
