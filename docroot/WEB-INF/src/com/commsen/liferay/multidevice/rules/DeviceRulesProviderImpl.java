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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.rules.actions.DeviceAction;
import com.commsen.liferay.multidevice.rules.actions.NoAction;
import com.commsen.liferay.multidevice.rules.model.Rule;
import com.commsen.liferay.multidevice.rules.service.RuleLocalServiceUtil;

public class DeviceRulesProviderImpl implements DeviceRulesProvider {

	@Override
	public DeviceAction getAction (Device device, long companyId, long groupId, long layoutId) {
		List<Rule> rules = RuleLocalServiceUtil.getMatchingRules(companyId, groupId, layoutId, device);
		if (rules == null || rules.isEmpty()) return new NoAction();
		return RulesUtils.createAction(rules.get(0));
	}

	@Override
	public List<RuleInfo> getRules (long companyId, long groupId, long layoutId) {
		List<Rule> rules = RuleLocalServiceUtil.getRules(companyId, groupId, layoutId);
		if (rules == null || rules.isEmpty()) return Collections.emptyList();
		List<RuleInfo> result = new LinkedList<RuleInfo>();
		for (Rule themeRule : rules) {
			result.add(RulesUtils.convertToRuleInfo(themeRule));
		}
		return result;
	}



}
