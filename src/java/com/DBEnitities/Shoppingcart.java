/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DBEnitities;

import java.io.Serializable;
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
@Table(name = "shoppingcart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findByAutopartsapid", query = "SELECT s FROM Shoppingcart s WHERE s.shoppingcartPK.autopartsapid = :autopartsapid"),
    @NamedQuery(name = "Shoppingcart.findByClientcid", query = "SELECT s FROM Shoppingcart s WHERE s.shoppingcartPK.clientcid = :clientcid"),
    @NamedQuery(name = "Shoppingcart.findByNumber", query = "SELECT s FROM Shoppingcart s WHERE s.number = :number"),
    @NamedQuery(name = "Shoppingcart.findByAddTime", query = "SELECT s FROM Shoppingcart s WHERE s.addTime = :addTime")})
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShoppingcartPK shoppingcartPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Number")
    private int number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "add_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime;
    @JoinColumn(name = "Autoparts_apid", referencedColumnName = "Apid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autoparts autoparts;
    @JoinColumn(name = "Client_cid", referencedColumnName = "Cid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;

    public Shoppingcart() {
    }

    public Shoppingcart(ShoppingcartPK shoppingcartPK) {
        this.shoppingcartPK = shoppingcartPK;
    }

    public Shoppingcart(ShoppingcartPK shoppingcartPK, int number, Date addTime) {
        this.shoppingcartPK = shoppingcartPK;
        this.number = number;
        this.addTime = addTime;
    }

    public Shoppingcart(int autopartsapid, int clientcid) {
        this.shoppingcartPK = new ShoppingcartPK(autopartsapid, clientcid);
    }

    public ShoppingcartPK getShoppingcartPK() {
        return shoppingcartPK;
    }

    public void setShoppingcartPK(ShoppingcartPK shoppingcartPK) {
        this.shoppingcartPK = shoppingcartPK;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Autoparts getAutoparts() {
        return autoparts;
    }

    public void setAutoparts(Autoparts autoparts) {
        this.autoparts = autoparts;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingcartPK != null ? shoppingcartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.shoppingcartPK == null && other.shoppingcartPK != null) || (this.shoppingcartPK != null && !this.shoppingcartPK.equals(other.shoppingcartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DBEnitities.Shoppingcart[ shoppingcartPK=" + shoppingcartPK + " ]";
    }
    
}
