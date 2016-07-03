package com.Links.DataDao;

import com.Links.Beans.LinkTypeBean;
import com.Links.Beans.LinksBean;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DataDaoImpl implements DataDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<LinksBean> getAllLinks() {
        Session session = this.sessionFactory.openSession();
        List<LinksBean> linksList = session.createQuery("from LinksBean").list();
        session.close();
        return linksList;
    }

    @Transactional
    public int insertLinks(LinksBean linkBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(linkBean);
        tx.commit();
        return ((Integer) session.getIdentifier(linkBean)).intValue();
    }

    public LinksBean getLinKById(int id) {
        LinksBean linkBean1 = (LinksBean) this.sessionFactory.openSession().load(LinksBean.class, Integer.valueOf(id));
        if (linkBean1 != null) {
            return linkBean1;
        }
        return null;
    }

    public int UpdateLinks(LinksBean linkBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(linkBean);
        tx.commit();
        return ((Integer) session.getIdentifier(linkBean)).intValue();
    }

    public int deleteLinks(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        LinksBean link = (LinksBean) session.load(LinksBean.class, Integer.valueOf(id));
        session.delete(link);
        tx.commit();
        return ((Integer) session.getIdentifier(link)).intValue();
    }

    public LinkTypeBean getLinkTypeById(int id) {
        LinkTypeBean linkTypeBean = null;
        Session session = this.sessionFactory.openSession();
        Criteria linkCriteria = session.createCriteria(LinkTypeBean.class, "linkType");
        linkCriteria.add(Restrictions.eq("linkType.id", Integer.valueOf(id)));
        LinkTypeBean linkTypeBean1 = (LinkTypeBean) linkCriteria.uniqueResult();
        if (linkTypeBean1 != null) {
            linkTypeBean = linkTypeBean1;
        }
        session.close();
        return linkTypeBean;
    }

    public List<LinkTypeBean> getAllLinkTypes() {
        Session session = this.sessionFactory.openSession();
        List<LinkTypeBean> linkTypeList = session.createQuery("from LinkTypeBean").list();
        session.close();
        return linkTypeList;
    }

    public List<LinksBean> getLinksByLinkTypeId(int linkTypeId) {
        Session session = this.sessionFactory.openSession();
        String linkTypeIdString = String.valueOf(linkTypeId);
        Criteria linkCriteria = session.createCriteria(LinksBean.class, "link");
        linkCriteria.add(Restrictions.eq("link.linkType", linkTypeIdString));
        return linkCriteria.list();
    }

    public int insertLinkType(LinkTypeBean linkTypeBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(linkTypeBean);
        tx.commit();
        return ((Integer) session.getIdentifier(linkTypeBean)).intValue();
    }

    public int deleteCategory(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        LinkTypeBean linkType = (LinkTypeBean) session.load(LinkTypeBean.class, Integer.valueOf(id));
        session.delete(linkType);
        tx.commit();
        return ((Integer) session.getIdentifier(linkType)).intValue();
    }

    public void deleteLinksByCategory(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String linkTypeIdString = String.valueOf(id);
        Criteria deleteLinksCriteria = session.createCriteria(LinksBean.class, "link");
        deleteLinksCriteria.add(Restrictions.eq("link.linkType", linkTypeIdString));
        List<LinksBean> linkBeanlist = deleteLinksCriteria.list();
        for (LinksBean link : linkBeanlist) {
            session.delete(link);
        }
        tx.commit();
    }

    public void updateCategory(LinkTypeBean linkTypeBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(linkTypeBean);
        tx.commit();
    }
}