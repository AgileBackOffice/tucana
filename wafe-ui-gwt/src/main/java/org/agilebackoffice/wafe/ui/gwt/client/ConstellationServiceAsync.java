/**
 * 
 */
package org.agilebackoffice.wafe.ui.gwt.client;

import java.util.List;

import org.agilebackoffice.wafe.ui.gwt.client.domain.Constellation;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author kamann
 *
 */
public interface ConstellationServiceAsync {

	/**
	 * 
	 * @see org.agilebackoffice.wafe.ui.gwt.client.ConstellationService#findAllConstellations()
	 */
	void findAllConstellations(AsyncCallback<List<Constellation>> callback);

}
