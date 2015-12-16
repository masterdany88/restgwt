/**
 * 
 */
package com.sagar.restgwt.client.ui;

import gwt.material.design.client.constants.ButtonSize;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.constants.SideNavType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialFAB;
import gwt.material.design.client.ui.MaterialFABList;
import gwt.material.design.client.ui.MaterialFooter;
import gwt.material.design.client.ui.MaterialFooterCopyright;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialNavBrand;
import gwt.material.design.client.ui.MaterialNavSection;
import gwt.material.design.client.ui.MaterialSideNav;
import gwt.material.design.client.ui.MaterialTooltip;
import gwt.material.design.client.ui.html.Header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author korbeldaniel
 *
 */
public class ApplicationView extends Composite {
	
	private Header header = new Header();
	private MaterialContainer mContainer = new MaterialContainer();

	// NavBar
	private MaterialNavBar navBar = new MaterialNavBar();
	private MaterialNavBrand navBrand = new MaterialNavBrand();
	private MaterialNavSection navSec = new MaterialNavSection();
	
	private MaterialTooltip brandToolTip = new MaterialTooltip();
	private MaterialTooltip toolTip = new MaterialTooltip();
	
	// SideNav
	private final String sideNavId = "sideNav";
	private MaterialSideNav sideNav = new MaterialSideNav();
	private MaterialLink sideNavE1 = new MaterialLink(ButtonType.LINK, "Link 1", new MaterialIcon(IconType.BATTERY_CHARGING_20));
	private MaterialLink sideNavE2 = new MaterialLink(ButtonType.LINK, "Link 2", new MaterialIcon(IconType.WEB));
	private MaterialLink sideNavE3 = new MaterialLink(ButtonType.LINK, "Link 3", new MaterialIcon(IconType.WHATSHOT));
	private MaterialLink sideNavE4 = new MaterialLink();
	
	// FAB
	private MaterialFAB fab = new MaterialFAB();
	private MaterialFABList fabl = new MaterialFABList();
	private MaterialButton fab1 = new MaterialButton(ButtonType.FLOATING);
	private MaterialTooltip fabt1 = new MaterialTooltip(fab1,"Test");
	private MaterialButton fab2 = new MaterialButton(ButtonType.FLOATING);
	private MaterialTooltip fabt2 = new MaterialTooltip(fab2, "Test2");
	private MaterialButton fab3 = new MaterialButton(ButtonType.FLOATING);
	private MaterialTooltip fabt3 = new MaterialTooltip(fab3, "Test3");

	// Footer
	private MaterialFooter footer = new MaterialFooter();
	private MaterialFooterCopyright footerCP = new MaterialFooterCopyright();
	private Widget footerCP_label = new MaterialLabel("© 2015 Copyright Supra Brokers S.A.");
	
	public ApplicationView() {
		navBrand.setText("CMS");
		navBrand.setHref("");
		brandToolTip.setWidget(navBrand);
		brandToolTip.setText("CMS");
		
		navSec.setFloat(Style.Float.RIGHT);
		navBar.setActivates(sideNavId);
		navBar.add(navBrand);
		navBar.add(navSec);
		navBar.setBackgroundColor("blue");

		Label child = new Label("TEST");
		navSec.add(child);
		
		// Side Navbar
		sideNav.setType(SideNavType.OPEN);
		sideNav.setId(sideNavId);
		sideNav.setCloseOnClick(true);
		sideNavE1.setHref("#google.pl");
		sideNavE1.setWaves(WavesType.DEFAULT);
		sideNav.add(sideNavE1);
		sideNav.add(sideNavE2);
		sideNav.add(sideNavE3);
		sideNavE4.setIconType(IconType.ASSIGNMENT_LATE);
		sideNavE4.setIconColor("blue");
		sideNavE4.setText("Link #4");
		sideNavE4.setTextColor("blue");
		
		sideNav.add(sideNavE4);
		
		toolTip.setWidget(child);
		toolTip.setText("TEST");
		
		// buttons tooltips
		fabt1.setPosition(Position.LEFT);
		fabt2.setPosition(Position.LEFT);
		fabt3.setPosition(Position.LEFT);
		
		// buttons
		fab1.setSize(ButtonSize.LARGE);
		fab1.setBackgroundColor("red");
		fab1.setIconType(IconType.REMOVE);
		fab1.setWaves(WavesType.DEFAULT);
		
		fab2.setSize(ButtonSize.LARGE);
		fab2.setBackgroundColor("blue");
		fab2.setIconType(IconType.INFO);
		fab2.setWaves(WavesType.DEFAULT);
		
		fab3.setSize(ButtonSize.LARGE);
		fab3.setBackgroundColor("green");
		fab3.setIconType(IconType.ADD);
		fab3.setWaves(WavesType.DEFAULT);
		
		// buttons list
		fab.add(fab1);
		fab.add(fabl);
		fabl.add(fab2);
		fabl.add(fab3);

		// Footer
		footer.setBackgroundColor("blue");
		footer.addStyleName("page-footer");
		footer.add(footerCP);
		footerCP.add(footerCP_label );
		
		
		header.add(navBar);
		header.add(sideNav);
		RootPanel.get().add(header);

		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		mContainer.add(new Button("DSDFDSF"));
		
		RootPanel.get().add(mContainer);
		RootPanel.get().add(fab);
		RootPanel.get().add(footer);
		
		//new MaterialSideProfile();
		
		
	}
}
