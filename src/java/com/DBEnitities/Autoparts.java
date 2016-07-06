/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DBEnitities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vita_
 */
@Entity
@Table(name = "autoparts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autoparts.findAll", query = "SELECT a FROM Autoparts a"),
    @NamedQuery(name = "Autoparts.findByApid", query = "SELECT a FROM Autoparts a WHERE a.apid = :apid"),
    @NamedQuery(name = "Autoparts.findByApname", query = "SELECT a FROM Autoparts a WHERE a.apname = :apname"),
    @NamedQuery(name = "Autoparts.findByImageLink1", query = "SELECT a FROM Autoparts a WHERE a.imageLink1 = :imageLink1"),
    @NamedQuery(name = "Autoparts.findByIsSale", query = "SELECT a FROM Autoparts a WHERE a.isSale = :isSale"),
    @NamedQuery(name = "Autoparts.findByOldPrice", query = "SELECT a FROM Autoparts a WHERE a.oldPrice = :oldPrice"),
    @NamedQuery(name = "Autoparts.findByPrice", query = "SELECT a FROM Autoparts a WHERE a.price = :price"),
    @NamedQuery(name = "Autoparts.findByIsGeneral", query = "SELECT a FROM Autoparts a WHERE a.isGeneral = :isGeneral"),
    @NamedQuery(name = "Autoparts.findByVirtualInventory", query = "SELECT a FROM Autoparts a WHERE a.virtualInventory = :virtualInventory"),
    @NamedQuery(name = "Autoparts.findByInventory", query = "SELECT a FROM Autoparts a WHERE a.inventory = :inventory"),
    @NamedQuery(name = "Autoparts.findByProductiveYear", query = "SELECT a FROM Autoparts a WHERE a.productiveYear = :productiveYear"),
    @NamedQuery(name = "Autoparts.findByShelveAte", query = "SELECT a FROM Autoparts a WHERE a.shelveAte = :shelveAte"),
    @NamedQuery(name = "Autoparts.findByHotProduct", query = "SELECT a FROM Autoparts a WHERE a.hotProduct = :hotProduct"),
    @NamedQuery(name = "Autoparts.findByBrand", query = "SELECT a FROM Autoparts a WHERE a.brand = :brand")})
public class Autoparts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Apid")
    private Integer apid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Apname")
    private String apname;
    @Size(max = 50)
    @Column(name = "image_link1")
    private String imageLink1;
    @Lob
    @Size(max = 65535)
    @Column(name = "Introduction")
    private String introduction;
    @Column(name = "is_sale")
    private Boolean isSale;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "old_price")
    private BigDecimal oldPrice;
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "is_general")
    private Boolean isGeneral;
    @Column(name = "virtual_inventory")
    private Integer virtualInventory;
    @Column(name = "Inventory")
    private Integer inventory;
    @Column(name = "productive_year")
    @Temporal(TemporalType.TIMESTAMP)
    private Date productiveYear;
    @Column(name = "shelve_ate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shelveAte;
    @Column(name = "hot_product")
    private Integer hotProduct;
    @Size(max = 255)
    @Column(name = "Brand")
    private String brand;
    @JoinColumn(name = "SecondClass_scid", referencedColumnName = "Category_ID")
    @ManyToOne
    private Category secondClassscid;
    @OneToMany(mappedBy = "autopartsapid")
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autoparts")
    private List<OrderHasAutoparts> orderHasAutopartsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autoparts")
    private List<Shoppingcart> shoppingcartList;

    public Autoparts() {
    }

    public Autoparts(Integer apid) {
        this.apid = apid;
    }

    public Autoparts(Integer apid, String apname) {
        this.apid = apid;
        this.apname = apname;
    }

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public String getApname() {
        return apname;
    }

    public void setApname(String apname) {
        this.apname = apname;
    }

    public String getImageLink1() {
        return imageLink1;
    }

    public void setImageLink1(String imageLink1) {
        this.imageLink1 = imageLink1;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Boolean getIsSale() {
        return isSale;
    }

    public void setIsSale(Boolean isSale) {
        this.isSale = isSale;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsGeneral() {
        return isGeneral;
    }

    public void setIsGeneral(Boolean isGeneral) {
        this.isGeneral = isGeneral;
    }

    public Integer getVirtualInventory() {
        return virtualInventory;
    }

    public void setVirtualInventory(Integer virtualInventory) {
        this.virtualInventory = virtualInventory;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Date getProductiveYear() {
        return productiveYear;
    }

    public void setProductiveYear(Date productiveYear) {
        this.productiveYear = productiveYear;
    }

    public Date getShelveAte() {
        return shelveAte;
    }

    public void setShelveAte(Date shelveAte) {
        this.shelveAte = shelveAte;
    }

    public Integer getHotProduct() {
        return hotProduct;
    }

    public void setHotProduct(Integer hotProduct) {
        this.hotProduct = hotProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getSecondClassscid() {
        return secondClassscid;
    }

    public void setSecondClassscid(Category secondClassscid) {
        this.secondClassscid = secondClassscid;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient
    public List<OrderHasAutoparts> getOrderHasAutopartsList() {
        return orderHasAutopartsList;
    }

    public void setOrderHasAutopartsList(List<OrderHasAutoparts> orderHasAutopartsList) {
        this.orderHasAutopartsList = orderHasAutopartsList;
    }

    @XmlTransient
    public List<Shoppingcart> getShoppingcartList() {
        return shoppingcartList;
    }

    public void setShoppingcartList(List<Shoppingcart> shoppingcartList) {
        this.shoppingcartList = shoppingcartList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apid != null ? apid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autoparts)) {
            return false;
        }
        Autoparts other = (Autoparts) object;
        if ((this.apid == null && other.apid != null) || (this.apid != null && !this.apid.equals(other.apid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DBEnitities.Autoparts[ apid=" + apid + " ]";
    }
    
}
