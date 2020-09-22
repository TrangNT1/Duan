package com.learncode.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qtht_diems")
public class Diem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double diem;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sinhvienid")
	private Sinhvien sinhvien;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "giaovienid")
	private Giaovien giaovien;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monhocid")
	private Monhoc monhoc;

	public Diem() {
		super();
	}

	public Diem(Integer id, Double diem, Sinhvien sinhvien, Giaovien giaovien, Monhoc monhoc) {
		super();
		this.id = id;
		this.diem = diem;
		this.sinhvien = sinhvien;
		this.giaovien = giaovien;
		this.monhoc = monhoc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}

	public Sinhvien getSinhvien() {
		return sinhvien;
	}

	public void setSinhvien(Sinhvien sinhvien) {
		this.sinhvien = sinhvien;
	}

	public Giaovien getGiaovien() {
		return giaovien;
	}

	public void setGiaovien(Giaovien giaovien) {
		this.giaovien = giaovien;
	}

	public Monhoc getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(Monhoc monhoc) {
		this.monhoc = monhoc;
	}


	
}
