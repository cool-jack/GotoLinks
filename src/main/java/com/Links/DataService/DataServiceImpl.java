package com.Links.DataService;

import com.Links.Beans.LinkTypeBean;
import com.Links.Beans.LinksBean;
import com.Links.DataDao.DataDao;
import com.Links.DataService.DataService;
import java.io.PrintStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DataServiceImpl
implements DataService {
    @Autowired
    DataDao dataDao;

    public List<LinksBean> getAllLinks() {
        return this.dataDao.getAllLinks();
    }

    public int insertLinks(LinksBean linkBean) {
        return this.dataDao.insertLinks(linkBean);
    }

    public LinksBean getLinKById(int id) {
        return this.dataDao.getLinKById(id);
    }

    public int UpdateLinks(LinksBean linkBean) {
        return this.dataDao.UpdateLinks(linkBean);
    }

    public int deleteLinks(int id) {
        return this.dataDao.deleteLinks(id);
    }

    public LinkTypeBean getLinkTypeById(int linkId) {
        return this.dataDao.getLinkTypeById(linkId);
    }

    public List<LinkTypeBean> getAllLinkType() {
        return this.dataDao.getAllLinkTypes();
    }

    public List<LinksBean> getLinksByLinkTypeId(int linkTypeId) {
        return this.dataDao.getLinksByLinkTypeId(linkTypeId);
    }

    public int insertLinkType(LinkTypeBean linkTypeBean) {
        return this.dataDao.insertLinkType(linkTypeBean);
    }

    public int deleteCategory(int id) {
        return this.dataDao.deleteCategory(id);
    }

    public void deleteLinksByCategory(int id) {
        this.dataDao.deleteLinksByCategory(id);
        System.out.println("links by Categories deleted");
    }

    public void deleteCategoryFull(int id) {
        this.dataDao.deleteLinksByCategory(id);
        this.dataDao.deleteCategory(id);
        System.out.println("links by Categories deleted");
    }

    public void updateCategory(LinkTypeBean linkTypeBean) {
        this.dataDao.updateCategory(linkTypeBean);
    }
}