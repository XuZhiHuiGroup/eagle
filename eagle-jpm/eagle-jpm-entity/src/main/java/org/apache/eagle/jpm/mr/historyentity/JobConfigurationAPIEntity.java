/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.apache.eagle.jpm.mr.historyentity;

import org.apache.eagle.jpm.util.Constants;
import org.apache.eagle.log.entity.meta.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table("eaglejpa")
@ColumnFamily("f")
@Prefix("jconf")
@Service(Constants.MR_JOB_CONFIG_SERVICE_NAME)
@TimeSeries(true)
@Partition({"site"})
@Indexes({
        @Index(name = "Index_1_jobId", columns = { "jobId" }, unique = true),
        @Index(name = "Index_2_jobDefId", columns = { "jobDefId" }, unique = false)
    })
public class JobConfigurationAPIEntity extends JobBaseAPIEntity {
    
    @Column("a")
    private String configJobName;
    @Column("b")
    private JobConfig jobConfig;
    @Column("c")
    private String alertEmailList;
    
    public JobConfig getJobConfig() {
        return jobConfig;
    }

    public void setJobConfig(JobConfig jobConfig) {
        this.jobConfig = jobConfig;
        pcs.firePropertyChange("jobConfig", null, null);
    }

    public String getConfigJobName() {
        return configJobName;
    }

    public void setConfigJobName(String configJobName) {
        this.configJobName = configJobName;
        pcs.firePropertyChange("configJobName", null, null);
    }

    public String getAlertEmailList() {
        return alertEmailList;
    }

    public void setAlertEmailList(String alertEmailList) {
        this.alertEmailList = alertEmailList;
        pcs.firePropertyChange("alertEmailList", null, null);
    }
}
