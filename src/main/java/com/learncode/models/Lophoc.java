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
@Table(name = "qtht_lophocs")
public class Lophoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String tenlop;
	@OneToMany(mappedBy = "lophoc", fetch = FetchType.LAZY)
	Set<Giaovien> giaovien;
	
	@OneToMany(mappedBy = "lophoc", fetch = FetchType.LAZY)
	Set<Sinhvien> sinhvien;
	
	@OneToMany(mappedBy = "lophoc", fetch = FetchType.LAZY)
	Set<Thoikhoabieu> thoikhoabieu;
	
	public Set<Sinhvien> getSinhvien() {
		return sinhvien;
	}
	public Set<Giaovien> getGiaovien() {
		return giaovien;
	}
	public Set<Thoikhoabieu> getThoikhoabieu() {
		return thoikhoabieu;
	}
	public Lophoc() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public Lophoc(Integer id, String tenlop) {
		super();
		this.id = id;
		this.tenlop = tenlop;
	}
	@Override
	public String toString() {
		return "Lophoc [id=" + id + ", tenlop=" + tenlop + "]";
	}

	
}
