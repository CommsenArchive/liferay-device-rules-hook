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

package com.commsen.liferay.multidevice.rules.service.impl;

import java.util.Collections;
import java.util.List;

import com.commsen.liferay.multidevice.Device;
import com.commsen.liferay.multidevice.rules.model.Rule;
import com.commsen.liferay.multidevice.rules.service.base.RuleLocalServiceBaseImpl;
import com.commsen.liferay.multidevice.rules.service.persistence.RuleUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.commsen.liferay.multidevice.rules.service.RuleLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.commsen.liferay.multidevice.rules.service.RuleLocalServiceUtil} to access the rule local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Milen Dyankov
 * @see com.commsen.liferay.multidevice.rules.service.base.RuleLocalServiceBaseImpl
 * @see com.commsen.liferay.multidevice.rules.service.RuleLocalServiceUtil
 */
public class RuleLocalServiceImpl extends RuleLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(RuleLocalServiceImpl.class);


	/**
	 * Returns list of all rules for given company and group
	 * 
	 * @param companyId company (instance) id
	 * @param groupId group (community/organization) id
	 * @return list of all rules for given company and group
	 */
	public List<Rule> getRules(long companyId, long groupId) {
		List<Rule> result = Collections.emptyList();
		try {
			result = RuleUtil.findByGroup(companyId, groupId);
		} catch (SystemException e) {
			_log.error("Failed to load theme rules!", e);
		}
		return result;
	}


	/**
	 * Returns list of all rules for given company, group and layout
	 * 
	 * @param companyId company (instance) id
	 * @param groupId group (community/organization) id
	 * @param layoutId layout (page) id
	 * @return list of all rules for given company, group and layout
	 */
	public List<Rule> getRules(long companyId, long groupId, long layoutId) {
		List<Rule> result = Collections.emptyList();
		try {
			result = RuleUtil.findByPage(companyId, groupId, layoutId);
		} catch (SystemException e) {
			_log.error("Failed to load theme rules!", e);
		}
		return result;
	}


	/**
	 * Returns list of rules matching the company, group, layout and user's device.
	 * 
	 * @param companyId company (instance) id
	 * @param groupId group (community/organization) id
	 * @param layoutId layout (page) id
	 * @param device user's device
	 * @action the rule action type (change theme, redirect)
	 * @return list of rules matching the company, group, layout and user's device.
	 */
	public List<Rule> getMatchingRules(long companyId, long groupId, long layoutId, Device device) {
		List<Rule> result = Collections.emptyList();

		// Brand and model query part
		Junction modelMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		modelMatchesOrNull.add(PropertyFactoryUtil.forName("model").eq(device.getModel()));
		modelMatchesOrNull.add(PropertyFactoryUtil.forName("model").isNull());

		Junction brandMatchesAndModelMatchesOrNull = RestrictionsFactoryUtil.conjunction();
		brandMatchesAndModelMatchesOrNull.add(PropertyFactoryUtil.forName("brand").eq(device.getBrand()));
		brandMatchesAndModelMatchesOrNull.add(modelMatchesOrNull);

		Junction brandNullOrMatchesWithModelMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		brandNullOrMatchesWithModelMatchesOrNull.add(PropertyFactoryUtil.forName("brand").isNull());
		brandNullOrMatchesWithModelMatchesOrNull.add(brandMatchesAndModelMatchesOrNull);

		// Operating system query part
		Junction osVersionMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		osVersionMatchesOrNull.add(PropertyFactoryUtil.forName("osVersion").eq(device.getOSVersion()));
		osVersionMatchesOrNull.add(PropertyFactoryUtil.forName("osVersion").isNull());

		Junction osNameMatchesAndOsVersionMathcesOrNull = RestrictionsFactoryUtil.conjunction();
		osNameMatchesAndOsVersionMathcesOrNull.add(PropertyFactoryUtil.forName("os").eq(device.getOS()));
		osNameMatchesAndOsVersionMathcesOrNull.add(osVersionMatchesOrNull);

		Junction osNameNullOrMatchesWithOsVersionMathcesOrNull = RestrictionsFactoryUtil.disjunction();
		osNameNullOrMatchesWithOsVersionMathcesOrNull.add(PropertyFactoryUtil.forName("os").isNull());
		osNameNullOrMatchesWithOsVersionMathcesOrNull.add(osNameMatchesAndOsVersionMathcesOrNull);

		// Browser query part
		Junction browserVersionMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		browserVersionMatchesOrNull.add(PropertyFactoryUtil.forName("browserVersion").eq(device.getBrowserVersion()));
		browserVersionMatchesOrNull.add(PropertyFactoryUtil.forName("browserVersion").isNull());

		Junction browserNameMatchesAndBrowserVersionMathcesOrNull = RestrictionsFactoryUtil.conjunction();
		browserNameMatchesAndBrowserVersionMathcesOrNull.add(PropertyFactoryUtil.forName("browser").eq(
		        device.getBrowser()));
		browserNameMatchesAndBrowserVersionMathcesOrNull.add(browserVersionMatchesOrNull);

		Junction browserNameNullOrMatchesWithBrowserVersionMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		browserNameNullOrMatchesWithBrowserVersionMatchesOrNull.add(PropertyFactoryUtil.forName("browser").isNull());
		browserNameNullOrMatchesWithBrowserVersionMatchesOrNull.add(browserNameMatchesAndBrowserVersionMathcesOrNull);

		// Pointing device query part
		Junction pointingMethodMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		pointingMethodMatchesOrNull.add(PropertyFactoryUtil.forName("pointingMethod").eq(device.getPointingMethod()));
		pointingMethodMatchesOrNull.add(PropertyFactoryUtil.forName("pointingMethod").isNull());

		// Is tablet query part
		Junction tabletMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		tabletMatchesOrNull.add(PropertyFactoryUtil.forName("tablet").eq(Boolean.toString(device.isTablet())));
		tabletMatchesOrNull.add(PropertyFactoryUtil.forName("tablet").isNull());

		// Has qwerty keyboard query part
		Junction qwertyKeyboardMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		qwertyKeyboardMatchesOrNull.add(PropertyFactoryUtil.forName("qwertyKeyboad").eq(
		        Boolean.toString(device.hasQwertyKeyboard())));
		qwertyKeyboardMatchesOrNull.add(PropertyFactoryUtil.forName("qwertyKeyboad").isNull());

		// Page query part
		Junction pageMatchesOrNull = RestrictionsFactoryUtil.disjunction();
		pageMatchesOrNull.add(PropertyFactoryUtil.forName("layoutId").eq(0l));
		pageMatchesOrNull.add(PropertyFactoryUtil.forName("layoutId").eq(layoutId));

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Rule.class);
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		dynamicQuery.add(pageMatchesOrNull);
		dynamicQuery.add(brandNullOrMatchesWithModelMatchesOrNull);
		dynamicQuery.add(osNameNullOrMatchesWithOsVersionMathcesOrNull);
		dynamicQuery.add(browserNameNullOrMatchesWithBrowserVersionMatchesOrNull);
		dynamicQuery.add(pointingMethodMatchesOrNull);
		dynamicQuery.add(tabletMatchesOrNull);
		dynamicQuery.add(qwertyKeyboardMatchesOrNull);
		dynamicQuery.addOrder(OrderFactoryUtil.asc("priority"));

		try {
			result = RuleUtil.findWithDynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			_log.error("Failed to find theme rules matching " + device, e);
		}
		return result;
	}

}