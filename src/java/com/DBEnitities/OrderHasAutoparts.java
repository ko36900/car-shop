/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DBEnitities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vita_
 */
@Entity
@Table(name = "order_has_autoparts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHasAutoparts.findAll", query = "SELECT o FROM OrderHasAutoparts o"),
    @NamedQuery(name = "OrderHasAutoparts.findByAutopartsapid", query = "SELECT o FROM OrderHasAutoparts o WHERE o.orderHasAutopartsPK.autopartsapid = :autopartsapid"),
    @NamedQuery(name = "OrderHasAutoparts.findByOrderoid", query = "SELECT o FROM OrderHasAutoparts o WHERE o.orderHasAutopartsPK.orderoid = :orderoid"),
    @NamedQuery(name = "OrderHasAutoparts.findByDealPrice", query = "SELECT o FROM OrderHasAutoparts o WHERE o.dealPrice = :dealPrice"),
    @NamedQuery(name = "OrderHasAutoparts.findByNumber", query = "SELECT o FROM OrderHasAutoparts o WHERE o.number = :number"),
    @NamedQuery(name = "OrderHasAutoparts.findByReturnNumber", query = "SELECT o FROM OrderHasAutoparts o WHERE o.returnNumber = :returnNumber"),
    @NamedQuery(name = "OrderHasAutoparts.findByTime", query = "SELECT o FROM OrderHasAutoparts o WHERE o.time = :time")})
public class OrderHasAutoparts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderHasAutopartsPK orderHasAutopartsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "deal_price")
    private BigDecimal dealPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Number")
    private int number;
    @Column(name = "return_number")
    private Integer returnNumber;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "Autoparts_apid", referencedColumnName = "Apid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autoparts autoparts;
    @JoinColumn(name = "Order_oid", referencedColumnName = "Oid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order1 order1;

    public OrderHasAutoparts() {
    }

    public OrderHasAutoparts(OrderHasAutopartsPK orderHasAutopartsPK) {
        this.orderHasAutopartsPK = orderHasAutopartsPK;
    }

    public OrderHasAutoparts(OrderHasAutopartsPK orderHasAutopartsPK, BigDecimal dealPrice, int number) {
        this.orderHasAutopartsPK = orderHasAutopartsPK;
        this.dealPrice = dealPrice;
        this.number = number;
    }

    public OrderHasAutoparts(int autopartsapid, int orderoid) {
        this.orderHasAutopartsPK = new OrderHasAutopartsPK(autopartsapid, orderoid);
    }

    public OrderHasAutopartsPK getOrderHasAutopartsPK() {
        return orderHasAutopartsPK;
    }

    public void setOrderHasAutopartsPK(OrderHasAutopartsPK orderHasAutopartsPK) {
        this.orderHasAutopartsPK = orderHasAutopartsPK;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(Integer returnNumber) {
        this.returnNumber = returnNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Autoparts getAutoparts() {
        return autoparts;
    }

    public void setAutoparts(Autoparts autoparts) {
        this.autoparts = autoparts;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderHasAutopartsPK != null ? orderHasAutopartsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasAutoparts)) {
            return false;
        }
        OrderHasAutoparts other = (OrderHasAutoparts) object;
        if ((this.orderHasAutopartsPK == null && other.orderHasAutopartsPK != null) || (this.orderHasAutopartsPK != null && !this.orderHasAutopartsPK.equals(other.orderHasAutopartsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DBEnitities.OrderHasAutoparts[ orderHasAutopartsPK=" + orderHasAutopartsPK + " ]";
    }
    
}
