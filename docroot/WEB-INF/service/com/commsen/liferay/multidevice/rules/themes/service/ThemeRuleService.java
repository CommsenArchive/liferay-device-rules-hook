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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the theme rule remote service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ThemeRuleServiceUtil} to access the theme rule remote service. Add custom service methods to {@link com.commsen.liferay.multidevice.rules.themes.service.impl.ThemeRuleServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRuleServiceUtil
 * @see com.commsen.liferay.multidevice.rules.themes.service.base.ThemeRuleServiceBaseImpl
 * @see com.commsen.liferay.multidevice.rules.themes.service.impl.ThemeRuleServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ThemeRuleService {
}