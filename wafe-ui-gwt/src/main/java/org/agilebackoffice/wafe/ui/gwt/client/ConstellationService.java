/**
 * 
 */
package org.agilebackoffice.wafe.ui.gwt.client;

import java.util.List;

import org.agilebackoffice.wafe.ui.gwt.client.domain.Constellation;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author kamann
 *
 */
@RemoteServiceRelativePath("services/constellationService")
public interface ConstellationService extends RemoteService {
	
	List<Constellation> findAllConstellations();

}
