/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  com.Links.Beans.LinkTypeBean
 *  com.Links.Beans.LinksBean
 *  com.Links.DataService.DataService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.ModelAttribute
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.servlet.ModelAndView
 */
package com.Links.Controller;

import com.Links.Beans.LinkTypeBean;
import com.Links.Beans.LinksBean;
import com.Links.DataService.DataService;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
    @Autowired
    DataService dataService;
    
    @RequestMapping(value={"/"})
    public ModelAndView indexPage()
    {
        return new ModelAndView("redirect:links");
    }
    
    
    @RequestMapping(value={"AddLinks"})
    public ModelAndView getAddLinks(@ModelAttribute(value="linkBean") LinksBean linkBean) {
        List linkTypeList = this.dataService.getAllLinkType();
        return new ModelAndView("AddLinks", "linkTypeList", (Object)linkTypeList);
    }

    @RequestMapping(value={"addLink"})
    public ModelAndView AddLink(@ModelAttribute LinksBean linkBean) {
        this.dataService.insertLinks(linkBean);
        return new ModelAndView("redirect:links");
    }

    @RequestMapping(value={"links"})
    public ModelAndView getAllLinks() {
    	System.out.println("links started");
        List linksList = this.dataService.getAllLinks();
        List linkTypeList = this.dataService.getAllLinkType();
        HashMap<String, List> linksMap = new HashMap<String, List>();
        linksMap.put("linksList", linksList);
        linksMap.put("linkTypeList", linkTypeList);
        return new ModelAndView("Links", "linksMap", linksMap);
    }

    @RequestMapping(value={"delete"})
    public ModelAndView deleteLinks(@RequestParam int id) {
        this.dataService.deleteLinks(id);
        return new ModelAndView("redirect:links");
    }

    @RequestMapping(value={"editLink"})
    public ModelAndView editLink(@RequestParam int id, @ModelAttribute(value="linkBean") LinksBean linkBean) {
        LinksBean linksObject = this.dataService.getLinKById(id);
        List linkTypeList = this.dataService.getAllLinkType();
        String linkTypeLinkId = linksObject.getLinkType();
        LinkTypeBean linktTypeBean = this.dataService.getLinkTypeById(Integer.parseInt(linkTypeLinkId));
        HashMap<String, Object> editLinkObjectMap = new HashMap<String, Object>();
        editLinkObjectMap.put("LinksObject", (Object)linksObject);
        editLinkObjectMap.put("linkTypeList", linkTypeList);
        editLinkObjectMap.put("linkTypeFromLinkType", linktTypeBean.getLinkType());
        return new ModelAndView("EditLink", "editLinkObjectMap", editLinkObjectMap);
    }

    @RequestMapping(value={"updateLink"})
    public ModelAndView updateLink(@ModelAttribute LinksBean linkBean) {
        this.dataService.UpdateLinks(linkBean);
        return new ModelAndView("redirect:links");
    }

    @RequestMapping(value={"linkByCaregory"})
    public ModelAndView getLinkByCategory(@RequestParam int linkTypeId) {
        LinkTypeBean linkTypeBean = this.dataService.getLinkTypeById(linkTypeId);
        List linkTypeList = this.dataService.getAllLinkType();
        List linkBeanList = this.dataService.getLinksByLinkTypeId(linkTypeId);
        HashMap<String, Object> linkbyCategoryMap = new HashMap<String, Object>();
        linkbyCategoryMap.put("linkTypeBean", (Object)linkTypeBean);
        linkbyCategoryMap.put("linkTypeList", linkTypeList);
        linkbyCategoryMap.put("linkBeanList", linkBeanList);
        return new ModelAndView("LinkByCategory", "linkbyCategoryMap", linkbyCategoryMap);
    }

    @RequestMapping(value={"addCategory"})
    public ModelAndView addCategory(@ModelAttribute(value="linkTypeBean") LinkTypeBean linkTypeBean) {
        return new ModelAndView("AddCategory");
    }

    @RequestMapping(value={"insertCategory"})
    public ModelAndView insertCategory(@ModelAttribute LinkTypeBean linkTypeBean) {
        this.dataService.insertLinkType(linkTypeBean);
        return new ModelAndView("redirect:links");
    }

    @RequestMapping(value={"manageCategories"})
    public ModelAndView manageCategories(@RequestParam int id, @RequestParam String task, @ModelAttribute(value="linkTypeBean") LinkTypeBean linkTypeBean) {
        if (task.equals("delete")) {
            this.dataService.deleteCategoryFull(id);
            return new ModelAndView("redirect:links");
        }
        if (task.equals("edit")) {
            LinkTypeBean linkTypeBean1 = this.dataService.getLinkTypeById(id);
            return new ModelAndView("UpdateCategory", "linkTypeBean", (Object)linkTypeBean1);
        }
        if (task.equals("update")) {
            this.dataService.updateCategory(linkTypeBean);
            return new ModelAndView("redirect:links");
        }
        return new ModelAndView("redirect:links1");
    }
}