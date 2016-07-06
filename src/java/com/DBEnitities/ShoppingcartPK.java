/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DBEnitities;

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
public class ShoppingcartPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Autoparts_apid")
    private int autopartsapid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Client_cid")
    private int clientcid;

    public ShoppingcartPK() {
    }

    public ShoppingcartPK(int autopartsapid, int clientcid) {
        this.autopartsapid = autopartsapid;
        this.clientcid = clientcid;
    }

    public int getAutopartsapid() {
        return autopartsapid;
    }

    public void setAutopartsapid(int autopartsapid) {
        this.autopartsapid = autopartsapid;
    }

    public int getClientcid() {
        return clientcid;
    }

    public void setClientcid(int clientcid) {
        this.clientcid = clientcid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) autopartsapid;
        hash += (int) clientcid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingcartPK)) {
            return false;
        }
        ShoppingcartPK other = (ShoppingcartPK) object;
        if (this.autopartsapid != other.autopartsapid) {
            return false;
        }
        if (this.clientcid != other.clientcid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DBEnitities.ShoppingcartPK[ autopartsapid=" + autopartsapid + ", clientcid=" + clientcid + " ]";
    }
    
}
