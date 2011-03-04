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

package com.commsen.liferay.multidevice.rules.service.persistence;

import com.commsen.liferay.multidevice.rules.NoSuchRuleException;
import com.commsen.liferay.multidevice.rules.model.Rule;
import com.commsen.liferay.multidevice.rules.model.impl.RuleImpl;
import com.commsen.liferay.multidevice.rules.model.impl.RuleModelImpl;

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
 * The persistence implementation for the rule service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link RuleUtil} to access the rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Milen Dyankov
 * @see RulePersistence
 * @see RuleUtil
 * @generated
 */
public class RulePersistenceImpl extends BasePersistenceImpl<Rule>
	implements RulePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = RuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUP = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPANDACTION = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupAndAction",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDACTION = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupAndAction",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_PAGE = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPage",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PAGE = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPage",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_PAGEANDACTION = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByPageAndAction",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PAGEANDACTION = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByPageAndAction",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_ALL = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
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
	public static final FinderPath FINDER_PATH_COUNT_BY_ALL = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAll",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the rule in the entity cache if it is enabled.
	 *
	 * @param rule the rule to cache
	 */
	public void cacheResult(Rule rule) {
		EntityCacheUtil.putResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleImpl.class, rule.getPrimaryKey(), rule);
	}

	/**
	 * Caches the rules in the entity cache if it is enabled.
	 *
	 * @param rules the rules to cache
	 */
	public void cacheResult(List<Rule> rules) {
		for (Rule rule : rules) {
			if (EntityCacheUtil.getResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
						RuleImpl.class, rule.getPrimaryKey(), this) == null) {
				cacheResult(rule);
			}
		}
	}

	/**
	 * Clears the cache for all rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(RuleImpl.class.getName());
		EntityCacheUtil.clearCache(RuleImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the rule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Rule rule) {
		EntityCacheUtil.removeResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleImpl.class, rule.getPrimaryKey());
	}

	/**
	 * Creates a new rule with the primary key. Does not add the rule to the database.
	 *
	 * @param rid the primary key for the new rule
	 * @return the new rule
	 */
	public Rule create(long rid) {
		Rule rule = new RuleImpl();

		rule.setNew(true);
		rule.setPrimaryKey(rid);

		return rule;
	}

	/**
	 * Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule to remove
	 * @return the rule that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rid the primary key of the rule to remove
	 * @return the rule that was removed
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule remove(long rid) throws NoSuchRuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Rule rule = (Rule)session.get(RuleImpl.class, new Long(rid));

			if (rule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + rid);
				}

				throw new NoSuchRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					rid);
			}

			return remove(rule);
		}
		catch (NoSuchRuleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Rule removeImpl(Rule rule) throws SystemException {
		rule = toUnwrappedModel(rule);

		Session session = null;

		try {
			session = openSession();

			if (rule.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(RuleImpl.class,
						rule.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(rule);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleImpl.class, rule.getPrimaryKey());

		return rule;
	}

	public Rule updateImpl(
		com.commsen.liferay.multidevice.rules.model.Rule rule, boolean merge)
		throws SystemException {
		rule = toUnwrappedModel(rule);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, rule, merge);

			rule.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleImpl.class, rule.getPrimaryKey(), rule);

		return rule;
	}

	protected Rule toUnwrappedModel(Rule rule) {
		if (rule instanceof RuleImpl) {
			return rule;
		}

		RuleImpl ruleImpl = new RuleImpl();

		ruleImpl.setNew(rule.isNew());
		ruleImpl.setPrimaryKey(rule.getPrimaryKey());

		ruleImpl.setRid(rule.getRid());
		ruleImpl.setCompanyId(rule.getCompanyId());
		ruleImpl.setGroupId(rule.getGroupId());
		ruleImpl.setLayoutId(rule.getLayoutId());
		ruleImpl.setBrand(rule.getBrand());
		ruleImpl.setModel(rule.getModel());
		ruleImpl.setOs(rule.getOs());
		ruleImpl.setOsVersion(rule.getOsVersion());
		ruleImpl.setBrowser(rule.getBrowser());
		ruleImpl.setBrowserVersion(rule.getBrowserVersion());
		ruleImpl.setPointingMethod(rule.getPointingMethod());
		ruleImpl.setTablet(rule.getTablet());
		ruleImpl.setQwertyKeyboad(rule.getQwertyKeyboad());
		ruleImpl.setAction(rule.getAction());
		ruleImpl.setThemeId(rule.getThemeId());
		ruleImpl.setColorSchemeId(rule.getColorSchemeId());
		ruleImpl.setUrl(rule.getUrl());
		ruleImpl.setPriority(rule.getPriority());

		return ruleImpl;
	}

	/**
	 * Finds the rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule to find
	 * @return the rule
	 * @throws com.liferay.portal.NoSuchModelException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the rule with the primary key or throws a {@link com.commsen.liferay.multidevice.rules.NoSuchRuleException} if it could not be found.
	 *
	 * @param rid the primary key of the rule to find
	 * @return the rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByPrimaryKey(long rid)
		throws NoSuchRuleException, SystemException {
		Rule rule = fetchByPrimaryKey(rid);

		if (rule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + rid);
			}

			throw new NoSuchRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				rid);
		}

		return rule;
	}

	/**
	 * Finds the rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule to find
	 * @return the rule, or <code>null</code> if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rid the primary key of the rule to find
	 * @return the rule, or <code>null</code> if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule fetchByPrimaryKey(long rid) throws SystemException {
		Rule rule = (Rule)EntityCacheUtil.getResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
				RuleImpl.class, rid, this);

		if (rule == null) {
			Session session = null;

			try {
				session = openSession();

				rule = (Rule)session.get(RuleImpl.class, new Long(rid));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (rule != null) {
					cacheResult(rule);
				}

				closeSession(session);
			}
		}

		return rule;
	}

	/**
	 * Finds all the rules where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @return the matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByGroup(long companyId, long groupId)
		throws SystemException {
		return findByGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rules where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @return the range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByGroup(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the rules where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByGroup(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUP,
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

				query.append(_SQL_SELECT_RULE_WHERE);

				query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

				query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(RuleModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<Rule>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Rule>();
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
	 * Finds the first rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		List<Rule> list = findByGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		int count = countByGroup(companyId, groupId);

		List<Rule> list = findByGroup(companyId, groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rules before and after the current rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current rule
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule[] findByGroup_PrevAndNext(long rid, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByGroup_PrevAndNext(session, rule, companyId,
					groupId, orderByComparator, true);

			array[1] = rule;

			array[2] = getByGroup_PrevAndNext(session, rule, companyId,
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

	protected Rule getByGroup_PrevAndNext(Session session, Rule rule,
		long companyId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(rule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the rules where companyId = &#63; and groupId = &#63; and action = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @return the matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByGroupAndAction(long companyId, long groupId,
		String action) throws SystemException {
		return findByGroupAndAction(companyId, groupId, action,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rules where companyId = &#63; and groupId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @return the range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByGroupAndAction(long companyId, long groupId,
		String action, int start, int end) throws SystemException {
		return findByGroupAndAction(companyId, groupId, action, start, end, null);
	}

	/**
	 * Finds an ordered range of all the rules where companyId = &#63; and groupId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByGroupAndAction(long companyId, long groupId,
		String action, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, action,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPANDACTION,
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

				query.append(_SQL_SELECT_RULE_WHERE);

				query.append(_FINDER_COLUMN_GROUPANDACTION_COMPANYID_2);

				query.append(_FINDER_COLUMN_GROUPANDACTION_GROUPID_2);

				if (action == null) {
					query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_1);
				}
				else {
					if (action.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_3);
					}
					else {
						query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(RuleModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (action != null) {
					qPos.add(action);
				}

				list = (List<Rule>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Rule>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPANDACTION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first rule in the ordered set where companyId = &#63; and groupId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByGroupAndAction_First(long companyId, long groupId,
		String action, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		List<Rule> list = findByGroupAndAction(companyId, groupId, action, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", action=");
			msg.append(action);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last rule in the ordered set where companyId = &#63; and groupId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByGroupAndAction_Last(long companyId, long groupId,
		String action, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		int count = countByGroupAndAction(companyId, groupId, action);

		List<Rule> list = findByGroupAndAction(companyId, groupId, action,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", action=");
			msg.append(action);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rules before and after the current rule in the ordered set where companyId = &#63; and groupId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current rule
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule[] findByGroupAndAction_PrevAndNext(long rid, long companyId,
		long groupId, String action, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByGroupAndAction_PrevAndNext(session, rule,
					companyId, groupId, action, orderByComparator, true);

			array[1] = rule;

			array[2] = getByGroupAndAction_PrevAndNext(session, rule,
					companyId, groupId, action, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Rule getByGroupAndAction_PrevAndNext(Session session, Rule rule,
		long companyId, long groupId, String action,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDACTION_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPANDACTION_GROUPID_2);

		if (action == null) {
			query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_1);
		}
		else {
			if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_3);
			}
			else {
				query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_2);
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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (action != null) {
			qPos.add(action);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(rule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @return the matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByPage(long companyId, long groupId, long layoutId)
		throws SystemException {
		return findByPage(companyId, groupId, layoutId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @return the range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByPage(long companyId, long groupId, long layoutId,
		int start, int end) throws SystemException {
		return findByPage(companyId, groupId, layoutId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByPage(long companyId, long groupId, long layoutId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, layoutId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PAGE,
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

				query.append(_SQL_SELECT_RULE_WHERE);

				query.append(_FINDER_COLUMN_PAGE_COMPANYID_2);

				query.append(_FINDER_COLUMN_PAGE_GROUPID_2);

				query.append(_FINDER_COLUMN_PAGE_LAYOUTID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(RuleModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(layoutId);

				list = (List<Rule>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Rule>();
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
	 * Finds the first rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByPage_First(long companyId, long groupId, long layoutId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		List<Rule> list = findByPage(companyId, groupId, layoutId, 0, 1,
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

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByPage_Last(long companyId, long groupId, long layoutId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		int count = countByPage(companyId, groupId, layoutId);

		List<Rule> list = findByPage(companyId, groupId, layoutId, count - 1,
				count, orderByComparator);

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

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rules before and after the current rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current rule
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule[] findByPage_PrevAndNext(long rid, long companyId,
		long groupId, long layoutId, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByPage_PrevAndNext(session, rule, companyId, groupId,
					layoutId, orderByComparator, true);

			array[1] = rule;

			array[2] = getByPage_PrevAndNext(session, rule, companyId, groupId,
					layoutId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Rule getByPage_PrevAndNext(Session session, Rule rule,
		long companyId, long groupId, long layoutId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByValues(rule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @return the matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByPageAndAction(long companyId, long groupId,
		long layoutId, String action) throws SystemException {
		return findByPageAndAction(companyId, groupId, layoutId, action,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @return the range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByPageAndAction(long companyId, long groupId,
		long layoutId, String action, int start, int end)
		throws SystemException {
		return findByPageAndAction(companyId, groupId, layoutId, action, start,
			end, null);
	}

	/**
	 * Finds an ordered range of all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByPageAndAction(long companyId, long groupId,
		long layoutId, String action, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, layoutId, action,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PAGEANDACTION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(6 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(6);
				}

				query.append(_SQL_SELECT_RULE_WHERE);

				query.append(_FINDER_COLUMN_PAGEANDACTION_COMPANYID_2);

				query.append(_FINDER_COLUMN_PAGEANDACTION_GROUPID_2);

				query.append(_FINDER_COLUMN_PAGEANDACTION_LAYOUTID_2);

				if (action == null) {
					query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_1);
				}
				else {
					if (action.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_3);
					}
					else {
						query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(RuleModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(layoutId);

				if (action != null) {
					qPos.add(action);
				}

				list = (List<Rule>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Rule>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PAGEANDACTION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByPageAndAction_First(long companyId, long groupId,
		long layoutId, String action, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		List<Rule> list = findByPageAndAction(companyId, groupId, layoutId,
				action, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", layoutId=");
			msg.append(layoutId);

			msg.append(", action=");
			msg.append(action);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByPageAndAction_Last(long companyId, long groupId,
		long layoutId, String action, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		int count = countByPageAndAction(companyId, groupId, layoutId, action);

		List<Rule> list = findByPageAndAction(companyId, groupId, layoutId,
				action, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", layoutId=");
			msg.append(layoutId);

			msg.append(", action=");
			msg.append(action);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rules before and after the current rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current rule
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule[] findByPageAndAction_PrevAndNext(long rid, long companyId,
		long groupId, long layoutId, String action,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByPageAndAction_PrevAndNext(session, rule, companyId,
					groupId, layoutId, action, orderByComparator, true);

			array[1] = rule;

			array[2] = getByPageAndAction_PrevAndNext(session, rule, companyId,
					groupId, layoutId, action, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Rule getByPageAndAction_PrevAndNext(Session session, Rule rule,
		long companyId, long groupId, long layoutId, String action,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

		query.append(_FINDER_COLUMN_PAGEANDACTION_COMPANYID_2);

		query.append(_FINDER_COLUMN_PAGEANDACTION_GROUPID_2);

		query.append(_FINDER_COLUMN_PAGEANDACTION_LAYOUTID_2);

		if (action == null) {
			query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_1);
		}
		else {
			if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_3);
			}
			else {
				query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_2);
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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(layoutId);

		if (action != null) {
			qPos.add(action);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(rule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
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
	 * @return the matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByAll(long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad) throws SystemException {
		return findByAll(companyId, groupId, layoutId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
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
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @return the range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByAll(long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, int start, int end)
		throws SystemException {
		return findByAll(companyId, groupId, layoutId, brand, model, os,
			osVersion, browser, browserVersion, pointingMethod, tablet,
			qwertyKeyboad, start, end, null);
	}

	/**
	 * Finds an ordered range of all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
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
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findByAll(long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, layoutId, brand, model, os, osVersion,
				browser, browserVersion, pointingMethod, tablet, qwertyKeyboad,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALL,
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

				query.append(_SQL_SELECT_RULE_WHERE);

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
					query.append(RuleModelImpl.ORDER_BY_JPQL);
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

				list = (List<Rule>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Rule>();
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
	 * Finds the first rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
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
	 * @return the first matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByAll_First(long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		List<Rule> list = findByAll(companyId, groupId, layoutId, brand, model,
				os, osVersion, browser, browserVersion, pointingMethod, tablet,
				qwertyKeyboad, 0, 1, orderByComparator);

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

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
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
	 * @return the last matching rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule findByAll_Last(long companyId, long groupId, long layoutId,
		String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		int count = countByAll(companyId, groupId, layoutId, brand, model, os,
				osVersion, browser, browserVersion, pointingMethod, tablet,
				qwertyKeyboad);

		List<Rule> list = findByAll(companyId, groupId, layoutId, brand, model,
				os, osVersion, browser, browserVersion, pointingMethod, tablet,
				qwertyKeyboad, count - 1, count, orderByComparator);

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

			throw new NoSuchRuleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rules before and after the current rule in the ordered set where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rid the primary key of the current rule
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
	 * @return the previous, current, and next rule
	 * @throws com.commsen.liferay.multidevice.rules.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Rule[] findByAll_PrevAndNext(long rid, long companyId, long groupId,
		long layoutId, String brand, String model, String os, String osVersion,
		String browser, String browserVersion, String pointingMethod,
		String tablet, String qwertyKeyboad, OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByPrimaryKey(rid);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByAll_PrevAndNext(session, rule, companyId, groupId,
					layoutId, brand, model, os, osVersion, browser,
					browserVersion, pointingMethod, tablet, qwertyKeyboad,
					orderByComparator, true);

			array[1] = rule;

			array[2] = getByAll_PrevAndNext(session, rule, companyId, groupId,
					layoutId, brand, model, os, osVersion, browser,
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

	protected Rule getByAll_PrevAndNext(Session session, Rule rule,
		long companyId, long groupId, long layoutId, String brand,
		String model, String os, String osVersion, String browser,
		String browserVersion, String pointingMethod, String tablet,
		String qwertyKeyboad, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByValues(rule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the rules.
	 *
	 * @return the rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rules.
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
	public List<Rule> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of rules to return
	 * @param end the upper bound of the range of rules to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of rules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Rule> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_RULE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_RULE.concat(RuleModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Rule>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the rules where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup(long companyId, long groupId)
		throws SystemException {
		for (Rule rule : findByGroup(companyId, groupId)) {
			remove(rule);
		}
	}

	/**
	 * Removes all the rules where companyId = &#63; and groupId = &#63; and action = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupAndAction(long companyId, long groupId,
		String action) throws SystemException {
		for (Rule rule : findByGroupAndAction(companyId, groupId, action)) {
			remove(rule);
		}
	}

	/**
	 * Removes all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPage(long companyId, long groupId, long layoutId)
		throws SystemException {
		for (Rule rule : findByPage(companyId, groupId, layoutId)) {
			remove(rule);
		}
	}

	/**
	 * Removes all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPageAndAction(long companyId, long groupId,
		long layoutId, String action) throws SystemException {
		for (Rule rule : findByPageAndAction(companyId, groupId, layoutId,
				action)) {
			remove(rule);
		}
	}

	/**
	 * Removes all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63; from the database.
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
		for (Rule rule : findByAll(companyId, groupId, layoutId, brand, model,
				os, osVersion, browser, browserVersion, pointingMethod, tablet,
				qwertyKeyboad)) {
			remove(rule);
		}
	}

	/**
	 * Removes all the rules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Rule rule : findAll()) {
			remove(rule);
		}
	}

	/**
	 * Counts all the rules where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @return the number of matching rules
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

				query.append(_SQL_COUNT_RULE_WHERE);

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
	 * Counts all the rules where companyId = &#63; and groupId = &#63; and action = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param action the action to search with
	 * @return the number of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupAndAction(long companyId, long groupId, String action)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, action };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPANDACTION,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_RULE_WHERE);

				query.append(_FINDER_COLUMN_GROUPANDACTION_COMPANYID_2);

				query.append(_FINDER_COLUMN_GROUPANDACTION_GROUPID_2);

				if (action == null) {
					query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_1);
				}
				else {
					if (action.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_3);
					}
					else {
						query.append(_FINDER_COLUMN_GROUPANDACTION_ACTION_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (action != null) {
					qPos.add(action);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPANDACTION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @return the number of matching rules
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

				query.append(_SQL_COUNT_RULE_WHERE);

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
	 * Counts all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and action = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @param groupId the group id to search with
	 * @param layoutId the layout id to search with
	 * @param action the action to search with
	 * @return the number of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPageAndAction(long companyId, long groupId,
		long layoutId, String action) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, layoutId, action };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PAGEANDACTION,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(5);

				query.append(_SQL_COUNT_RULE_WHERE);

				query.append(_FINDER_COLUMN_PAGEANDACTION_COMPANYID_2);

				query.append(_FINDER_COLUMN_PAGEANDACTION_GROUPID_2);

				query.append(_FINDER_COLUMN_PAGEANDACTION_LAYOUTID_2);

				if (action == null) {
					query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_1);
				}
				else {
					if (action.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_3);
					}
					else {
						query.append(_FINDER_COLUMN_PAGEANDACTION_ACTION_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(layoutId);

				if (action != null) {
					qPos.add(action);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PAGEANDACTION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the rules where companyId = &#63; and groupId = &#63; and layoutId = &#63; and brand = &#63; and model = &#63; and os = &#63; and osVersion = &#63; and browser = &#63; and browserVersion = &#63; and pointingMethod = &#63; and tablet = &#63; and qwertyKeyboad = &#63;.
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
	 * @return the number of matching rules
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

				query.append(_SQL_COUNT_RULE_WHERE);

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
	 * Counts all the rules.
	 *
	 * @return the number of rules
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

				Query q = session.createQuery(_SQL_COUNT_RULE);

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
	 * Initializes the rule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.commsen.liferay.multidevice.rules.model.Rule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Rule>> listenersList = new ArrayList<ModelListener<Rule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Rule>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = RulePersistence.class)
	protected RulePersistence rulePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RULE = "SELECT rule FROM Rule rule";
	private static final String _SQL_SELECT_RULE_WHERE = "SELECT rule FROM Rule rule WHERE ";
	private static final String _SQL_COUNT_RULE = "SELECT COUNT(rule) FROM Rule rule";
	private static final String _SQL_COUNT_RULE_WHERE = "SELECT COUNT(rule) FROM Rule rule WHERE ";
	private static final String _FINDER_COLUMN_GROUP_COMPANYID_2 = "rule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "rule.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPANDACTION_COMPANYID_2 = "rule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDACTION_GROUPID_2 = "rule.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDACTION_ACTION_1 = "rule.action IS NULL";
	private static final String _FINDER_COLUMN_GROUPANDACTION_ACTION_2 = "rule.action = ?";
	private static final String _FINDER_COLUMN_GROUPANDACTION_ACTION_3 = "(rule.action IS NULL OR rule.action = ?)";
	private static final String _FINDER_COLUMN_PAGE_COMPANYID_2 = "rule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PAGE_GROUPID_2 = "rule.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PAGE_LAYOUTID_2 = "rule.layoutId = ?";
	private static final String _FINDER_COLUMN_PAGEANDACTION_COMPANYID_2 = "rule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PAGEANDACTION_GROUPID_2 = "rule.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PAGEANDACTION_LAYOUTID_2 = "rule.layoutId = ? AND ";
	private static final String _FINDER_COLUMN_PAGEANDACTION_ACTION_1 = "rule.action IS NULL";
	private static final String _FINDER_COLUMN_PAGEANDACTION_ACTION_2 = "rule.action = ?";
	private static final String _FINDER_COLUMN_PAGEANDACTION_ACTION_3 = "(rule.action IS NULL OR rule.action = ?)";
	private static final String _FINDER_COLUMN_ALL_COMPANYID_2 = "rule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ALL_GROUPID_2 = "rule.groupId = ? AND ";
	private static final String _FINDER_COLUMN_ALL_LAYOUTID_2 = "rule.layoutId = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BRAND_1 = "rule.brand IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_BRAND_2 = "rule.brand = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BRAND_3 = "(rule.brand IS NULL OR rule.brand = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_MODEL_1 = "rule.model IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_MODEL_2 = "rule.model = ? AND ";
	private static final String _FINDER_COLUMN_ALL_MODEL_3 = "(rule.model IS NULL OR rule.model = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_OS_1 = "rule.os IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_OS_2 = "rule.os = ? AND ";
	private static final String _FINDER_COLUMN_ALL_OS_3 = "(rule.os IS NULL OR rule.os = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_OSVERSION_1 = "rule.osVersion IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_OSVERSION_2 = "rule.osVersion = ? AND ";
	private static final String _FINDER_COLUMN_ALL_OSVERSION_3 = "(rule.osVersion IS NULL OR rule.osVersion = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSER_1 = "rule.browser IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSER_2 = "rule.browser = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSER_3 = "(rule.browser IS NULL OR rule.browser = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSERVERSION_1 = "rule.browserVersion IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSERVERSION_2 = "rule.browserVersion = ? AND ";
	private static final String _FINDER_COLUMN_ALL_BROWSERVERSION_3 = "(rule.browserVersion IS NULL OR rule.browserVersion = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_POINTINGMETHOD_1 = "rule.pointingMethod IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_POINTINGMETHOD_2 = "rule.pointingMethod = ? AND ";
	private static final String _FINDER_COLUMN_ALL_POINTINGMETHOD_3 = "(rule.pointingMethod IS NULL OR rule.pointingMethod = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_TABLET_1 = "rule.tablet IS NULL AND ";
	private static final String _FINDER_COLUMN_ALL_TABLET_2 = "rule.tablet = ? AND ";
	private static final String _FINDER_COLUMN_ALL_TABLET_3 = "(rule.tablet IS NULL OR rule.tablet = ?) AND ";
	private static final String _FINDER_COLUMN_ALL_QWERTYKEYBOAD_1 = "rule.qwertyKeyboad IS NULL";
	private static final String _FINDER_COLUMN_ALL_QWERTYKEYBOAD_2 = "rule.qwertyKeyboad = ?";
	private static final String _FINDER_COLUMN_ALL_QWERTYKEYBOAD_3 = "(rule.qwertyKeyboad IS NULL OR rule.qwertyKeyboad = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Rule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Rule exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(RulePersistenceImpl.class);
}