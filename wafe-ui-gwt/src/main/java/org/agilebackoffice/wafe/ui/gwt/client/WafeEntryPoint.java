/**
 * 
 */
package org.agilebackoffice.wafe.ui.gwt.client;

import java.util.List;

import org.agilebackoffice.wafe.ui.gwt.client.domain.Constellation;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author kamann
 *
 */
public class WafeEntryPoint implements EntryPoint {
	private Grid searchResultsGrid;
	private Label searchresultsHeader;
	private FlexTable searchResults;
	
	private ConstellationServiceAsync service = GWT.create(ConstellationService.class);

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("100%", Window.getClientHeight()+"px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		rootPanel.add(verticalPanel);
		verticalPanel.setSize("100%", "");
		
		HTML htmlNewHtml = new HTML("New HTML", true);
		htmlNewHtml.setStyleName("header");
		verticalPanel.add(htmlNewHtml);
		
		Grid grid = new Grid(1, 2);
		grid.setStyleName("grid TD");
		verticalPanel.add(grid);
		verticalPanel.setCellWidth(grid, "50%");
		grid.setWidth("100%");
		
		TextBox textBox = new TextBox();
		grid.setWidget(0, 0, textBox);
		
		Button btnNewButton = new Button("New button");
		grid.setWidget(0, 1, btnNewButton);
		grid.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		rootPanel.add(getSearchResultsGrid(), 8, 193);
		
		if (service == null) {
		      service = GWT.create(ConstellationService.class);
		    }

		    // Set up the callback object.
		    AsyncCallback<List<Constellation>> callback = new AsyncCallback<List<Constellation>>() {
		      public void onFailure(Throwable caught) {
		        System.out.println("error");
		        caught.printStackTrace();
		      }

		      public void onSuccess(List<Constellation> result) {
		        updateUI(result);
		      }
		    };

		    // Make the call to the stock price service.
		    service.findAllConstellations(callback);
	}
	
	private void updateUI(List<Constellation> result){
		searchresultsHeader.setText("Found "+result.size()+" results.");
		
		for (int i = 0; i < result.size()	; i++) {
			Constellation constellation = (Constellation) result.get(i);
			searchResults.setText(i+1, 0, constellation.getName());
			searchResults.setText(i+1, 1, constellation.getGenitiveName());
			searchResults.setText(i+1, 2, constellation.getCode());
		}
	}
	
	private Grid getSearchResultsGrid() {
		if (searchResultsGrid == null) {
			searchResultsGrid = new Grid(2, 1);
			searchResultsGrid.setSize("810px", "100px");
			searchResultsGrid.setWidget(0, 0, getSearchresultsHeader());
			searchResultsGrid.setWidget(1, 0, getSearchResults());
			searchResultsGrid.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
			searchResultsGrid.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		}
		return searchResultsGrid;
	}
	private Label getSearchresultsHeader() {
		if (searchresultsHeader == null) {
			searchresultsHeader = new Label("Found xxx constellations");
			searchresultsHeader.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			searchresultsHeader.setWidth("80%");
		}
		return searchresultsHeader;
	}
	
	private FlexTable getSearchResults() {
		if (searchResults == null) {
			searchResults = new FlexTable();
			searchResults.setWidth("80%");
			searchResults.setText(0, 0, "Name");
			searchResults.setText(0, 1, "Genitive Name");
			searchResults.setText(0, 2, "Code");
			searchResults.setText(0, 3, "Actions");
		}
		return searchResults;
	}
}
