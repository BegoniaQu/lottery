package com.homedo.as.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * Created by quyang on 2018/4/23.
 */
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("*.html", "/WEB-INF/views/decorator.jsp").
                addExcludedPath("/login.html").addExcludedPath("/swagger*");
    }
}
