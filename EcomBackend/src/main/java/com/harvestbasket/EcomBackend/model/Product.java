package com.harvestbasket.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product
{    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private int productid;
	
	
	@Column(nullable=false)
	@NotEmpty(message="category Name is mandatory")
	@Pattern(regexp="[a-zA-Z ]{3,250}",message="can contan only alphabets manditatory")
	private String productname;
	
	@Column(nullable=true)
	@NotEmpty(message="category Name is mandatory")
	@Pattern(regexp="[a-zA-Z ]{3,250}",message="can contan only alphabets manditatory")
	private String productdec;
	
	@Column(nullable=true)
	@Range(min=10,max=10000)
	private int productstock;
	
	@Column(nullable=true)
	@Range(min=10,max=10000)
	private int productprice;
	
	@Transient
	@Column(nullable=true)
	MultipartFile pimage;
	
	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	@ManyToOne
	private Category productcategory;
	
	@ManyToOne
	private Seller productseller;


	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdec() {
		return productdec;
	}

	public void setProductdec(String productdec) {
		this.productdec = productdec;
	}

	public int getProductstock() {
		return productstock;
	}

	public void setProductstock(int productstock) {
		this.productstock = productstock;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public Category getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(Category productcategory) {
		this.productcategory = productcategory;
	}

	public Seller getProductseller() {
		return productseller;
	}

	public void setProductseller(Seller productseller) {
		this.productseller = productseller;
	}	
	
}