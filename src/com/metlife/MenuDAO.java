package com.metlife;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Menu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.metlife.Menu
 * @author MyEclipse Persistence Tools
 */
public class MenuDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MenuDAO.class);
	// property constants
	public static final String MENU_NAME = "menuName";
	public static final String MENU_LEV = "menuLev";
	public static final String MENU_ORDER = "menuOrder";
	public static final String PARENT_MENU_CODE = "parentMenuCode";
	public static final String URL = "url";

	public void save(Menu transientInstance) {
		log.debug("saving Menu instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Menu persistentInstance) {
		log.debug("deleting Menu instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Menu findById(java.lang.String id) {
		log.debug("getting Menu instance with id: " + id);
		try {
			Menu instance = (Menu) getSession().get("com.metlife.Menu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Menu> findByExample(Menu instance) {
		log.debug("finding Menu instance by example");
		try {
			List<Menu> results = (List<Menu>) getSession()
					.createCriteria("com.metlife.Menu").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Menu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Menu as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Menu> findByMenuName(Object menuName) {
		return findByProperty(MENU_NAME, menuName);
	}

	public List<Menu> findByMenuLev(Object menuLev) {
		return findByProperty(MENU_LEV, menuLev);
	}

	public List<Menu> findByMenuOrder(Object menuOrder) {
		return findByProperty(MENU_ORDER, menuOrder);
	}

	public List<Menu> findByParentMenuCode(Object parentMenuCode) {
		return findByProperty(PARENT_MENU_CODE, parentMenuCode);
	}

	public List<Menu> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findAll() {
		log.debug("finding all Menu instances");
		try {
			String queryString = "from Menu";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Menu merge(Menu detachedInstance) {
		log.debug("merging Menu instance");
		try {
			Menu result = (Menu) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Menu instance) {
		log.debug("attaching dirty Menu instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Menu instance) {
		log.debug("attaching clean Menu instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}