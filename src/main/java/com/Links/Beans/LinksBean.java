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

import com.Links.TableConstants.LinksTableConstants;

@Entity
@Table(name= LinksTableConstants.TABLE_NAME)
public class LinksBean {
    @Id
    @GeneratedValue
    @Column(name=LinksTableConstants.ID)
    private Integer id;
    @Column(name=LinksTableConstants.NAME)
    private String name;
    @Column(name=LinksTableConstants.LINK)
    private String links;
    @Column(name=LinksTableConstants.LINK_TYPE)
    private String linkType;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinks() {
        return this.links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }
}