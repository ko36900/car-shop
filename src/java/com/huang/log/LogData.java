/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huang.log;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author huang
 */
@Entity
@Table(name = "logData")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogData.findAll", query = "SELECT l FROM LogData l"),
    @NamedQuery(name = "LogData.findByUserName", query = "SELECT l FROM LogData l WHERE l.userName = :userName"),
    @NamedQuery(name = "LogData.findBySecrectWord", query = "SELECT l FROM LogData l WHERE l.secrectWord = :secrectWord")})
public class LogData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "secrectWord")
    private String secrectWord;

    public LogData() {
    }

    public LogData(String userName) {
        this.userName = userName;
    }

    public LogData(String userName, String secrectWord) {
        this.userName = userName;
        this.secrectWord = secrectWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSecrectWord() {
        return secrectWord;
    }

    public void setSecrectWord(String secrectWord) {
        this.secrectWord = secrectWord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogData)) {
            return false;
        }
        LogData other = (LogData) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.huang.log.LogData[ userName=" + userName + " ]";
    }
    
}
