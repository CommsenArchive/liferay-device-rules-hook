/**
 * Copyright (c) COMMSEN International. All rights reserved.
 *	
 * This library is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library.  If not, see http://www.gnu.org/licenses/lgpl.html.
 */

package com.commsen.liferay.multidevice.rules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.commsen.liferay.multidevice.rules.service.http.RuleServiceSoap}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       com.commsen.liferay.multidevice.rules.service.http.RuleServiceSoap
 * @generated
 */
public class RuleSoap implements Serializable {
	public static RuleSoap toSoapModel(Rule model) {
		RuleSoap soapModel = new RuleSoap();

		soapModel.setRid(model.getRid());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setBrand(model.getBrand());
		soapModel.setModel(model.getModel());
		soapModel.setOs(model.getOs());
		soapModel.setOsVersion(model.getOsVersion());
		soapModel.setBrowser(model.getBrowser());
		soapModel.setBrowserVersion(model.getBrowserVersion());
		soapModel.setPointingMethod(model.getPointingMethod());
		soapModel.setTablet(model.getTablet());
		soapModel.setQwertyKeyboad(model.getQwertyKeyboad());
		soapModel.setAction(model.getAction());
		soapModel.setThemeId(model.getThemeId());
		soapModel.setColorSchemeId(model.getColorSchemeId());
		soapModel.setUrl(model.getUrl());
		soapModel.setPriority(model.getPriority());

		return soapModel;
	}

	public static RuleSoap[] toSoapModels(Rule[] models) {
		RuleSoap[] soapModels = new RuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RuleSoap[][] toSoapModels(Rule[][] models) {
		RuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RuleSoap[] toSoapModels(List<Rule> models) {
		List<RuleSoap> soapModels = new ArrayList<RuleSoap>(models.size());

		for (Rule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RuleSoap[soapModels.size()]);
	}

	public RuleSoap() {
	}

	public long getPrimaryKey() {
		return _rid;
	}

	public void setPrimaryKey(long pk) {
		setRid(pk);
	}

	public long getRid() {
		return _rid;
	}

	public void setRid(long rid) {
		_rid = rid;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(long layoutId) {
		_layoutId = layoutId;
	}

	public String getBrand() {
		return _brand;
	}

	public void setBrand(String brand) {
		_brand = brand;
	}

	public String getModel() {
		return _model;
	}

	public void setModel(String model) {
		_model = model;
	}

	public String getOs() {
		return _os;
	}

	public void setOs(String os) {
		_os = os;
	}

	public String getOsVersion() {
		return _osVersion;
	}

	public void setOsVersion(String osVersion) {
		_osVersion = osVersion;
	}

	public String getBrowser() {
		return _browser;
	}

	public void setBrowser(String browser) {
		_browser = browser;
	}

	public String getBrowserVersion() {
		return _browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		_browserVersion = browserVersion;
	}

	public String getPointingMethod() {
		return _pointingMethod;
	}

	public void setPointingMethod(String pointingMethod) {
		_pointingMethod = pointingMethod;
	}

	public String getTablet() {
		return _tablet;
	}

	public void setTablet(String tablet) {
		_tablet = tablet;
	}

	public String getQwertyKeyboad() {
		return _qwertyKeyboad;
	}

	public void setQwertyKeyboad(String qwertyKeyboad) {
		_qwertyKeyboad = qwertyKeyboad;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getThemeId() {
		return _themeId;
	}

	public void setThemeId(String themeId) {
		_themeId = themeId;
	}

	public String getColorSchemeId() {
		return _colorSchemeId;
	}

	public void setColorSchemeId(String colorSchemeId) {
		_colorSchemeId = colorSchemeId;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	private long _rid;
	private long _companyId;
	private long _groupId;
	private long _layoutId;
	private String _brand;
	private String _model;
	private String _os;
	private String _osVersion;
	private String _browser;
	private String _browserVersion;
	private String _pointingMethod;
	private String _tablet;
	private String _qwertyKeyboad;
	private String _action;
	private String _themeId;
	private String _colorSchemeId;
	private String _url;
	private int _priority;
}