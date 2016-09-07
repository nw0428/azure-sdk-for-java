/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batch.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Subscriptions.
 */
public final class SubscriptionsInner {
    /** The Retrofit service to perform REST calls. */
    private SubscriptionsService service;
    /** The service client containing this operation class. */
    private BatchManagementClientImpl client;

    /**
     * Initializes an instance of SubscriptionsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public SubscriptionsInner(Retrofit retrofit, BatchManagementClientImpl client) {
        this.service = retrofit.create(SubscriptionsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Subscriptions to be
     * used by Retrofit to perform actually REST calls.
     */
    interface SubscriptionsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Batch/locations/{locationName}/quotas")
        Observable<Response<ResponseBody>> getSubscriptionQuotas(@Path("locationName") String locationName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets the Batch service quotas for the specified suscription.
     *
     * @param locationName The desired region for the quotas.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the SubscriptionQuotasGetResultInner object if successful.
     */
    public SubscriptionQuotasGetResultInner getSubscriptionQuotas(String locationName) throws CloudException, IOException, IllegalArgumentException {
        return getSubscriptionQuotasWithServiceResponseAsync(locationName).toBlocking().single().getBody();
    }

    /**
     * Gets the Batch service quotas for the specified suscription.
     *
     * @param locationName The desired region for the quotas.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<SubscriptionQuotasGetResultInner> getSubscriptionQuotasAsync(String locationName, final ServiceCallback<SubscriptionQuotasGetResultInner> serviceCallback) {
        return ServiceCall.create(getSubscriptionQuotasWithServiceResponseAsync(locationName), serviceCallback);
    }

    /**
     * Gets the Batch service quotas for the specified suscription.
     *
     * @param locationName The desired region for the quotas.
     * @return the observable to the SubscriptionQuotasGetResultInner object
     */
    public Observable<SubscriptionQuotasGetResultInner> getSubscriptionQuotasAsync(String locationName) {
        return getSubscriptionQuotasWithServiceResponseAsync(locationName).map(new Func1<ServiceResponse<SubscriptionQuotasGetResultInner>, SubscriptionQuotasGetResultInner>() {
            @Override
            public SubscriptionQuotasGetResultInner call(ServiceResponse<SubscriptionQuotasGetResultInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Gets the Batch service quotas for the specified suscription.
     *
     * @param locationName The desired region for the quotas.
     * @return the observable to the SubscriptionQuotasGetResultInner object
     */
    public Observable<ServiceResponse<SubscriptionQuotasGetResultInner>> getSubscriptionQuotasWithServiceResponseAsync(String locationName) {
        if (locationName == null) {
            throw new IllegalArgumentException("Parameter locationName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.getSubscriptionQuotas(locationName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<SubscriptionQuotasGetResultInner>>>() {
                @Override
                public Observable<ServiceResponse<SubscriptionQuotasGetResultInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<SubscriptionQuotasGetResultInner> clientResponse = getSubscriptionQuotasDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<SubscriptionQuotasGetResultInner> getSubscriptionQuotasDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<SubscriptionQuotasGetResultInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<SubscriptionQuotasGetResultInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
