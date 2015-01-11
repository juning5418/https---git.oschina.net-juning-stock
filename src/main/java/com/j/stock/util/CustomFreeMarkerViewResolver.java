package com.j.stock.util;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class CustomFreeMarkerViewResolver extends AbstractTemplateViewResolver {

    public CustomFreeMarkerViewResolver() {
        setViewClass(requiredViewClass());
    }

    @Override
    protected Class requiredViewClass() {
        return CustomFreeMarkerView.class;
    }
}
