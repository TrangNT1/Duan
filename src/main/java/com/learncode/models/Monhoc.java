package com.learncode.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "qtht_monhocs")
public class Monhoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String tenmonhoc;
	

	@OneToMany(mappedBy = "monhoc", fetch = FetchType.LAZY)
	Set<Diem> diem;
	

	@OneToMany(mappedBy = "monhoc", fetch = FetchType.LAZY)
	Set<Thoikhoabieu> thoikhoabieu;
	
	public Set<Diem> getDiem() {
		return diem;
	}
	public Set<Thoikhoabieu> getThoikhoabieu() {
		return thoikhoabieu;
	}
	public Monhoc() {
		super();
	}
	
	public Monhoc(Integer id, String tenmonhoc) {
		super();
		this.id = id;
		this.tenmonhoc = tenmonhoc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTenmonhoc() {
		return tenmonhoc;
	}
	public void setTenmonhoc(String tenmonhoc) {
		this.tenmonhoc = tenmonhoc;
	}
	
	
}
