package com.orders.cruds.crud_ops.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lu_menu")
public class LuMenu {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "pk_menu_id")
	    private Integer pkMenuId;

		@Column(name = "menu_name")
	    private String menuName;

	    @Column(name = "parent_menu_id")
	    private Integer parentMenuId;

		public Integer getPkMenuId() {
			return pkMenuId;
		}

		public void setPkMenuId(Integer pkMenuId) {
			this.pkMenuId = pkMenuId;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public Integer getParentMenuId() {
			return parentMenuId;
		}

		public void setParentMenuId(Integer parentMenuId) {
			this.parentMenuId = parentMenuId;
		}

		

}
