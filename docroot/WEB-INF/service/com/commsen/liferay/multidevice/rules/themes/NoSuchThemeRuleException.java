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

import com.liferay.portal.NoSuchModelException;

/**
 * @author Milen Dyankov
 */
public class NoSuchThemeRuleException extends NoSuchModelException {

	public NoSuchThemeRuleException() {
		super();
	}

	public NoSuchThemeRuleException(String msg) {
		super(msg);
	}

	public NoSuchThemeRuleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchThemeRuleException(Throwable cause) {
		super(cause);
	}

}