package com.Links.DataDao;

import com.Links.Beans.LinkTypeBean;
import com.Links.Beans.LinksBean;
import java.util.List;

public interface DataDao {
    public List<LinksBean> getAllLinks();

    public int insertLinks(LinksBean var1);

    public LinksBean getLinKById(int var1);

    public int UpdateLinks(LinksBean var1);

    public int deleteLinks(int var1);

    public LinkTypeBean getLinkTypeById(int var1);

    public List<LinkTypeBean> getAllLinkTypes();

    public List<LinksBean> getLinksByLinkTypeId(int var1);

    public int insertLinkType(LinkTypeBean var1);

    public int deleteCategory(int var1);

    public void deleteLinksByCategory(int var1);

    public void updateCategory(LinkTypeBean var1);
}