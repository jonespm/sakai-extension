/**
 * Copyright 2014 Sakaiproject Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.sakaiproject.kaltura.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.entitybroker.entityprovider.extension.ActionReturn;
import org.sakaiproject.kaltura.models.db.KalturaLtiAuthCode;
import org.sakaiproject.kaltura.models.errors.ErrorAuthCode;
import org.sakaiproject.kaltura.utils.common.JsonUtil;
import org.sakaiproject.kaltura.utils.common.RestUtil;

public class AuthCodeProviderService {

    private final Log log = LogFactory.getLog(AuthCodeProviderService.class);

    private AuthCodeService authCodeService;
    public void setAuthCodeService(AuthCodeService authCodeService) {
        this.authCodeService = authCodeService;
    }

    public void init() {
    }

    /**
     * Get the {@link KalturaLtiAuthCode} object associated with this ID
     * 
     * @param id the id of the auth code
     */
    public ActionReturn getAuthCode(String id) {
        ErrorAuthCode errorAuthCode = new ErrorAuthCode();

        KalturaLtiAuthCode kalturaLtiAuthCode = authCodeService.getAuthCode(id);

        return RestUtil.processActionReturn(errorAuthCode, JsonUtil.parseToJson(kalturaLtiAuthCode));
    }

    /**
     * Create a new {@link KalturaLtiAuthCode} oobject
     * 
     * @param data the data to create the new {@link KalturaLtiAuthCode} object
     */
    public ActionReturn createAuthCode(String data) {
        ErrorAuthCode errorAuthCode = new ErrorAuthCode();

        List<Object> kalturaLtiAuthCodes = JsonUtil.parseFromJson(data, KalturaLtiAuthCode.class);

        for (Object k : kalturaLtiAuthCodes) {
            if (!(k instanceof KalturaLtiAuthCode)) {
                continue;
            }

            KalturaLtiAuthCode kalturaLtiAuthCode = (KalturaLtiAuthCode) k;
            if (!kalturaLtiAuthCode.isValid()) {
                // current object is invalid, create fully constructed object
                kalturaLtiAuthCode = new KalturaLtiAuthCode(kalturaLtiAuthCode);
            }

            try {
                authCodeService.createAuthCode(kalturaLtiAuthCode);
            } catch (Exception e) {
                errorAuthCode.updateErrorList(e.toString(), kalturaLtiAuthCode.getAuthCode(), kalturaLtiAuthCode.getUserId());
            }

        }

        return RestUtil.processActionReturn(errorAuthCode);
    }

    /**
     * Inactivates a {@link KalturaLtiAuthCode} object
     * 
     * @param authCode the auth code
     */
    public ActionReturn inactivateAuthCode(String authCode) {
        ErrorAuthCode errorAuthCode = new ErrorAuthCode();

        authCodeService.inactivateAuthCode(authCode);

        return RestUtil.processActionReturn(errorAuthCode);
    }

}
