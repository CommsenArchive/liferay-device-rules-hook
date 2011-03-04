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

package com.commsen.liferay.multidevice.rules.service;

/**
 * <p>
 * This class is a wrapper for {@link RuleLocalService}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       RuleLocalService
 * @generated
 */
public class RuleLocalServiceWrapper implements RuleLocalService {
	public RuleLocalServiceWrapper(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	/**
	* Adds the rule to the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule to add
	* @return the rule that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.rules.model.Rule addRule(
		com.commsen.liferay.multidevice.rules.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.addRule(rule);
	}

	/**
	* Creates a new rule with the primary key. Does not add the rule to the database.
	*
	* @param rid the primary key for the new rule
	* @return the new rule
	*/
	public com.commsen.liferay.multidevice.rules.model.Rule createRule(long rid) {
		return _ruleLocalService.createRule(rid);
	}

	/**
	* Deletes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rid the primary key of the rule to delete
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRule(long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ruleLocalService.deleteRule(rid);
	}

	/**
	* Deletes the rule from the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRule(
		com.commsen.liferay.multidevice.rules.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ruleLocalService.deleteRule(rule);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the rule with the primary key.
	*
	* @param rid the primary key of the rule to get
	* @return the rule
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.rules.model.Rule getRule(long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRule(rid);
	}

	/**
	* Gets a range of all the rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rules to return
	* @param end the upper bound of the range of rules to return (not inclusive)
	* @return the range of rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.commsen.liferay.multidevice.rules.model.Rule> getRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRules(start, end);
	}

	/**
	* Gets the number of rules.
	*
	* @return the number of rules
	* @throws SystemException if a system exception occurred
	*/
	public int getRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRulesCount();
	}

	/**
	* Updates the rule in the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule to update
	* @return the rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.rules.model.Rule updateRule(
		com.commsen.liferay.multidevice.rules.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.updateRule(rule);
	}

	/**
	* Updates the rule in the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule to update
	* @param merge whether to merge the rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.commsen.liferay.multidevice.rules.model.Rule updateRule(
		com.commsen.liferay.multidevice.rules.model.Rule rule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.updateRule(rule, merge);
	}

	/**
	* Returns list of all rules for given company and group
	*
	* @param companyId company (instance) id
	* @param groupId group (community/organization) id
	* @return list of all rules for given company and group
	*/
	public java.util.List<com.commsen.liferay.multidevice.rules.model.Rule> getRules(
		long companyId, long groupId) {
		return _ruleLocalService.getRules(companyId, groupId);
	}

	/**
	* Returns list of all rules for given company, group and layout
	*
	* @param companyId company (instance) id
	* @param groupId group (community/organization) id
	* @param layoutId layout (page) id
	* @return list of all rules for given company, group and layout
	*/
	public java.util.List<com.commsen.liferay.multidevice.rules.model.Rule> getRules(
		long companyId, long groupId, long layoutId) {
		return _ruleLocalService.getRules(companyId, groupId, layoutId);
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
	public java.util.List<com.commsen.liferay.multidevice.rules.model.Rule> getMatchingRules(
		long companyId, long groupId, long layoutId,
		com.commsen.liferay.multidevice.Device device) {
		return _ruleLocalService.getMatchingRules(companyId, groupId, layoutId,
			device);
	}

	public RuleLocalService getWrappedRuleLocalService() {
		return _ruleLocalService;
	}

	private RuleLocalService _ruleLocalService;
}