/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DBEnitities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vita_
 */
@Entity
@Table(name = "clientkind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientkind.findAll", query = "SELECT c FROM Clientkind c"),
    @NamedQuery(name = "Clientkind.findByKid", query = "SELECT c FROM Clientkind c WHERE c.kid = :kid"),
    @NamedQuery(name = "Clientkind.findByName", query = "SELECT c FROM Clientkind c WHERE c.name = :name")})
public class Clientkind implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Kid")
    private Integer kid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @OneToMany(mappedBy = "ckind")
    private List<Client> clientList;

    public Clientkind() {
    }

    public Clientkind(Integer kid) {
        this.kid = kid;
    }

    public Clientkind(Integer kid, String name) {
        this.kid = kid;
        this.name = name;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kid != null ? kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientkind)) {
            return false;
        }
        Clientkind other = (Clientkind) object;
        if ((this.kid == null && other.kid != null) || (this.kid != null && !this.kid.equals(other.kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DBEnitities.Clientkind[ kid=" + kid + " ]";
    }
    
}
