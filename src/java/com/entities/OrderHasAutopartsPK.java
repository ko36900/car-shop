/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vita_
 */
@Embeddable
public class OrderHasAutopartsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Autoparts_apid")
    private int autopartsapid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Order_oid")
    private int orderoid;

    public OrderHasAutopartsPK() {
    }

    public OrderHasAutopartsPK(int autopartsapid, int orderoid) {
        this.autopartsapid = autopartsapid;
        this.orderoid = orderoid;
    }

    public int getAutopartsapid() {
        return autopartsapid;
    }

    public void setAutopartsapid(int autopartsapid) {
        this.autopartsapid = autopartsapid;
    }

    public int getOrderoid() {
        return orderoid;
    }

    public void setOrderoid(int orderoid) {
        this.orderoid = orderoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) autopartsapid;
        hash += (int) orderoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasAutopartsPK)) {
            return false;
        }
        OrderHasAutopartsPK other = (OrderHasAutopartsPK) object;
        if (this.autopartsapid != other.autopartsapid) {
            return false;
        }
        if (this.orderoid != other.orderoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.OrderHasAutopartsPK[ autopartsapid=" + autopartsapid + ", orderoid=" + orderoid + " ]";
    }
    
}
