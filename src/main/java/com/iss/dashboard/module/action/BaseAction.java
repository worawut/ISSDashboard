package com.iss.dashboard.module.action;

import com.iss.dashboard.ApplicationConstants;
import com.iss.dashboard.config.SessionBean;
import com.iss.dashboard.dto.UserLoginDTO;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by iWorawut on 29-Oct-16.
 */
public abstract class BaseAction implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public String action;
    public String mode;
    private Integer screenWidth;
    private Integer screenHeight;

    public String getExportTemplateName(String reportName)throws Exception{
        String value = String.valueOf(System.currentTimeMillis());
        int beginIndex = value.length()-5;
        int endIndex = value.length();
        return reportName+"_"+value.subSequence(beginIndex,endIndex);
    }

    public static String getMessage(String key) throws Exception{
        try {
            ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
            bean.setBasename("messages");
            return bean.getMessage(key, null, Locale.getDefault());
        } catch (Exception e) {
            return "Unresolved key: " + key;
        }
    }

    public static String redirect(String page){
        if(StringUtils.isNotEmpty(page)){
            return page + ".xhtml?faces-redirect=true";
        }
        return null;
    }

    public void contextRedirect(String pageUrl) throws Exception {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() +"/"+  pageUrl);
    }

    public Integer getScreenWidth() throws Exception{
        SessionBean sessionBean = getSessionBean();
        String width = sessionBean.getAvailWidth();

        if (StringUtils.isNotBlank(width)) {
            screenWidth = Integer.parseInt(width);
            return screenWidth;
        }
        return 0;
    }

    public Integer getScreenHeight()throws Exception {
        SessionBean sessionBean = getSessionBean();
        String height = sessionBean.getAvailHeight();

        if (StringUtils.isNotBlank(height)) {
            screenHeight = Integer.parseInt(height);
            return screenHeight;
        }
        return 0;

    }

    public void aadSession(Object obj, String sessionName) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(sessionName, obj);
    }

    public String getClientIpAddress() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");

        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        System.out.println("ipAddress:" + ipAddress);

        return ipAddress;
    }

    public abstract void initAction();

    public abstract void destroy();

    public void destroySessionAll() throws Exception{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);

        if(httpSession!=null){
            httpSession.invalidate();
        }
    }

    public SessionBean getSessionBean() throws Exception{
        SessionBean mBean = (SessionBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ApplicationConstants.MSessionBean.SESSION_BEAN);
        if (mBean == null) {
            mBean = new SessionBean();
        }
        return mBean;
    }

    public void setSessionBean(SessionBean sessionBean)throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(ApplicationConstants.MSessionBean.SESSION_BEAN,
                sessionBean);
    }

    public void setParam(String param,String value)throws Exception{
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestMap()
                .put(param,value);
    }
    public String getParam(String param) throws Exception{
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        String action = params.get(param);
        return action;
    }

    public void destroyerMB(String managedBean) throws Exception{
        if (StringUtils.isNotBlank(managedBean)) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object managedBeanObject = context.getExternalContext()
                    .getSessionMap().get(managedBean);
            if (managedBeanObject != null) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().remove(managedBean);
            }
        }
    }

//    public void message(String severity, String title, String msg) {
//        if (StringUtils.isNotEmpty(severity)) {
//            if (ApplicationConstants.Message.INFO.equalsIgnoreCase(severity)) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg));
//            } else if (ApplicationConstants.Message.WARN .equalsIgnoreCase(severity)) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, msg));
//            } else if (ApplicationConstants.Message.ERROR.equalsIgnoreCase(severity)) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
//            } else if (ApplicationConstants.Message.FATAL .equalsIgnoreCase(severity)) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title, msg));
//            }
//        }
//    }

    public void openPopup(String viewPage) throws Exception{
        if (StringUtils.isNotBlank(viewPage)) {
            Map<String, Object> options = new HashMap<String, Object>();
            options.put("modal", true);
            options.put("draggable", false);
            options.put("resizable", false);
            options.put("contentHeight", 430);
            options.put("contentWidth", 800);
            // hint: available options are modal, draggable, resizable, width,
            // height, contentWidth and contentHeight

            RequestContext.getCurrentInstance().openDialog(viewPage, options,
                    null);

        }
    }

    public void openFullSizePopup(String viewPage) throws Exception{
        if (StringUtils.isNotBlank(viewPage)) {
            double width = getScreenWidth();
            double height = getScreenHeight();

            Map<String, Object> options = new HashMap<String, Object>();
            options.put("modal", true);
            options.put("draggable", true);
            options.put("resizable", true);
            options.put("contentHeight", height);
            options.put("contentWidth", width);

            RequestContext.getCurrentInstance().openDialog(viewPage, getOptionPopupFull(),
                    null);

        }
    }

    public UserLoginDTO getUserLogin() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (UserLoginDTO) context.getExternalContext().getSessionMap()
                .get(ApplicationConstants.USER_LOGIN);
    }

    public String getJasperFilePath(ServletContext context, String jasperFile) {
        String compileDir = "/report/";

        return context.getRealPath(compileDir + jasperFile);
    }

    private void setCompileTempDir(ServletContext context, String uri) {
        System.setProperty("jasper.reports.compile.temp",
                context.getRealPath(uri));
    }

    public Map<String, Object> getOptionPopupFull()throws Exception {
        double width = getScreenWidth();
        double height = getScreenHeight();

        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", height - 400.00);
        options.put("contentWidth", (width - 200.00));

        return options;

    }
}
