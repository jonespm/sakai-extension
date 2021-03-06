/*
 * Copyright ©2016 Kaltura, Inc.
 */
package org.sakaiproject.kaltura.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.kaltura.Constants;
/**
 * Controller to handle the main.jsp view
 * 
 * @author Yegeneswari Nagappan (ynagappan @ unicon.net)
 *
 */
public class MediaGalleryController extends BaseController {

    private ServerConfigurationService serverConfigurationService;
    public void setServerConfigurationService(ServerConfigurationService serverConfigurationService) {
        this.serverConfigurationService = serverConfigurationService;
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();

        String returnData[] = kalturaLTIService.launchLTIRequest(Constants.MEDIA_GALLERY);
        model.put("returndata", returnData[0]);

        String isDebug = "kaltura." + Constants.MEDIA_GALLERY + ".debug";
        model.put("isDebug", serverConfigurationService.getString(isDebug, "off"));

        return new ModelAndView("mediagallery", model);
    }

}
