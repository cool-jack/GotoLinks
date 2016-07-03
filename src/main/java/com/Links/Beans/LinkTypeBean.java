/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.Id
 *  javax.persistence.Table
 */
package com.Links.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Links.TableConstants.LinkTypeTableConstants;

@Entity
@Table(name=LinkTypeTableConstants.TABLE_NAME)
public class LinkTypeBean {
    @Id
    @GeneratedValue
    @Column(name=LinkTypeTableConstants.ID)
    private Integer id;
    @Column(name=LinkTypeTableConstants.TYPE)
    private String linkType;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }
}