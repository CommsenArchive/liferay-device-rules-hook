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

package com.commsen.liferay.multidevice.rules.themes.service.persistence;

import com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException;
import com.commsen.liferay.multidevice.rules.themes.model.ThemeRule;
import com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleImpl;
import com.commsen.liferay.multidevice.rules.themes.model.impl.ThemeRuleModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the theme rule service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ThemeRuleUtil} to access the theme rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Milen Dyankov
 * @see ThemeRulePersistence
 * @see ThemeRuleUtil
 * @generated
 */
public class ThemeRulePersistenceImpl extends BasePersistenceImpl<ThemeRule>
	implements ThemeRulePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ThemeRuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUP = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PAGE = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPage",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PAGE = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPage",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_ALL = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByAll",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ALL = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAll",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the theme rule in the entity cache if it is enabled.
	 *
	 * @param themeRule the theme rule to cache
	 */
	public void cacheResult(ThemeRule themeRule) {
		EntityCacheUtil.putResult(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleImpl.class, themeRule.getPrimaryKey(), themeRule);
	}

	/**
	 * Caches the theme rules in the entity cache if it is enabled.
	 *
	 * @param themeRules the theme rules to cache
	 */
	public void cacheResult(List<ThemeRule> themeRules) {
		for (ThemeRule themeRule : themeRules) {
			if (EntityCacheUtil.getResult(
						ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
						ThemeRuleImpl.class, themeRule.getPrimaryKey(), this) == null) {
				cacheResult(themeRule);
			}
		}
	}

	/**
	 * Clears the cache for all theme rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ThemeRuleImpl.class.getName());
		EntityCacheUtil.clearCache(ThemeRuleImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the theme rule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ThemeRule themeRule) {
		EntityCacheUtil.removeResult(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleImpl.class, themeRule.getPrimaryKey());
	}

	/**
	 * Creates a new theme rule with the primary key. Does not add the theme rule to the database.
	 *
	 * @param rid the primary key for the new theme rule
	 * @return the new theme rule
	 */
	public ThemeRule create(long rid) {
		ThemeRule themeRule = new ThemeRuleImpl();

		themeRule.setNew(true);
		themeRule.setPrimaryKey(rid);

		return themeRule;
	}

	/**
	 * Removes the theme rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the theme rule to remove
	 * @return the theme rule that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the theme rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rid the primary key of the theme rule to remove
	 * @return the theme rule that was removed
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule remove(long rid)
		throws NoSuchThemeRuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ThemeRule themeRule = (ThemeRule)session.get(ThemeRuleImpl.class,
					new Long(rid));

			if (themeRule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + rid);
				}

				throw new NoSuchThemeRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					rid);
			}

			return remove(themeRule);
		}
		catch (NoSuchThemeRuleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThemeRule removeImpl(ThemeRule themeRule)
		throws SystemException {
		themeRule = toUnwrappedModel(themeRule);

		Session session = null;

		try {
			session = openSession();

			if (themeRule.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ThemeRuleImpl.class,
						themeRule.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(themeRule);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleImpl.class, themeRule.getPrimaryKey());

		return themeRule;
	}

	public ThemeRule updateImpl(
		com.commsen.liferay.multidevice.rules.themes.model.ThemeRule themeRule,
		boolean merge) throws SystemException {
		themeRule = toUnwrappedModel(themeRule);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, themeRule, merge);

			themeRule.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
			ThemeRuleImpl.class, themeRule.getPrimaryKey(), themeRule);

		return themeRule;
	}

	protected ThemeRule toUnwrappedModel(ThemeRule themeRule) {
		if (themeRule instanceof ThemeRuleImpl) {
			return themeRule;
		}

		ThemeRuleImpl themeRuleImpl = new ThemeRuleImpl();

		themeRuleImpl.setNew(themeRule.isNew());
		themeRuleImpl.setPrimaryKey(themeRule.getPrimaryKey());

		themeRuleImpl.setRid(themeRule.getRid());
		themeRuleImpl.setCompanyId(themeRule.getCompanyId());
		themeRuleImpl.setGroupId(themeRule.getGroupId());
		themeRuleImpl.setLayoutId(themeRule.getLayoutId());
		themeRuleImpl.setBrand(themeRule.getBrand());
		themeRuleImpl.setModel(themeRule.getModel());
		themeRuleImpl.setOs(themeRule.getOs());
		themeRuleImpl.setOsVersion(themeRule.getOsVersion());
		themeRuleImpl.setBrowser(themeRule.getBrowser());
		themeRuleImpl.setBrowserVersion(themeRule.getBrowserVersion());
		themeRuleImpl.setPointingMethod(themeRule.getPointingMethod());
		themeRuleImpl.setTablet(themeRule.getTablet());
		themeRuleImpl.setQwertyKeyboad(themeRule.getQwertyKeyboad());
		themeRuleImpl.setThemeId(themeRule.getThemeId());
		themeRuleImpl.setColorSchemeId(themeRule.getColorSchemeId());
		themeRuleImpl.setPriority(themeRule.getPriority());

		return themeRuleImpl;
	}

	/**
	 * Finds the theme rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the theme rule to find
	 * @return the theme rule
	 * @throws com.liferay.portal.NoSuchModelException if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the theme rule with the primary key or throws a {@link com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException} if it could not be found.
	 *
	 * @param rid the primary key of the theme rule to find
	 * @return the theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByPrimaryKey(long rid)
		throws NoSuchThemeRuleException, SystemException {
		ThemeRule themeRule = fetchByPrimaryKey(rid);

		if (themeRule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + rid);
			}

			throw new NoSuchThemeRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				rid);
		}

		return themeRule;
	}

	/**
	 * Finds the theme rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the theme rule to find
	 * @return the theme rule, or <code>null</code> if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the theme rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rid the primary key of the theme rule to find
	 * @return the theme rule, or <code>null</code> if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule fetchByPrimaryKey(long rid) throws SystemException {
		ThemeRule themeRule = (ThemeRule)EntityCacheUtil.getResult(ThemeRuleModelImpl.ENTITY_CACHE_ENABLED,
				ThemeRuleImpl.class, rid, this);

		if (themeRule == null) {
			Session session = null;

			try {
				session = openSession();

				themeRule = (ThemeRule)session.get(ThemeRuleImpl.class,
						new Long(rid));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (themeRule != null) {
					cacheResult(themeRule);
				}

				closeSession(session);
			}
		}

		return themeRule;
	}

	/**
	 * Finds all the theme rules where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @return the matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByGroup(long companyId, long groupId)
		throws SystemException {
		return findByGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the theme rules where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @return the range of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByGroup(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the theme rules where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByGroup(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ThemeRule> list = (List<ThemeRule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUP,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_THEMERULE_WHERE);

				query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

				query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ThemeRuleModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<ThemeRule>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ThemeRule>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUP,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first theme rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a matching theme rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		List<ThemeRule> list = findByGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThemeRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last theme rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a matching theme rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		int count = countByGroup(companyId, groupId);

		List<ThemeRule> list = findByGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThemeRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the theme rules before and after the current theme rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current theme rule
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule[] findByGroup_PrevAndNext(long rid, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		ThemeRule themeRule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			ThemeRule[] array = new ThemeRuleImpl[3];

			array[0] = getByGroup_PrevAndNext(session, themeRule, companyId,
					groupId, orderByComparator, true);

			array[1] = themeRule;

			array[2] = getByGroup_PrevAndNext(session, themeRule, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThemeRule getByGroup_PrevAndNext(Session session,
		ThemeRule themeRule, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THEMERULE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ThemeRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(themeRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThemeRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @return the matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByPage(long companyId, long groupId,
		long layoutId) throws SystemException {
		return findByPage(companyId, groupId, layoutId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @return the range of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByPage(long companyId, long groupId,
		long layoutId, int start, int end) throws SystemException {
		return findByPage(companyId, groupId, layoutId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByPage(long companyId, long groupId,
		long layoutId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, layoutId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ThemeRule> list = (List<ThemeRule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PAGE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(5 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(5);
				}

				query.append(_SQL_SELECT_THEMERULE_WHERE);

				query.append(_FINDER_COLUMN_PAGE_COMPANYID_2);

				query.append(_FINDER_COLUMN_PAGE_GROUPID_2);

				query.append(_FINDER_COLUMN_PAGE_LAYOUTID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ThemeRuleModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(layoutId);

				list = (List<ThemeRule>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ThemeRule>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PAGE, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first theme rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a matching theme rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByPage_First(long companyId, long groupId,
		long layoutId, OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		List<ThemeRule> list = findByPage(companyId, groupId, layoutId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", layoutId=");
			msg.append(layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThemeRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last theme rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a matching theme rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByPage_Last(long companyId, long groupId,
		long layoutId, OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		int count = countByPage(companyId, groupId, layoutId);

		List<ThemeRule> list = findByPage(companyId, groupId, layoutId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", layoutId=");
			msg.append(layoutId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThemeRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the theme rules before and after the current theme rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current theme rule
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule[] findByPage_PrevAndNext(long rid, long companyId,
		long groupId, long layoutId, OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		ThemeRule themeRule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			ThemeRule[] array = new ThemeRuleImpl[3];

			array[0] = getByPage_PrevAndNext(session, themeRule, companyId,
					groupId, layoutId, orderByComparator, true);

			array[1] = themeRule;

			array[2] = getByPage_PrevAndNext(session, themeRule, companyId,
					groupId, layoutId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThemeRule getByPage_PrevAndNext(Session session,
		ThemeRule themeRule, long companyId, long groupId, long layoutId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THEMERULE_WHERE);

		query.append(_FINDER_COLUMN_PAGE_COMPANYID_2);

		query.append(_FINDER_COLUMN_PAGE_GROUPID_2);

		query.append(_FINDER_COLUMN_PAGE_LAYOUTID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ThemeRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(layoutId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(themeRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThemeRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @return the matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByAll(long companyId, long groupId,
		long layoutId, String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad) throws SystemException {
		return findByAll(companyId, groupId, layoutId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @return the range of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByAll(long companyId, long groupId,
		long layoutId, String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, int start, int end)
		throws SystemException {
		return findByAll(companyId, groupId, layoutId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, start, end, null);
	}

	/**
	 * Finds an ordered range of all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findByAll(long companyId, long groupId,
		long layoutId, String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, layoutId, brand, model, os, osVersion,
				browser, browserVersion, pointingMethod, tablet, qwertyKeyboad,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ThemeRule> list = (List<ThemeRule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(14 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(14);
				}

				query.append(_SQL_SELECT_THEMERULE_WHERE);

				query.append(_FINDER_COLUMN_ALL_COMPANYID_2);

				query.append(_FINDER_COLUMN_ALL_GROUPID_2);

				query.append(_FINDER_COLUMN_ALL_LAYOUTID_2);

				if (brand == null) {
					query.append(_FINDER_COLUMN_ALL_BRAND_1);
				}
				else {
					if (brand.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_BRAND_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_BRAND_2);
					}
				}

				if (model == null) {
					query.append(_FINDER_COLUMN_ALL_MODEL_1);
				}
				else {
					if (model.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_MODEL_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_MODEL_2);
					}
				}

				if (os == null) {
					query.append(_FINDER_COLUMN_ALL_OS_1);
				}
				else {
					if (os.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_OS_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_OS_2);
					}
				}

				if (osVersion == null) {
					query.append(_FINDER_COLUMN_ALL_OSVERSION_1);
				}
				else {
					if (osVersion.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_OSVERSION_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_OSVERSION_2);
					}
				}

				if (browser == null) {
					query.append(_FINDER_COLUMN_ALL_BROWSER_1);
				}
				else {
					if (browser.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_BROWSER_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_BROWSER_2);
					}
				}

				if (browserVersion == null) {
					query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_1);
				}
				else {
					if (browserVersion.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_2);
					}
				}

				if (pointingMethod == null) {
					query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_1);
				}
				else {
					if (pointingMethod.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_2);
					}
				}

				if (tablet == null) {
					query.append(_FINDER_COLUMN_ALL_TABLET_1);
				}
				else {
					if (tablet.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_TABLET_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_TABLET_2);
					}
				}

				if (qwertyKeyboad == null) {
					query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_1);
				}
				else {
					if (qwertyKeyboad.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ThemeRuleModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(layoutId);

				if (brand != null) {
					qPos.add(brand);
				}

				if (model != null) {
					qPos.add(model);
				}

				if (os != null) {
					qPos.add(os);
				}

				if (osVersion != null) {
					qPos.add(osVersion);
				}

				if (browser != null) {
					qPos.add(browser);
				}

				if (browserVersion != null) {
					qPos.add(browserVersion);
				}

				if (pointingMethod != null) {
					qPos.add(pointingMethod);
				}

				if (tablet != null) {
					qPos.add(tablet);
				}

				if (qwertyKeyboad != null) {
					qPos.add(qwertyKeyboad);
				}

				list = (List<ThemeRule>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ThemeRule>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ALL, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first theme rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a matching theme rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByAll_First(long companyId, long groupId,
		long layoutId, String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		List<ThemeRule> list = findByAll(companyId, groupId, layoutId, brand,
				model, os, osVersion, browser, browserVersion, pointingMethod,
				tablet, qwertyKeyboad, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(26);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", layoutId=");
			msg.append(layoutId);

			msg.append(", brand=");
			msg.append(brand);

			msg.append(", model=");
			msg.append(model);

			msg.append(", os=");
			msg.append(os);

			msg.append(", osVersion=");
			msg.append(osVersion);

			msg.append(", browser=");
			msg.append(browser);

			msg.append(", browserVersion=");
			msg.append(browserVersion);

			msg.append(", pointingMethod=");
			msg.append(pointingMethod);

			msg.append(", tablet=");
			msg.append(tablet);

			msg.append(", qwertyKeyboad=");
			msg.append(qwertyKeyboad);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThemeRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last theme rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a matching theme rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule findByAll_Last(long companyId, long groupId,
		long layoutId, String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		int count = countByAll(companyId, groupId, layoutId, brand, model, os,
				osVersion, browser, browserVersion, pointingMethod, tablet,
				qwertyKeyboad);

		List<ThemeRule> list = findByAll(companyId, groupId, layoutId, brand,
				model, os, osVersion, browser, browserVersion, pointingMethod,
				tablet, qwertyKeyboad, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(26);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", layoutId=");
			msg.append(layoutId);

			msg.append(", brand=");
			msg.append(brand);

			msg.append(", model=");
			msg.append(model);

			msg.append(", os=");
			msg.append(os);

			msg.append(", osVersion=");
			msg.append(osVersion);

			msg.append(", browser=");
			msg.append(browser);

			msg.append(", browserVersion=");
			msg.append(browserVersion);

			msg.append(", pointingMethod=");
			msg.append(pointingMethod);

			msg.append(", tablet=");
			msg.append(tablet);

			msg.append(", qwertyKeyboad=");
			msg.append(qwertyKeyboad);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchThemeRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the theme rules before and after the current theme rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current theme rule
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next theme rule
	 * @throws com.commsen.liferay.multidevice.rules.themes.NoSuchThemeRuleException if a theme rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ThemeRule[] findByAll_PrevAndNext(long rid, long companyId,
		long groupId, long layoutId, String brand, String model, String os,
		String osVersion, String browser, String browserVersion,
		String pointingMethod, String tablet, String qwertyKeyboad,
		OrderByComparator orderByComparator)
		throws NoSuchThemeRuleException, SystemException {
		ThemeRule themeRule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			ThemeRule[] array = new ThemeRuleImpl[3];

			array[0] = getByAll_PrevAndNext(session, themeRule, companyId,
					groupId, layoutId, brand, model, os, osVersion, browser,
					browserVersion, pointingMethod, tablet, qwertyKeyboad,
					orderByComparator, true);

			array[1] = themeRule;

			array[2] = getByAll_PrevAndNext(session, themeRule, companyId,
					groupId, layoutId, brand, model, os, osVersion, browser,
					browserVersion, pointingMethod, tablet, qwertyKeyboad,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThemeRule getByAll_PrevAndNext(Session session,
		ThemeRule themeRule, long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THEMERULE_WHERE);

		query.append(_FINDER_COLUMN_ALL_COMPANYID_2);

		query.append(_FINDER_COLUMN_ALL_GROUPID_2);

		query.append(_FINDER_COLUMN_ALL_LAYOUTID_2);

		if (brand == null) {
			query.append(_FINDER_COLUMN_ALL_BRAND_1);
		}
		else {
			if (brand.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_BRAND_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_BRAND_2);
			}
		}

		if (model == null) {
			query.append(_FINDER_COLUMN_ALL_MODEL_1);
		}
		else {
			if (model.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_MODEL_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_MODEL_2);
			}
		}

		if (os == null) {
			query.append(_FINDER_COLUMN_ALL_OS_1);
		}
		else {
			if (os.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_OS_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_OS_2);
			}
		}

		if (osVersion == null) {
			query.append(_FINDER_COLUMN_ALL_OSVERSION_1);
		}
		else {
			if (osVersion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_OSVERSION_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_OSVERSION_2);
			}
		}

		if (browser == null) {
			query.append(_FINDER_COLUMN_ALL_BROWSER_1);
		}
		else {
			if (browser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_BROWSER_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_BROWSER_2);
			}
		}

		if (browserVersion == null) {
			query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_1);
		}
		else {
			if (browserVersion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_2);
			}
		}

		if (pointingMethod == null) {
			query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_1);
		}
		else {
			if (pointingMethod.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_2);
			}
		}

		if (tablet == null) {
			query.append(_FINDER_COLUMN_ALL_TABLET_1);
		}
		else {
			if (tablet.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_TABLET_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_TABLET_2);
			}
		}

		if (qwertyKeyboad == null) {
			query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_1);
		}
		else {
			if (qwertyKeyboad.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_3);
			}
			else {
				query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ThemeRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(layoutId);

		if (brand != null) {
			qPos.add(brand);
		}

		if (model != null) {
			qPos.add(model);
		}

		if (os != null) {
			qPos.add(os);
		}

		if (osVersion != null) {
			qPos.add(osVersion);
		}

		if (browser != null) {
			qPos.add(browser);
		}

		if (browserVersion != null) {
			qPos.add(browserVersion);
		}

		if (pointingMethod != null) {
			qPos.add(pointingMethod);
		}

		if (tablet != null) {
			qPos.add(tablet);
		}

		if (qwertyKeyboad != null) {
			qPos.add(qwertyKeyboad);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(themeRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThemeRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the theme rules.
	 *
	 * @return the theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the theme rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @return the range of theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the theme rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of theme rules to return
	 * @param end the upper bound of the range of theme rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<ThemeRule> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ThemeRule> list = (List<ThemeRule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_THEMERULE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_THEMERULE.concat(ThemeRuleModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ThemeRule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ThemeRule>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ThemeRule>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the theme rules where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long companyId, long groupId)
		throws SystemException {
		for (ThemeRule themeRule : findByGroup(companyId, groupId)) {
			remove(themeRule);
		}
	}

	/**
	 * Removes all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPage(long companyId, long groupId, long layoutId)
		throws SystemException {
		for (ThemeRule themeRule : findByPage(companyId, groupId, layoutId)) {
			remove(themeRule);
		}
	}

	/**
	 * Removes all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAll(long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad) throws SystemException {
		for (ThemeRule themeRule : findByAll(companyId, groupId, layoutId,
				brand, model, os, osVersion, browser, browserVersion,
				pointingMethod, tablet, qwertyKeyboad)) {
			remove(themeRule);
		}
	}

	/**
	 * Removes all the theme rules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ThemeRule themeRule : findAll()) {
			remove(themeRule);
		}
	}

	/**
	 * Counts all the theme rules where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @return the number of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_THEMERULE_WHERE);

				query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

				query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @return the number of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPage(long companyId, long groupId, long layoutId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, layoutId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PAGE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_THEMERULE_WHERE);

				query.append(_FINDER_COLUMN_PAGE_COMPANYID_2);

				query.append(_FINDER_COLUMN_PAGE_GROUPID_2);

				query.append(_FINDER_COLUMN_PAGE_LAYOUTID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(layoutId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PAGE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the theme rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param brand the brand to search with
	 * @param model the model to search with
	 * @param os the os to search with
	 * @param osVersion the os version to search with
	 * @param browser the browser to search with
	 * @param browserVersion the browser version to search with
	 * @param pointingMethod the pointing method to search with
	 * @param tablet the tablet to search with
	 * @param qwertyKeyboad the qwerty keyboad to search with
	 * @return the number of matching theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAll(long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, layoutId, brand, model, os, osVersion,
				browser, browserVersion, pointingMethod, tablet, qwertyKeyboad
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(13);

				query.append(_SQL_COUNT_THEMERULE_WHERE);

				query.append(_FINDER_COLUMN_ALL_COMPANYID_2);

				query.append(_FINDER_COLUMN_ALL_GROUPID_2);

				query.append(_FINDER_COLUMN_ALL_LAYOUTID_2);

				if (brand == null) {
					query.append(_FINDER_COLUMN_ALL_BRAND_1);
				}
				else {
					if (brand.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_BRAND_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_BRAND_2);
					}
				}

				if (model == null) {
					query.append(_FINDER_COLUMN_ALL_MODEL_1);
				}
				else {
					if (model.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_MODEL_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_MODEL_2);
					}
				}

				if (os == null) {
					query.append(_FINDER_COLUMN_ALL_OS_1);
				}
				else {
					if (os.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_OS_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_OS_2);
					}
				}

				if (osVersion == null) {
					query.append(_FINDER_COLUMN_ALL_OSVERSION_1);
				}
				else {
					if (osVersion.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_OSVERSION_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_OSVERSION_2);
					}
				}

				if (browser == null) {
					query.append(_FINDER_COLUMN_ALL_BROWSER_1);
				}
				else {
					if (browser.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_BROWSER_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_BROWSER_2);
					}
				}

				if (browserVersion == null) {
					query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_1);
				}
				else {
					if (browserVersion.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_BROWSERVERSION_2);
					}
				}

				if (pointingMethod == null) {
					query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_1);
				}
				else {
					if (pointingMethod.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_POINTINGMETHOD_2);
					}
				}

				if (tablet == null) {
					query.append(_FINDER_COLUMN_ALL_TABLET_1);
				}
				else {
					if (tablet.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_TABLET_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_TABLET_2);
					}
				}

				if (qwertyKeyboad == null) {
					query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_1);
				}
				else {
					if (qwertyKeyboad.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_3);
					}
					else {
						query.append(_FINDER_COLUMN_ALL_QWERTYKEYBOAD_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(layoutId);

				if (brand != null) {
					qPos.add(brand);
				}

				if (model != null) {
					qPos.add(model);
				}

				if (os != null) {
					qPos.add(os);
				}

				if (osVersion != null) {
					qPos.add(osVersion);
				}

				if (browser != null) {
					qPos.add(browser);
				}

				if (browserVersion != null) {
					qPos.add(browserVersion);
				}

				if (pointingMethod != null) {
					qPos.add(pointingMethod);
				}

				if (tablet != null) {
					qPos.add(tablet);
				}

				if (qwertyKeyboad != null) {
					qPos.add(qwertyKeyboad);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the theme rules.
	 *
	 * @return the number of theme rules
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THEMERULE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the theme rule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.commsen.liferay.multidevice.rules.themes.model.ThemeRule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ThemeRule>> listenersList = new ArrayList<ModelListener<ThemeRule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ThemeRule>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = ThemeRulePersistence.class)
	protected ThemeRulePersistence themeRulePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_THEMERULE = "SELECT themeRule FROM ThemeRule themeRule";
	private static final String _SQL_SELECT_THEMERULE_WHERE = "SELECT themeRule FROM ThemeRule themeRule WHERE ";
	private static final String _SQL_COUNT_THEMERULE = "SELECT COUNT(themeRule) FROM ThemeRule themeRule";
	private static final String _SQL_COUNT_THEMERULE_WHERE = "SELECT COUNT(themeRule) FROM ThemeRule themeRule WHERE ";
	private static final String _FINDER_COLUMN_GROUP_COMPANYID_2 = "themeRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "themeRule.groupId = ?";
	private static final String _FINDER_COLUMN_PAGE_COMPANYID_2 = "themeRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PAGE_GROUPID_2 = "themeRule.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PAGE_LAYOUTID_2 = "themeRule.layoutId = ?";
	private static final String _FINDER_COLUMN_ALL_COMPANYID_2 = "themeRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ALL_GROUPID_2 = "themeRule.groupId = ? AND ";
	private static final String _FINDER_COLUMN_ALL_LAYOUTID_2 = "themeRule.layoutId = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BRAND_1 = "themeRule.brand IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_BRAND_2 = "themeRule.brand = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BRAND_3 = "(themeRule.brand IS NULL OR themeRule.brand = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_MODEL_1 = "themeRule.model IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_MODEL_2 = "themeRule.model = ? AND ";
	private static final String _FINDER_COLUMN_ALL_MODEL_3 = "(themeRule.model IS NULL OR themeRule.model = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_OS_1 = "themeRule.os IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_OS_2 = "themeRule.os = ? AND ";
	private static final String _FINDER_COLUMN_ALL_OS_3 = "(themeRule.os IS NULL OR themeRule.os = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_OSVERSION_1 = "themeRule.osVersion IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_OSVERSION_2 = "themeRule.osVersion = ? AND ";
	private static final String _FINDER_COLUMN_ALL_OSVERSION_3 = "(themeRule.osVersion IS NULL OR themeRule.osVersion = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSER_1 = "themeRule.browser IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSER_2 = "themeRule.browser = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSER_3 = "(themeRule.browser IS NULL OR themeRule.browser = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSERVERSION_1 = "themeRule.browserVersion IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSERVERSION_2 = "themeRule.browserVersion = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSERVERSION_3 = "(themeRule.browserVersion IS NULL OR themeRule.browserVersion = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_POINTINGMETHOD_1 = "themeRule.pointingMethod IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_POINTINGMETHOD_2 = "themeRule.pointingMethod = ? AND ";
	private static final String _FINDER_COLUMN_ALL_POINTINGMETHOD_3 = "(themeRule.pointingMethod IS NULL OR themeRule.pointingMethod = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_TABLET_1 = "themeRule.tablet IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_TABLET_2 = "themeRule.tablet = ? AND ";
	private static final String _FINDER_COLUMN_ALL_TABLET_3 = "(themeRule.tablet IS NULL OR themeRule.tablet = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_QWERTYKEYBOAD_1 = "themeRule.qwertyKeyboad IS NULL";
	private static final String _FINDER_COLUMN_ALL_QWERTYKEYBOAD_2 = "themeRule.qwertyKeyboad = ?";
	private static final String _FINDER_COLUMN_ALL_QWERTYKEYBOAD_3 = "(themeRule.qwertyKeyboad IS NULL OR themeRule.qwertyKeyboad = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "themeRule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThemeRule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThemeRule exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ThemeRulePersistenceImpl.class);
}