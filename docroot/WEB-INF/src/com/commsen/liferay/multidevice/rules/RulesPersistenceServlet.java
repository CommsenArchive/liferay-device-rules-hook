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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.commsen.liferay.multidevice.rules.actions.ChangeThemeAction;
import com.commsen.liferay.multidevice.rules.actions.RedirectAction;
import com.commsen.liferay.multidevice.rules.model.Rule;
import com.commsen.liferay.multidevice.rules.service.RuleLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class RulesPersistenceServlet extends HttpServlet {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	private static final String COMMAND_SAVE = "save_theme_rule";

	private static final String COMMAND_DELETE = "delete_theme_rule";

	private static final String PORTLET_PREFIX = "_88_";

	private static final String PARAM_CMD = PORTLET_PREFIX + "cmd";

	private static final String PARAM_HAS_QWERTY_KEYBOARD = PORTLET_PREFIX + "hasQwertyKeyboard";

	private static final String PARAM_IS_TABLET = PORTLET_PREFIX + "isTablet";

	private static final String PARAM_POINTING_METHOD = PORTLET_PREFIX + "pointingMethod";

	private static final String PARAM_BROWSER_VERSION = PORTLET_PREFIX + "browserVersion";

	private static final String PARAM_BROWSER = PORTLET_PREFIX + "browser";

	private static final String PARAM_OS_VERSION = PORTLET_PREFIX + "osVersion";

	private static final String PARAM_OS = PORTLET_PREFIX + "os";

	private static final String PARAM_MODEL = PORTLET_PREFIX + "model";

	private static final String PARAM_BRAND = PORTLET_PREFIX + "brand";

	private static final String PARAM_LIVE_GROUP_ID = PORTLET_PREFIX + "liveGroupId";

	private static final String PARAM_RULE_PRIORITY = PORTLET_PREFIX + "rulePriority";

	private static final String PARAM_DYNAMIC_COLOR_SCHEME_ID = PORTLET_PREFIX + "dynamicColorSchemeId";

	private static final String PARAM_DYNAMIC_THEME_ID = PORTLET_PREFIX + "dynamicThemeId";

	private static final String PARAM_LAYPOUT_ID = PORTLET_PREFIX + "selPlid";

	private static final String PARAM_REDIRECT = PORTLET_PREFIX + "pagesRedirect";

	private static final String PARAM_DELETE_RULE_ID = PORTLET_PREFIX + "deleteRuleId";

	private static final String PARAM_RULE_ACTION = PORTLET_PREFIX + "ruleAction";

	private static final String PARAM_REDIRECT_RULE_URL = PORTLET_PREFIX + "redirectRuleURL";


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	                                                                               IOException {

		// TODO implement security check !!!

		String cmd = ParamUtil.getString(request, PARAM_CMD);

		if (COMMAND_SAVE.equals(cmd)) saveRule(request, response);
		if (COMMAND_DELETE.equals(cmd)) deleteRule(request, response);

		response.sendRedirect(ParamUtil.getString(request, PARAM_REDIRECT));
	}


	private void deleteRule(HttpServletRequest request, HttpServletResponse response) {
		long ruleId = ParamUtil.getLong(request, PARAM_DELETE_RULE_ID);
		try {
			RuleLocalServiceUtil.deleteRule(ruleId);
		} catch (PortalException e) {
			log("Failed to delete theme rule!", e);
			return;
		} catch (SystemException e) {
			log("Failed to delete theme rule!", e);
		}
	}


	protected void saveRule(HttpServletRequest request, HttpServletResponse response) {

		Rule themeRule;
		try {
			themeRule = RuleLocalServiceUtil.createRule(CounterLocalServiceUtil.increment(Rule.class.getName()));
		} catch (SystemException e) {
			log("Failed to create theme rule!", e);
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
			log("Rule is empty. Not saved!");
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
			log("Failed to save theme rule!", e);
			return;
		}

	}
}
