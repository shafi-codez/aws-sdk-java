/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.rds.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.services.rds.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * Describe Event Subscriptions Request Marshaller
 */
public class DescribeEventSubscriptionsRequestMarshaller implements Marshaller<Request<DescribeEventSubscriptionsRequest>, DescribeEventSubscriptionsRequest> {

    public Request<DescribeEventSubscriptionsRequest> marshall(DescribeEventSubscriptionsRequest describeEventSubscriptionsRequest) {

        if (describeEventSubscriptionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeEventSubscriptionsRequest> request = new DefaultRequest<DescribeEventSubscriptionsRequest>(describeEventSubscriptionsRequest, "AmazonRDS");
        request.addParameter("Action", "DescribeEventSubscriptions");
        request.addParameter("Version", "2013-09-09");

        if (describeEventSubscriptionsRequest.getSubscriptionName() != null) {
            request.addParameter("SubscriptionName", StringUtils.fromString(describeEventSubscriptionsRequest.getSubscriptionName()));
        }

        java.util.List<Filter> filtersList = describeEventSubscriptionsRequest.getFilters();
        int filtersListIndex = 1;

        for (Filter filtersListValue : filtersList) {
            Filter filterMember = filtersListValue;
            if (filterMember != null) {
                if (filterMember.getFilterName() != null) {
                    request.addParameter("Filters.Filter." + filtersListIndex + ".FilterName", StringUtils.fromString(filterMember.getFilterName()));
                }

                java.util.List<String> filterValueList = filterMember.getFilterValue();
                int filterValueListIndex = 1;

                for (String filterValueListValue : filterValueList) {
                    if (filterValueListValue != null) {
                        request.addParameter("Filters.Filter." + filtersListIndex + ".FilterValue.Value." + filterValueListIndex, StringUtils.fromString(filterValueListValue));
                    }

                    filterValueListIndex++;
                }
            }

            filtersListIndex++;
        }
        if (describeEventSubscriptionsRequest.getMaxRecords() != null) {
            request.addParameter("MaxRecords", StringUtils.fromInteger(describeEventSubscriptionsRequest.getMaxRecords()));
        }
        if (describeEventSubscriptionsRequest.getMarker() != null) {
            request.addParameter("Marker", StringUtils.fromString(describeEventSubscriptionsRequest.getMarker()));
        }

        return request;
    }
}
