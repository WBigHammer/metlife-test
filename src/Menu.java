

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MENU", schema = "MIS")
public class Menu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665303737231028890L;
	private String menuCode;
	private String menuName;
	private short menuLev;
	private String menuOrder;
	private String parentMenuCode;
	private String url;

	// Constructors

	@Override
	public String toString() {
		return "Menu [menuCode=" + menuCode + ", menuName=" + menuName
				+ ", menuLev=" + menuLev + ", menuOrder=" + menuOrder
				+ ", parentMenuCode=" + parentMenuCode + ", url=" + url + "]";
	}

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(String menuName, short menuLev, String menuOrder,
			String parentMenuCode, String url) {
		this.menuName = menuName;
		this.menuLev = menuLev;
		this.menuOrder = menuOrder;
		this.parentMenuCode = parentMenuCode;
		this.url = url;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "MENU_CODE", unique = true, nullable = false, length = 20)
	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	@Column(name = "MENU_NAME", length = 20)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "MENU_LEV", precision = 4, scale = 0)
	public short getMenuLev() {
		return this.menuLev;
	}

	public void setMenuLev(short menuLev) {
		this.menuLev = menuLev;
	}

	@Column(name = "MENU_ORDER", length = 10)
	public String getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder;
	}

	@Column(name = "PARENT_MENU_CODE", length = 20)
	public String getParentMenuCode() {
		return this.parentMenuCode;
	}

	public void setParentMenuCode(String parentMenuCode) {
		this.parentMenuCode = parentMenuCode;
	}

	@Column(name = "URL", length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}