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
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.rules.actions.ChangeThemeAction;
import com.commsen.liferay.multidevice.rules.actions.DeviceAction;
import com.commsen.liferay.multidevice.rules.actions.NoAction;
import com.commsen.liferay.multidevice.rules.actions.RedirectAction;
import com.commsen.liferay.multidevice.rules.model.Rule;
import com.commsen.liferay.multidevice.rules.service.RuleLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class DeviceRulesProviderImpl implements DeviceRulesProvider {

	private static final Logger log = Logger.getLogger(DeviceRulesProviderImpl.class);
	
	private static final String COMMAND_SAVE = "save_theme_rule";

	private static final String COMMAND_DELETE = "delete_theme_rule";

	private static final String PARAM_CMD = "cmd";

	private static final String PARAM_HAS_QWERTY_KEYBOARD = "hasQwertyKeyboard";

	private static final String PARAM_IS_TABLET = "isTablet";

	private static final String PARAM_POINTING_METHOD = "pointingMethod";

	private static final String PARAM_BROWSER_VERSION = "browserVersion";

	private static final String PARAM_BROWSER = "browser";

	private static final String PARAM_OS_VERSION = "osVersion";

	private static final String PARAM_OS = "os";

	private static final String PARAM_MODEL = "model";

	private static final String PARAM_BRAND = "brand";

	private static final String PARAM_LIVE_GROUP_ID = "liveGroupId";

	private static final String PARAM_RULE_PRIORITY = "rulePriority";

	private static final String PARAM_DYNAMIC_COLOR_SCHEME_ID = "dynamicColorSchemeId";

	private static final String PARAM_DYNAMIC_THEME_ID = "dynamicThemeId";

	private static final String PARAM_LAYPOUT_ID = "selPlid";

	private static final String PARAM_DELETE_RULE_ID = "deleteRuleId";

	private static final String PARAM_RULE_ACTION = "ruleAction";

	private static final String PARAM_REDIRECT_RULE_URL = "redirectRuleURL";
	
	
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

	@Override
    public List<String> handleRulesRequest(PortletRequest request) {
		
		String cmd = ParamUtil.getString(request, PARAM_CMD);

		List<String> errorMessages = new LinkedList<String>();
		if (COMMAND_SAVE.equals(cmd)) saveRule(request, errorMessages);
		if (COMMAND_DELETE.equals(cmd)) deleteRule(request, errorMessages);
		return errorMessages;
    }

	private void deleteRule(PortletRequest request, List<String> errorMessages) {
		long ruleId = ParamUtil.getLong(request, PARAM_DELETE_RULE_ID);
		try {
			RuleLocalServiceUtil.deleteRule(ruleId);
		} catch (PortalException e) {
			errorMessages.add("failed-to-delete-rule");
			log.error("Failed to delete device rule!", e);
		} catch (SystemException e) {
			errorMessages.add("failed-to-delete-rule");
			log.error("Failed to delete device rule!", e);
		}
	}


	protected void saveRule(PortletRequest request, List<String> errorMessages) {

		Rule themeRule;
		try {
			themeRule = RuleLocalServiceUtil.createRule(CounterLocalServiceUtil.increment(Rule.class.getName()));
		} catch (SystemException e) {
			errorMessages.add("failed-to-create-rule");
			log.error("Failed to create device rule!", e);
			return;
		}

		// rule context
		themeRule.setCompanyId(PortalUtil.getCompanyId(request));
		themeRule.setGroupId(ParamUtil.getLong(request, PARAM_LIVE_GROUP_ID, 0));
		themeRule.setLayoutId(ParamUtil.getLong(request, PARAM_LAYPOUT_ID, 0));

		// rule parameters
		boolean emptyRule = true;

		String tmp = ParamUtil.getString(request, PARAM_BRAND, null);
		if (!StringUtils.isBlank(tmp)) {
			emptyRule = false;
			themeRule.setBrand(tmp);
		}
		tmp = ParamUtil.getString(request, PARAM_MODEL, null);
		if (!StringUtils.isBlank(tmp)) {
			emptyRule = false;
			themeRule.setModel(tmp);
		}
		tmp = ParamUtil.getString(request, PARAM_OS, null);
		if (!StringUtils.isBlank(tmp)) {
			emptyRule = false;
			themeRule.setOs(tmp);
		}
		tmp = ParamUtil.getString(request, PARAM_OS_VERSION, null);
		if (!StringUtils.isBlank(tmp)) {
			emptyRule = false;
			themeRule.setOsVersion(tmp);
		}
		tmp = ParamUtil.getString(request, PARAM_BROWSER, null);
		if (!StringUtils.isBlank(tmp)) {
			emptyRule = false;
			themeRule.setBrowser(tmp);
		}
		tmp = ParamUtil.getString(request, PARAM_BROWSER_VERSION, null);
		if (!StringUtils.isBlank(tmp)) {
			emptyRule = false;
			themeRule.setBrowserVersion(tmp);
		}
		tmp = ParamUtil.getString(request, PARAM_POINTING_METHOD, null);
		if (!StringUtils.isBlank(tmp)) {
			emptyRule = false;
			themeRule.setPointingMethod(tmp);
		}
		tmp = ParamUtil.getString(request, PARAM_IS_TABLET, null);
		if ("yes".equalsIgnoreCase(tmp)) {
			emptyRule = false;
			themeRule.setTablet(Boolean.TRUE.toString());
		} else if ("no".equalsIgnoreCase(tmp)) {
			emptyRule = false;
			themeRule.setTablet(Boolean.FALSE.toString());
		}
		tmp = ParamUtil.getString(request, PARAM_HAS_QWERTY_KEYBOARD, null);
		if ("yes".equalsIgnoreCase(tmp)) {
			emptyRule = false;
			themeRule.setQwertyKeyboad(Boolean.TRUE.toString());
		} else if ("no".equalsIgnoreCase(tmp)) {
			emptyRule = false;
			themeRule.setQwertyKeyboad(Boolean.FALSE.toString());
		}

		if (emptyRule) {
			errorMessages.add("rule-is-empty");
			log.error("Rule is empty. Not saved!");
			return;
		}

		String action = ParamUtil.getString(request, PARAM_RULE_ACTION, ChangeThemeAction.NAME);
		if (ChangeThemeAction.NAME.equalsIgnoreCase(action)) {
			themeRule.setAction(ChangeThemeAction.NAME);
			String themeId = ParamUtil.getString(request, PARAM_DYNAMIC_THEME_ID);
			String colorSchemeId = ParamUtil.getString(request, PARAM_DYNAMIC_COLOR_SCHEME_ID);
			themeRule.setThemeId(themeId);
			themeRule.setColorSchemeId(colorSchemeId);
		}

		if (RedirectAction.NAME.equalsIgnoreCase(action)) {
			themeRule.setAction(RedirectAction.NAME);
			String redirectRuleURL = ParamUtil.getString(request, PARAM_REDIRECT_RULE_URL);
			themeRule.setUrl(redirectRuleURL);
		}

		int priority = ParamUtil.getInteger(request, PARAM_RULE_PRIORITY, 100);
		themeRule.setPriority(priority);

		// save
		try {
			RuleLocalServiceUtil.addRule(themeRule);
		} catch (SystemException e) {
			errorMessages.add("failed-to-save-rule");
			log.error("Failed to save theme rule!", e);
			return;
		}

	}


}
