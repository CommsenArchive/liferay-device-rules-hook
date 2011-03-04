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
package com.commsen.liferay.multidevice.rules;

import org.apache.log4j.Logger;

import com.commsen.liferay.multidevice.rules.actions.ChangeThemeAction;
import com.commsen.liferay.multidevice.rules.actions.DeviceAction;
import com.commsen.liferay.multidevice.rules.actions.NoAction;
import com.commsen.liferay.multidevice.rules.actions.RedirectAction;
import com.commsen.liferay.multidevice.rules.model.Rule;

public class RulesUtils {

	private static final Logger log = Logger.getLogger(RulesUtils.class);

	public static DeviceAction createAction (Rule themeRule) {
		
		if (themeRule == null) return new NoAction();
		
		if (ChangeThemeAction.NAME.equals(themeRule.getAction())) {
			ThemeAndColorScheme themeAndColorScheme = new ThemeAndColorScheme(themeRule.getThemeId(), themeRule.getColorSchemeId());
			return new ChangeThemeAction(themeAndColorScheme);
		}
		
		if (RedirectAction.NAME.equals(themeRule.getAction())) {
			return new RedirectAction(themeRule.getUrl());
		}
		
		log.warn("Unknown action: " + themeRule.getAction());
		return new NoAction();

	}
	
	public static RuleInfo convertToRuleInfo(Rule themeRule) {

		boolean addAnd = false;
		StringBuilder text = new StringBuilder("When ");
		if (themeRule.getBrand() != null) {
			if (addAnd) text.append(" and ");
			text.append(" brand is ").append(themeRule.getBrand());
			addAnd = true;
		}
		if (themeRule.getModel() != null) {
			if (addAnd) text.append(" and ");
			text.append(" model is ").append(themeRule.getModel());
			addAnd = true;
		}
		if (themeRule.getOs() != null) {
			if (addAnd) text.append(" and ");
			text.append(" operating system is ").append(themeRule.getOs());
			addAnd = true;
			if (themeRule.getOsVersion() != null) {
				text.append("(").append(themeRule.getOsVersion()).append(") ");
				addAnd = true;
			}
		}
		if (themeRule.getBrowser() != null) {
			if (addAnd) text.append(" and ");
			text.append(" browser is ").append(themeRule.getBrowser());
			addAnd = true;
			if (themeRule.getBrowserVersion() != null) {
				text.append("(").append(themeRule.getBrowserVersion()).append(") ");
				addAnd = true;
			}
		}
		if (themeRule.getPointingMethod() != null) {
			if (addAnd) text.append(" and ");
			text.append(" pointing method is ").append(themeRule.getPointingMethod());
			addAnd = true;
		}
		if (themeRule.getTablet() != null) {
			if (addAnd) text.append(" and ");
			if (Boolean.parseBoolean(themeRule.getTablet())) {
				text.append(" device is tablet ");
			} else {
				text.append(" device is not tablet ");
			}
			addAnd = true;
		}
		if (themeRule.getQwertyKeyboad() != null) {
			if (addAnd) text.append(" and ");
			if (Boolean.parseBoolean(themeRule.getQwertyKeyboad())) {
				text.append(" device has qwerty keyboard ");
			} else {
				text.append(" device does not have qwerty keyboard ");
			}
			addAnd = true;
		}

		RuleInfo themeRuleInfo = new RuleInfo(themeRule.getRid(), text.toString(), themeRule.getPriority(), createAction(themeRule));
		return themeRuleInfo;
	}


}
