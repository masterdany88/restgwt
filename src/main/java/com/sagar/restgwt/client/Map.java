package com.sagar.restgwt.client;

import gwt.material.design.client.ui.html.Div;

import java.util.ArrayList;

import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sagar.restgwt.client.ui.OpenStreetMapLayerWidget;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

  

public class Map extends Composite {
    VerticalPanel mapPanel = new VerticalPanel();

	public Map() {
        initWidget(mapPanel);
		loadMapApi();
	}

  private void loadMapApi() {
    boolean sensor = true;

    // load all the libs for use in the maps
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.ADSENSE);
    loadLibraries.add(LoadLibrary.DRAWING);
    loadLibraries.add(LoadLibrary.GEOMETRY);
    loadLibraries.add(LoadLibrary.PANORAMIO);
    loadLibraries.add(LoadLibrary.PLACES);
    loadLibraries.add(LoadLibrary.WEATHER);
    loadLibraries.add(LoadLibrary.VISUALIZATION);

    Runnable onLoad = new Runnable() {
      @Override
      public void run() {
        draw();
      }
    };

    LoadApi.go(onLoad, loadLibraries, sensor);
  }

  /**
   * See the map widgets for different map configurations
   */
  private void draw() {
    drawOpenStreetMapLayerMap();
  }

  /**
   * Add the widget to the demos
   * 
   * @param widget map
   */
  private void addMapWidget(Widget widget) {
	  mapPanel.add(widget);
  }





  private void drawOpenStreetMapLayerMap() {
    OpenStreetMapLayerWidget wMap = new OpenStreetMapLayerWidget();
    addMapWidget(wMap);
  }
  

}