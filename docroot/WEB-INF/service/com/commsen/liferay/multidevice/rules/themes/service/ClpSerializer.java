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

import com.commsen.liferay.multidevice.rules.themes.model.ThemeRuleClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "theme-rules-hook";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ThemeRuleClp.class.getName())) {
			ThemeRuleClp oldCplModel = (ThemeRuleClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRid",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getRid());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setLayoutId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getLayoutId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setBrand",
							new Class[] { String.class });

					String value4 = oldCplModel.getBrand();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setModel",
							new Class[] { String.class });

					String value5 = oldCplModel.getModel();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setOs",
							new Class[] { String.class });

					String value6 = oldCplModel.getOs();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setOsVersion",
							new Class[] { String.class });

					String value7 = oldCplModel.getOsVersion();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setBrowser",
							new Class[] { String.class });

					String value8 = oldCplModel.getBrowser();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setBrowserVersion",
							new Class[] { String.class });

					String value9 = oldCplModel.getBrowserVersion();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setPointingMethod",
							new Class[] { String.class });

					String value10 = oldCplModel.getPointingMethod();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTablet",
							new Class[] { String.class });

					String value11 = oldCplModel.getTablet();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setQwertyKeyboad",
							new Class[] { String.class });

					String value12 = oldCplModel.getQwertyKeyboad();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setThemeId",
							new Class[] { String.class });

					String value13 = oldCplModel.getThemeId();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setColorSchemeId",
							new Class[] { String.class });

					String value14 = oldCplModel.getColorSchemeId();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setPriority",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getPriority());

					method15.invoke(newModel, value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ThemeRuleClp newModel = new ThemeRuleClp();

					Method method0 = oldModelClass.getMethod("getRid");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setRid(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2);

					Method method3 = oldModelClass.getMethod("getLayoutId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setLayoutId(value3);

					Method method4 = oldModelClass.getMethod("getBrand");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setBrand(value4);

					Method method5 = oldModelClass.getMethod("getModel");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setModel(value5);

					Method method6 = oldModelClass.getMethod("getOs");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setOs(value6);

					Method method7 = oldModelClass.getMethod("getOsVersion");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setOsVersion(value7);

					Method method8 = oldModelClass.getMethod("getBrowser");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setBrowser(value8);

					Method method9 = oldModelClass.getMethod(
							"getBrowserVersion");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setBrowserVersion(value9);

					Method method10 = oldModelClass.getMethod(
							"getPointingMethod");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setPointingMethod(value10);

					Method method11 = oldModelClass.getMethod("getTablet");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTablet(value11);

					Method method12 = oldModelClass.getMethod(
							"getQwertyKeyboad");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setQwertyKeyboad(value12);

					Method method13 = oldModelClass.getMethod("getThemeId");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setThemeId(value13);

					Method method14 = oldModelClass.getMethod(
							"getColorSchemeId");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setColorSchemeId(value14);

					Method method15 = oldModelClass.getMethod("getPriority");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setPriority(value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}