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
package com.commsen.liferay.multidevice.rules.themes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.rules.themes.model.ThemeRule;
import com.commsen.liferay.multidevice.rules.themes.service.ThemeRuleLocalServiceUtil;

public class RuleBasedThemeSelectingProvider implements ThemeSelectingProvider {

	@Override
	public ThemeAndColorScheme getThemeAndColorScheme(Device device, long companyId, long groupId, long layoutId) {
		List<ThemeRule> rules = ThemeRuleLocalServiceUtil.getMatchingRules(companyId, groupId, layoutId, device);
		if (rules == null || rules.isEmpty()) return new ThemeAndColorScheme(null, null);
		return new ThemeAndColorScheme(rules.get(0).getThemeId(), rules.get(0).getColorSchemeId());
	}


	@Override
	public List<ThemeRuleInfo> getThemeRulesInfo(long companyId, long groupId, long layoutId) {
		List<ThemeRule> rules = ThemeRuleLocalServiceUtil.getRules(companyId, groupId, layoutId);
		if (rules == null || rules.isEmpty()) return Collections.emptyList();
		List<ThemeRuleInfo> result = new LinkedList<ThemeRuleInfo>();
		for (ThemeRule themeRule : rules) {
			result.add(convert(themeRule));
		}
		return result;
	}


	public ThemeRuleInfo convert(ThemeRule themeRule) {

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

		ThemeAndColorScheme themeAndColorScheme = new ThemeAndColorScheme(themeRule.getThemeId(),
		        themeRule.getColorSchemeId());
		ThemeRuleInfo themeRuleInfo = new ThemeRuleInfo(themeRule.getRid(), text.toString(), themeRule.getPriority(),
		        themeAndColorScheme);
		return themeRuleInfo;
	}
}
