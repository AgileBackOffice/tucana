/**
 * 
 */
package org.agilebackoffice.wafe.ui.gwt.server;

import java.io.IOException;
import java.util.List;

import org.agilebackoffice.wafe.ui.gwt.client.ConstellationService;
import org.agilebackoffice.wafe.ui.gwt.client.domain.Constellation;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.thoughtworks.xstream.XStream;

/**
 * @author kamann
 *
 */
public class ConstellationServiceImpl extends RemoteServiceServlet implements
		ConstellationService {

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.ui.gwt.client.ConstellationService#findAllConstellations()
	 */
	@Override
	public List<Constellation> findAllConstellations() {
		String url = "http://localhost:8080/wafe-web/constellation/constellations/";
		String result = getResult(url);
		
		XStream xstream = new XStream();
		xstream.alias("org.agilebackoffice.wafe.domain.Constellation", Constellation.class);
		
		List<Constellation> constellations =  (List<Constellation>) xstream.fromXML(result);
		
		return constellations;
	}
	
	private String getResult(String url){
		String responseBody = null;
		HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            responseBody = httpclient.execute(httpget, responseHandler);
        } catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            httpclient.getConnectionManager().shutdown();
        }
        return responseBody;
	}

}
