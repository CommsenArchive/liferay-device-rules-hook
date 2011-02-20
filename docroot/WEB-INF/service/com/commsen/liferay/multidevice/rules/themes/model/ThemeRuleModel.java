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

package com.commsen.liferay.multidevice.rules.themes.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ThemeRule service. Represents a row in the &quot;MultiDevice_ThemeRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a theme rule model instance should use the {@link ThemeRule} interface instead.
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRule
 * @see com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleImpl
 * @see com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleModelImpl
 * @generated
 */
public interface ThemeRuleModel extends BaseModel<ThemeRule> {
	/**
	 * Gets the primary key of this theme rule.
	 *
	 * @return the primary key of this theme rule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this theme rule
	 *
	 * @param pk the primary key of this theme rule
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the rid of this theme rule.
	 *
	 * @return the rid of this theme rule
	 */
	public long getRid();

	/**
	 * Sets the rid of this theme rule.
	 *
	 * @param rid the rid of this theme rule
	 */
	public void setRid(long rid);

	/**
	 * Gets the company id of this theme rule.
	 *
	 * @return the company id of this theme rule
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this theme rule.
	 *
	 * @param companyId the company id of this theme rule
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this theme rule.
	 *
	 * @return the group id of this theme rule
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this theme rule.
	 *
	 * @param groupId the group id of this theme rule
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the layout id of this theme rule.
	 *
	 * @return the layout id of this theme rule
	 */
	public long getLayoutId();

	/**
	 * Sets the layout id of this theme rule.
	 *
	 * @param layoutId the layout id of this theme rule
	 */
	public void setLayoutId(long layoutId);

	/**
	 * Gets the brand of this theme rule.
	 *
	 * @return the brand of this theme rule
	 */
	@AutoEscape
	public String getBrand();

	/**
	 * Sets the brand of this theme rule.
	 *
	 * @param brand the brand of this theme rule
	 */
	public void setBrand(String brand);

	/**
	 * Gets the model of this theme rule.
	 *
	 * @return the model of this theme rule
	 */
	@AutoEscape
	public String getModel();

	/**
	 * Sets the model of this theme rule.
	 *
	 * @param model the model of this theme rule
	 */
	public void setModel(String model);

	/**
	 * Gets the os of this theme rule.
	 *
	 * @return the os of this theme rule
	 */
	@AutoEscape
	public String getOs();

	/**
	 * Sets the os of this theme rule.
	 *
	 * @param os the os of this theme rule
	 */
	public void setOs(String os);

	/**
	 * Gets the os version of this theme rule.
	 *
	 * @return the os version of this theme rule
	 */
	@AutoEscape
	public String getOsVersion();

	/**
	 * Sets the os version of this theme rule.
	 *
	 * @param osVersion the os version of this theme rule
	 */
	public void setOsVersion(String osVersion);

	/**
	 * Gets the browser of this theme rule.
	 *
	 * @return the browser of this theme rule
	 */
	@AutoEscape
	public String getBrowser();

	/**
	 * Sets the browser of this theme rule.
	 *
	 * @param browser the browser of this theme rule
	 */
	public void setBrowser(String browser);

	/**
	 * Gets the browser version of this theme rule.
	 *
	 * @return the browser version of this theme rule
	 */
	@AutoEscape
	public String getBrowserVersion();

	/**
	 * Sets the browser version of this theme rule.
	 *
	 * @param browserVersion the browser version of this theme rule
	 */
	public void setBrowserVersion(String browserVersion);

	/**
	 * Gets the pointing method of this theme rule.
	 *
	 * @return the pointing method of this theme rule
	 */
	@AutoEscape
	public String getPointingMethod();

	/**
	 * Sets the pointing method of this theme rule.
	 *
	 * @param pointingMethod the pointing method of this theme rule
	 */
	public void setPointingMethod(String pointingMethod);

	/**
	 * Gets the tablet of this theme rule.
	 *
	 * @return the tablet of this theme rule
	 */
	@AutoEscape
	public String getTablet();

	/**
	 * Sets the tablet of this theme rule.
	 *
	 * @param tablet the tablet of this theme rule
	 */
	public void setTablet(String tablet);

	/**
	 * Gets the qwerty keyboad of this theme rule.
	 *
	 * @return the qwerty keyboad of this theme rule
	 */
	@AutoEscape
	public String getQwertyKeyboad();

	/**
	 * Sets the qwerty keyboad of this theme rule.
	 *
	 * @param qwertyKeyboad the qwerty keyboad of this theme rule
	 */
	public void setQwertyKeyboad(String qwertyKeyboad);

	/**
	 * Gets the theme id of this theme rule.
	 *
	 * @return the theme id of this theme rule
	 */
	@AutoEscape
	public String getThemeId();

	/**
	 * Sets the theme id of this theme rule.
	 *
	 * @param themeId the theme id of this theme rule
	 */
	public void setThemeId(String themeId);

	/**
	 * Gets the color scheme id of this theme rule.
	 *
	 * @return the color scheme id of this theme rule
	 */
	@AutoEscape
	public String getColorSchemeId();

	/**
	 * Sets the color scheme id of this theme rule.
	 *
	 * @param colorSchemeId the color scheme id of this theme rule
	 */
	public void setColorSchemeId(String colorSchemeId);

	/**
	 * Gets the priority of this theme rule.
	 *
	 * @return the priority of this theme rule
	 */
	public int getPriority();

	/**
	 * Sets the priority of this theme rule.
	 *
	 * @param priority the priority of this theme rule
	 */
	public void setPriority(int priority);

	/**
	 * Gets a copy of this theme rule as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ThemeRule toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ThemeRule themeRule);

	public int hashCode();

	public String toString();

	public String toXmlString();
}