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

package com.commsen.liferay.multidevice.rules.themes.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Milen Dyankov
 */
public class ThemeRuleLocalServiceClp implements ThemeRuleLocalService {
	public ThemeRuleLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public com.commsen.liferay.multidevice.rules.themes.model.ThemeRule addThemeRule(
		com.commsen.liferay.multidevice.rules.themes.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addThemeRuleMethodKey0,
				themeRule);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.commsen.liferay.multidevice.rules.themes.model.ThemeRule)ClpSerializer.translateOutput(returnObj);
	}

	public com.commsen.liferay.multidevice.rules.themes.model.ThemeRule createThemeRule(
		long rid) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createThemeRuleMethodKey1,
				rid);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.commsen.liferay.multidevice.rules.themes.model.ThemeRule)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteThemeRule(long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThemeRuleMethodKey2,
				rid);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteThemeRule(
		com.commsen.liferay.multidevice.rules.themes.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThemeRuleMethodKey3,
				themeRule);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				dynamicQuery, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				dynamicQuery, start, end, orderByComparator);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.commsen.liferay.multidevice.rules.themes.model.ThemeRule getThemeRule(
		long rid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThemeRuleMethodKey8,
				rid);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.commsen.liferay.multidevice.rules.themes.model.ThemeRule)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule> getThemeRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThemeRulesMethodKey9,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule>)ClpSerializer.translateOutput(returnObj);
	}

	public int getThemeRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThemeRulesCountMethodKey10);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.commsen.liferay.multidevice.rules.themes.model.ThemeRule updateThemeRule(
		com.commsen.liferay.multidevice.rules.themes.model.ThemeRule themeRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThemeRuleMethodKey11,
				themeRule);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.commsen.liferay.multidevice.rules.themes.model.ThemeRule)ClpSerializer.translateOutput(returnObj);
	}

	public com.commsen.liferay.multidevice.rules.themes.model.ThemeRule updateThemeRule(
		com.commsen.liferay.multidevice.rules.themes.model.ThemeRule themeRule,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThemeRuleMethodKey12,
				themeRule, merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.commsen.liferay.multidevice.rules.themes.model.ThemeRule)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule> getRules(
		long companyId, long groupId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getRulesMethodKey13,
				companyId, groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule> getRules(
		long companyId, long groupId, long layoutId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getRulesMethodKey14,
				companyId, groupId, layoutId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule> getMatchingRules(
		long companyId, long groupId, long layoutId,
		com.commsen.liferay.multidevice.Device device) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getMatchingRulesMethodKey15,
				companyId, groupId, layoutId, device);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.commsen.liferay.multidevice.rules.themes.model.ThemeRule>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addThemeRuleMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
			"addThemeRule",
			com.commsen.liferay.multidevice.rules.themes.model.ThemeRule.class);
	private MethodKey _createThemeRuleMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
			"createThemeRule", long.class);
	private MethodKey _deleteThemeRuleMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteThemeRule", long.class);
	private MethodKey _deleteThemeRuleMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteThemeRule",
			com.commsen.liferay.multidevice.rules.themes.model.ThemeRule.class);
	private MethodKey _dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery", com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class);
	private MethodKey _dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class, com.liferay.portal.kernel.util.OrderByComparator.class);
	private MethodKey _dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQueryCount",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _getThemeRuleMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
			"getThemeRule", long.class);
	private MethodKey _getThemeRulesMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
			"getThemeRules", int.class, int.class);
	private MethodKey _getThemeRulesCountMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
			"getThemeRulesCount");
	private MethodKey _updateThemeRuleMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateThemeRule",
			com.commsen.liferay.multidevice.rules.themes.model.ThemeRule.class);
	private MethodKey _updateThemeRuleMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateThemeRule",
			com.commsen.liferay.multidevice.rules.themes.model.ThemeRule.class,
			boolean.class);
	private MethodKey _getRulesMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
			"getRules", long.class, long.class);
	private MethodKey _getRulesMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
			"getRules", long.class, long.class, long.class);
	private MethodKey _getMatchingRulesMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
			"getMatchingRules", long.class, long.class, long.class,
			com.commsen.liferay.multidevice.Device.class);
}