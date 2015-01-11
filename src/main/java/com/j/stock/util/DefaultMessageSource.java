package com.j.stock.util;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

public class DefaultMessageSource {

    private static final Log log = LogFactory.getLog(DefaultMessageSource.class);

    protected MessageSource messageSource;

    /**
     * @return the messageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * @param messageSource the messageSource to set
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * @param code
     * @return
     */
    protected String getMessage(String code) {
        return this.getMessage(code, null, null);
    }

    /**
     * @param code
     * @param object
     * @return
     */
    protected String getMessage(String code, Object object) {
        return this.getMessage(code, new Object[]{object}, null);
    }

    /**
     * @param code
     * @param args
     * @return
     */
    protected String getMessage(String code, Object args[]) {
        return this.getMessage(code, args, null);
    }

    /**
     * @param code
     * @param args
     * @param defaultMessage
     * @return
     */
    protected String getMessage(String code, Object args[], String defaultMessage) {
        if (messageSource == null) {
            log.warn("messageSource is null; You may not set bean reference to it in spring config file," +
                    "Please check your spring configuration first!");
            return "";
        }
        return messageSource.getMessage(code, args, defaultMessage, Locale.getDefault());
    }
}
