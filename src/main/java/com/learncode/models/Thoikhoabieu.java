package com.learncode.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "qtht_thoikhoabieus")
public class Thoikhoabieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lophocid")
	private Lophoc lophoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monhocid")
	private  Monhoc monhoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "giaovienid")
	private Giaovien giaovien;
	
	
	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String phonghoc;
	
	private Integer thu;
	
	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String thoiluong;
	

	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String thoigian;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date ngaybatdau;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date ngayketthuc;
	public Thoikhoabieu() {
		super();
	}
	public Thoikhoabieu(Integer id, Lophoc lophoc, Monhoc monhoc, Giaovien giaovien, String phonghoc, Integer thu,
			String thoiluong, String thoigian, Date ngaybatdau, Date ngayketthuc) {
		super();
		this.id = id;
		this.lophoc = lophoc;
		this.monhoc = monhoc;
		this.giaovien = giaovien;
		this.phonghoc = phonghoc;
		this.thu = thu;
		this.thoiluong = thoiluong;
		this.thoigian = thoigian;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Lophoc getLophoc() {
		return lophoc;
	}
	public void setLophoc(Lophoc lophoc) {
		this.lophoc = lophoc;
	}
	public Monhoc getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(Monhoc monhoc) {
		this.monhoc = monhoc;
	}
	public Giaovien getGiaovien() {
		return giaovien;
	}
	public void setGiaovien(Giaovien giaovien) {
		this.giaovien = giaovien;
	}
	public String getPhonghoc() {
		return phonghoc;
	}
	public void setPhonghoc(String phonghoc) {
		this.phonghoc = phonghoc;
	}
	public Integer getThu() {
		return thu;
	}
	public void setThu(Integer thu) {
		this.thu = thu;
	}
	public String getThoiluong() {
		return thoiluong;
	}
	public void setThoiluong(String thoiluong) {
		this.thoiluong = thoiluong;
	}
	public String getThoigian() {
		return thoigian;
	}
	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	public Date getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public Date getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
	
	
	

}
