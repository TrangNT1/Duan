package com.learncode.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "qtht_sinhviens")
public class Sinhvien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String hovaten;
	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String diachi;
	@Column(length = 50, columnDefinition = "nvarchar(50)")
	private String phone;
	
	private Boolean gioitinh;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date birthday;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lophocid")
	private Lophoc lophoc;


	@OneToMany(mappedBy = "sinhvien", fetch = FetchType.LAZY)
	Set<Diem> diem;
	
	public Set<Diem> getDiem() {
		return diem;
	}

	public Sinhvien() {
		super();
	}


	public Sinhvien(Integer id, String hovaten, String diachi, String phone, Boolean gioitinh, Date birthday,
			Lophoc lophoc) {
		super();
		this.id = id;
		this.hovaten = hovaten;
		this.diachi = diachi;
		this.phone = phone;
		this.gioitinh = gioitinh;
		this.birthday = birthday;
		this.lophoc = lophoc;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getHovaten() {
		return hovaten;
	}


	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}


	public String getDiachi() {
		return diachi;
	}


	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Boolean getGioitinh() {
		return gioitinh;
	}


	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Lophoc getLophoc() {
		return lophoc;
	}


	public void setLophoc(Lophoc lophoc) {
		this.lophoc = lophoc;
	}
	
}
