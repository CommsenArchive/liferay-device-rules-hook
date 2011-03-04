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

/**
 * <p>
 * This class is a wrapper for {@link Rule}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       Rule
 * @generated
 */
public class RuleWrapper implements Rule {
	public RuleWrapper(Rule rule) {
		_rule = rule;
	}

	public long getPrimaryKey() {
		return _rule.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_rule.setPrimaryKey(pk);
	}

	public long getRid() {
		return _rule.getRid();
	}

	public void setRid(long rid) {
		_rule.setRid(rid);
	}

	public long getCompanyId() {
		return _rule.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_rule.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _rule.getGroupId();
	}

	public void setGroupId(long groupId) {
		_rule.setGroupId(groupId);
	}

	public long getLayoutId() {
		return _rule.getLayoutId();
	}

	public void setLayoutId(long layoutId) {
		_rule.setLayoutId(layoutId);
	}

	public java.lang.String getBrand() {
		return _rule.getBrand();
	}

	public void setBrand(java.lang.String brand) {
		_rule.setBrand(brand);
	}

	public java.lang.String getModel() {
		return _rule.getModel();
	}

	public void setModel(java.lang.String model) {
		_rule.setModel(model);
	}

	public java.lang.String getOs() {
		return _rule.getOs();
	}

	public void setOs(java.lang.String os) {
		_rule.setOs(os);
	}

	public java.lang.String getOsVersion() {
		return _rule.getOsVersion();
	}

	public void setOsVersion(java.lang.String osVersion) {
		_rule.setOsVersion(osVersion);
	}

	public java.lang.String getBrowser() {
		return _rule.getBrowser();
	}

	public void setBrowser(java.lang.String browser) {
		_rule.setBrowser(browser);
	}

	public java.lang.String getBrowserVersion() {
		return _rule.getBrowserVersion();
	}

	public void setBrowserVersion(java.lang.String browserVersion) {
		_rule.setBrowserVersion(browserVersion);
	}

	public java.lang.String getPointingMethod() {
		return _rule.getPointingMethod();
	}

	public void setPointingMethod(java.lang.String pointingMethod) {
		_rule.setPointingMethod(pointingMethod);
	}

	public java.lang.String getTablet() {
		return _rule.getTablet();
	}

	public void setTablet(java.lang.String tablet) {
		_rule.setTablet(tablet);
	}

	public java.lang.String getQwertyKeyboad() {
		return _rule.getQwertyKeyboad();
	}

	public void setQwertyKeyboad(java.lang.String qwertyKeyboad) {
		_rule.setQwertyKeyboad(qwertyKeyboad);
	}

	public java.lang.String getAction() {
		return _rule.getAction();
	}

	public void setAction(java.lang.String action) {
		_rule.setAction(action);
	}

	public java.lang.String getThemeId() {
		return _rule.getThemeId();
	}

	public void setThemeId(java.lang.String themeId) {
		_rule.setThemeId(themeId);
	}

	public java.lang.String getColorSchemeId() {
		return _rule.getColorSchemeId();
	}

	public void setColorSchemeId(java.lang.String colorSchemeId) {
		_rule.setColorSchemeId(colorSchemeId);
	}

	public java.lang.String getUrl() {
		return _rule.getUrl();
	}

	public void setUrl(java.lang.String url) {
		_rule.setUrl(url);
	}

	public int getPriority() {
		return _rule.getPriority();
	}

	public void setPriority(int priority) {
		_rule.setPriority(priority);
	}

	public com.commsen.liferay.multidevice.rules.model.Rule toEscapedModel() {
		return _rule.toEscapedModel();
	}

	public boolean isNew() {
		return _rule.isNew();
	}

	public void setNew(boolean n) {
		_rule.setNew(n);
	}

	public boolean isCachedModel() {
		return _rule.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_rule.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _rule.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_rule.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _rule.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rule.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rule.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _rule.clone();
	}

	public int compareTo(com.commsen.liferay.multidevice.rules.model.Rule rule) {
		return _rule.compareTo(rule);
	}

	public int hashCode() {
		return _rule.hashCode();
	}

	public java.lang.String toString() {
		return _rule.toString();
	}

	public java.lang.String toXmlString() {
		return _rule.toXmlString();
	}

	public Rule getWrappedRule() {
		return _rule;
	}

	private Rule _rule;
}