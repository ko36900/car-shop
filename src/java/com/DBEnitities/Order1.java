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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOid", query = "SELECT o FROM Order1 o WHERE o.oid = :oid"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findByOrderDate", query = "SELECT o FROM Order1 o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Order1.findByGooodsPrice", query = "SELECT o FROM Order1 o WHERE o.gooodsPrice = :gooodsPrice"),
    @NamedQuery(name = "Order1.findByTotalPrice", query = "SELECT o FROM Order1 o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "Order1.findByDistributionTypedpid", query = "SELECT o FROM Order1 o WHERE o.distributionTypedpid = :distributionTypedpid"),
    @NamedQuery(name = "Order1.findByCourierNumber", query = "SELECT o FROM Order1 o WHERE o.courierNumber = :courierNumber"),
    @NamedQuery(name = "Order1.findByReDistributionTypedpid", query = "SELECT o FROM Order1 o WHERE o.reDistributionTypedpid = :reDistributionTypedpid"),
    @NamedQuery(name = "Order1.findByReturnCourierNumber", query = "SELECT o FROM Order1 o WHERE o.returnCourierNumber = :returnCourierNumber"),
    @NamedQuery(name = "Order1.findByIsCarriageFree", query = "SELECT o FROM Order1 o WHERE o.isCarriageFree = :isCarriageFree"),
    @NamedQuery(name = "Order1.findByHasPaied", query = "SELECT o FROM Order1 o WHERE o.hasPaied = :hasPaied"),
    @NamedQuery(name = "Order1.findByIsArayacak", query = "SELECT o FROM Order1 o WHERE o.isArayacak = :isArayacak"),
    @NamedQuery(name = "Order1.findByName", query = "SELECT o FROM Order1 o WHERE o.name = :name"),
    @NamedQuery(name = "Order1.findByTelephone", query = "SELECT o FROM Order1 o WHERE o.telephone = :telephone"),
    @NamedQuery(name = "Order1.findByArrivetime", query = "SELECT o FROM Order1 o WHERE o.arrivetime = :arrivetime"),
    @NamedQuery(name = "Order1.findByPayType", query = "SELECT o FROM Order1 o WHERE o.payType = :payType"),
    @NamedQuery(name = "Order1.findByReturnPrice", query = "SELECT o FROM Order1 o WHERE o.returnPrice = :returnPrice")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Oid")
    private Integer oid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "gooods_price")
    private BigDecimal gooodsPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Size(max = 50)
    @Column(name = "DistributionType_dpid")
    private String distributionTypedpid;
    @Size(max = 50)
    @Column(name = "courier_number")
    private String courierNumber;
    @Size(max = 50)
    @Column(name = "ReDistributionType_dpid")
    private String reDistributionTypedpid;
    @Size(max = 50)
    @Column(name = "return_courier_number")
    private String returnCourierNumber;
    @Column(name = "is_carriage_free")
    private Boolean isCarriageFree;
    @Column(name = "has_paied")
    private Boolean hasPaied;
    @Column(name = "is_arayacak")
    private Boolean isArayacak;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "arrivetime")
    @Temporal(TemporalType.DATE)
    private Date arrivetime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address_aid")
    private String addressAid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pay_type")
    private String payType;
    @Column(name = "return_price")
    private BigDecimal returnPrice;
    @JoinColumn(name = "Client_cid", referencedColumnName = "Cid")
    @ManyToOne
    private Client clientcid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order1")
    private List<OrderHasAutoparts> orderHasAutopartsList;

    public Order1() {
    }

    public Order1(Integer oid) {
        this.oid = oid;
    }

    public Order1(Integer oid, String status, Date orderDate, BigDecimal gooodsPrice, BigDecimal totalPrice, String name, String telephone, String addressAid, String payType) {
        this.oid = oid;
        this.status = status;
        this.orderDate = orderDate;
        this.gooodsPrice = gooodsPrice;
        this.totalPrice = totalPrice;
        this.name = name;
        this.telephone = telephone;
        this.addressAid = addressAid;
        this.payType = payType;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getGooodsPrice() {
        return gooodsPrice;
    }

    public void setGooodsPrice(BigDecimal gooodsPrice) {
        this.gooodsPrice = gooodsPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDistributionTypedpid() {
        return distributionTypedpid;
    }

    public void setDistributionTypedpid(String distributionTypedpid) {
        this.distributionTypedpid = distributionTypedpid;
    }

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber;
    }

    public String getReDistributionTypedpid() {
        return reDistributionTypedpid;
    }

    public void setReDistributionTypedpid(String reDistributionTypedpid) {
        this.reDistributionTypedpid = reDistributionTypedpid;
    }

    public String getReturnCourierNumber() {
        return returnCourierNumber;
    }

    public void setReturnCourierNumber(String returnCourierNumber) {
        this.returnCourierNumber = returnCourierNumber;
    }

    public Boolean getIsCarriageFree() {
        return isCarriageFree;
    }

    public void setIsCarriageFree(Boolean isCarriageFree) {
        this.isCarriageFree = isCarriageFree;
    }

    public Boolean getHasPaied() {
        return hasPaied;
    }

    public void setHasPaied(Boolean hasPaied) {
        this.hasPaied = hasPaied;
    }

    public Boolean getIsArayacak() {
        return isArayacak;
    }

    public void setIsArayacak(Boolean isArayacak) {
        this.isArayacak = isArayacak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    public String getAddressAid() {
        return addressAid;
    }

    public void setAddressAid(String addressAid) {
        this.addressAid = addressAid;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(BigDecimal returnPrice) {
        this.returnPrice = returnPrice;
    }

    public Client getClientcid() {
        return clientcid;
    }

    public void setClientcid(Client clientcid) {
        this.clientcid = clientcid;
    }

    @XmlTransient
    public List<OrderHasAutoparts> getOrderHasAutopartsList() {
        return orderHasAutopartsList;
    }

    public void setOrderHasAutopartsList(List<OrderHasAutoparts> orderHasAutopartsList) {
        this.orderHasAutopartsList = orderHasAutopartsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DBEnitities.Order1[ oid=" + oid + " ]";
    }
    
}
