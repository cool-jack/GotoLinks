/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  com.Links.Beans.LinkTypeBean
 *  com.Links.Beans.LinksBean
 */
package com.Links.DataService;

import com.Links.Beans.LinkTypeBean;
import com.Links.Beans.LinksBean;
import java.util.List;

public interface DataService {
    public List<LinksBean> getAllLinks();

    public int insertLinks(LinksBean var1);

    public LinksBean getLinKById(int var1);

    public int UpdateLinks(LinksBean var1);

    public int deleteLinks(int var1);

    public LinkTypeBean getLinkTypeById(int var1);

    public List<LinkTypeBean> getAllLinkType();

    public List<LinksBean> getLinksByLinkTypeId(int var1);

    public int insertLinkType(LinkTypeBean var1);

    public int deleteCategory(int var1);

    public void deleteLinksByCategory(int var1);

    public void deleteCategoryFull(int var1);

    public void updateCategory(LinkTypeBean var1);
}