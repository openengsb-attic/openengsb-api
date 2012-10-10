/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openengsb.core.api.model;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.openengsb.core.api.TransferMap;

import com.google.common.base.Objects;

/**
 * Container class that describes a connector. It serves as common model for
 * {@link org.openengsb.core.api.model.ConnectorConfiguration} in
 * {@link org.openengsb.core.api.persistence.ConfigPersistenceService} and the registration
 * {@link org.openengsb.core.api.ConnectorRegistrationManage}.
 * 
 * The description has two components: "attributes" and "properties".
 * 
 * Attributes are used to describe the field-values of the service objects. A
 * {@link org.openengsb.core.api.ConnectorInstanceFactory} defines the mapping of attributes to the corresponding
 * fields.
 * 
 * Properties are a collection of additional Service-properties for the osgi-service-registry (see OSGi 4.2 core
 * specification for more details http://www.osgi.org/Download/Release4V42).
 */
@SuppressWarnings("serial")
@XmlRootElement
public class ConnectorDescription implements Serializable {

    private String domainType;
    private String connectorType;
    private TransferMap attributes = new TransferMap();
    private TransferMap properties = new TransferMap();

    public TransferMap getAttributes() {
        return attributes;
    }

    public void setAttributes(TransferMap attributes) {
        this.attributes = attributes;
    }

    public TransferMap getProperties() {
        return properties;
    }

    public void setProperties(TransferMap properties) {
        this.properties = properties;
    }

    public ConnectorDescription() {
    }

    public ConnectorDescription(String domainType, String connectorType) {
        this.domainType = domainType;
        this.connectorType = connectorType;
    }

    public ConnectorDescription(String domainType, String connectorType, Map<String, String> attributes,
            Map<String, Object> properties) {
        this(domainType, connectorType);
        if (attributes != null) {
            this.attributes.putAll(attributes);
        }
        if (properties != null) {
            this.properties.putAll(properties);
        }
    }

    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }

    public String getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes.putAll(attributes);
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties.putAll(properties);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("domainType", domainType)
            .add("connectorType", connectorType)
            .add("attributes", attributes)
            .add("properties", properties)
            .toString();
    }
}
