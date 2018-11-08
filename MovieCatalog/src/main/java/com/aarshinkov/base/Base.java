package com.aarshinkov.base;

import java.text.*;
import java.util.*;
import javax.annotation.*;
import javax.servlet.http.*;

import com.aarshinkov.security.WebUser;
import org.slf4j.*;
import org.springframework.beans.propertyeditors.*;
import org.springframework.context.*;
import org.springframework.context.i18n.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;

public class Base
{
    @Resource(name = "messageSource")
    private MessageSource messageSource;

    private DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    private Logger log = LoggerFactory.getLogger(getClass());

    protected String getDateFormatted(Date date)
    {
        return sdf.format(date);
    }

    protected String getMessage(String key)
    {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    protected String getMessage(String key, Object... params)
    {
        return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
    }

    protected boolean isDBConnectError(Throwable exc)
    {
        Throwable ex = exc;

        while (true)
        {
            if (ex != null)
            {
                log.debug("Ex = " + ex.getClass().getName());
                log.debug("Msg = " + ex.getMessage());

                if (ex.toString().toLowerCase().contains("could not open connection")
                        || ex.toString().toLowerCase().contains("cannot get connection")
                        || ex.toString().toLowerCase().contains("could not get connection")
                        || ex.toString().toLowerCase().contains("connection is closed")
                        || ex.toString().toLowerCase().contains("connection pool"))
                {
                    return true;
                }
                else
                {
                    ex = ex.getCause();
                }
            }
            else
            {
                return false;
            }
        }
    }

//  protected String getHost(HttpServletRequest request)
//  {
//    String hostName = request.getHeader("X-FORWARDED-FOR");
//
//    if (hostName == null || "".equals(hostName))
//    {
//      hostName = request.getRemoteAddr();
//    }
//
//    return hostName;
//  }

    protected WebUser getWebUser()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try
        {
            return (WebUser) auth.getPrincipal();
        }
        catch (Exception e)
        {
            return null;
        }
    }

//  protected String getSessionId()
//  {
//    try
//    {
//      return RequestContextHolder.currentRequestAttributes().getSessionId();
//    }
//    catch (Throwable t)
//    {
//      return null;
//    }
//  }

//    @InitBinder
//    public void initBinder(WebDataBinder binder)
//    {
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//    }
}

