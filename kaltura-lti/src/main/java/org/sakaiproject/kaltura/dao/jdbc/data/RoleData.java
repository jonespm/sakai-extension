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
package org.sakaiproject.kaltura.dao.jdbc.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.kaltura.dao.jdbc.Database;
import org.sakaiproject.kaltura.dao.jdbc.sql.RoleSql;

/**
 * Processes app-specific role services dao needs
 * 
 * @author Robert Long (rlong @ unicon.net)
 */
public class RoleData extends Database {

    private final Log log = LogFactory.getLog(RoleData.class);

    /**
     * Gets all Sakai roles defined from the database
     * 
     * @return a list of the Sakai role IDs
     */
    public List<String> getSakaiRoles() {
        List<String> sakaiRolesList = new ArrayList<String>();

        PreparedStatement preparedStatement = null;

        try {
            String query = RoleSql.getSakaiRoles();

            preparedStatement = createPreparedStatement(preparedStatement, query);

            ResultSet resultSet = executeQueryPreparedStatement(preparedStatement);

            while(resultSet.next()) {
                sakaiRolesList.add(resultSet.getString("ROLE_NAME"));
            }
        } catch (Exception e) {
            log.error("Error getting Sakai roles data. Error: " + e, e);
        } finally {
            closePreparedStatement(preparedStatement);
        }

        return sakaiRolesList;
    }

}