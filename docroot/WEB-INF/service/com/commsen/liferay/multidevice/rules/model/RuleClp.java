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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Milen Dyankov
 */
public class RuleClp extends BaseModelImpl<Rule> implements Rule {
	public RuleClp() {
	}

	public long getPrimaryKey() {
		return _rid;
	}

	public void setPrimaryKey(long pk) {
		setRid(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_rid);
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

	public Rule toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Rule)Proxy.newProxyInstance(Rule.class.getClassLoader(),
				new Class[] { Rule.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		RuleClp clone = new RuleClp();

		clone.setRid(getRid());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setLayoutId(getLayoutId());
		clone.setBrand(getBrand());
		clone.setModel(getModel());
		clone.setOs(getOs());
		clone.setOsVersion(getOsVersion());
		clone.setBrowser(getBrowser());
		clone.setBrowserVersion(getBrowserVersion());
		clone.setPointingMethod(getPointingMethod());
		clone.setTablet(getTablet());
		clone.setQwertyKeyboad(getQwertyKeyboad());
		clone.setAction(getAction());
		clone.setThemeId(getThemeId());
		clone.setColorSchemeId(getColorSchemeId());
		clone.setUrl(getUrl());
		clone.setPriority(getPriority());

		return clone;
	}

	public int compareTo(Rule rule) {
		int value = 0;

		if (getPriority() < rule.getPriority()) {
			value = -1;
		}
		else if (getPriority() > rule.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RuleClp rule = null;

		try {
			rule = (RuleClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = rule.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{rid=");
		sb.append(getRid());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", brand=");
		sb.append(getBrand());
		sb.append(", model=");
		sb.append(getModel());
		sb.append(", os=");
		sb.append(getOs());
		sb.append(", osVersion=");
		sb.append(getOsVersion());
		sb.append(", browser=");
		sb.append(getBrowser());
		sb.append(", browserVersion=");
		sb.append(getBrowserVersion());
		sb.append(", pointingMethod=");
		sb.append(getPointingMethod());
		sb.append(", tablet=");
		sb.append(getTablet());
		sb.append(", qwertyKeyboad=");
		sb.append(getQwertyKeyboad());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", themeId=");
		sb.append(getThemeId());
		sb.append(", colorSchemeId=");
		sb.append(getColorSchemeId());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.commsen.liferay.multidevice.rules.model.Rule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rid</column-name><column-value><![CDATA[");
		sb.append(getRid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brand</column-name><column-value><![CDATA[");
		sb.append(getBrand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>model</column-name><column-value><![CDATA[");
		sb.append(getModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>os</column-name><column-value><![CDATA[");
		sb.append(getOs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>osVersion</column-name><column-value><![CDATA[");
		sb.append(getOsVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>browser</column-name><column-value><![CDATA[");
		sb.append(getBrowser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>browserVersion</column-name><column-value><![CDATA[");
		sb.append(getBrowserVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointingMethod</column-name><column-value><![CDATA[");
		sb.append(getPointingMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tablet</column-name><column-value><![CDATA[");
		sb.append(getTablet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qwertyKeyboad</column-name><column-value><![CDATA[");
		sb.append(getQwertyKeyboad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>themeId</column-name><column-value><![CDATA[");
		sb.append(getThemeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>colorSchemeId</column-name><column-value><![CDATA[");
		sb.append(getColorSchemeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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