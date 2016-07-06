/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DBEnitities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vita_
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentid", query = "SELECT c FROM Comment c WHERE c.commentid = :commentid"),
    @NamedQuery(name = "Comment.findByComments", query = "SELECT c FROM Comment c WHERE c.comments = :comments")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Comment_id")
    private Integer commentid;
    @Size(max = 255)
    @Column(name = "Comments")
    private String comments;
    @JoinColumn(name = "Client_cid", referencedColumnName = "Cid")
    @ManyToOne
    private Client clientcid;
    @JoinColumn(name = "Autoparts_apid", referencedColumnName = "Apid")
    @ManyToOne
    private Autoparts autopartsapid;

    public Comment() {
    }

    public Comment(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Client getClientcid() {
        return clientcid;
    }

    public void setClientcid(Client clientcid) {
        this.clientcid = clientcid;
    }

    public Autoparts getAutopartsapid() {
        return autopartsapid;
    }

    public void setAutopartsapid(Autoparts autopartsapid) {
        this.autopartsapid = autopartsapid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentid != null ? commentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentid == null && other.commentid != null) || (this.commentid != null && !this.commentid.equals(other.commentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DBEnitities.Comment[ commentid=" + commentid + " ]";
    }
    
}
