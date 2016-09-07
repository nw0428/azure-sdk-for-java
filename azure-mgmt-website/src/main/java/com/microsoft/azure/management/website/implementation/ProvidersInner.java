/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.website.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceCall;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.RestException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Providers.
 */
public final class ProvidersInner {
    /** The Retrofit service to perform REST calls. */
    private ProvidersService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of ProvidersInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ProvidersInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(ProvidersService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Providers to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ProvidersService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("providers/Microsoft.Web/sourcecontrols")
        Observable<Response<ResponseBody>> getSourceControls(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("providers/Microsoft.Web/sourcecontrols/{sourceControlType}")
        Observable<Response<ResponseBody>> getSourceControl(@Path("sourceControlType") String sourceControlType, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("providers/Microsoft.Web/sourcecontrols/{sourceControlType}")
        Observable<Response<ResponseBody>> updateSourceControl(@Path("sourceControlType") String sourceControlType, @Body SourceControlInner requestMessage, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("providers/Microsoft.Web/publishingUsers/web")
        Observable<Response<ResponseBody>> getPublishingUser(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("providers/Microsoft.Web/publishingUsers/web")
        Observable<Response<ResponseBody>> updatePublishingUser(@Body UserInner requestMessage, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("{nextLink}")
        Observable<Response<ResponseBody>> getSourceControlsNext(@Path(value = "nextLink", encoded = true) String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PagedList&lt;SourceControlInner&gt; object if successful.
     */
    public PagedList<SourceControlInner> getSourceControls() throws CloudException, IOException, IllegalArgumentException {
        ServiceResponse<Page<SourceControlInner>> response = getSourceControlsSinglePageAsync().toBlocking().single();
        return new PagedList<SourceControlInner>(response.getBody()) {
            @Override
            public Page<SourceControlInner> nextPage(String nextPageLink) throws RestException, IOException {
                return getSourceControlsNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<SourceControlInner>> getSourceControlsAsync(final ListOperationCallback<SourceControlInner> serviceCallback) {
        return AzureServiceCall.create(
            getSourceControlsSinglePageAsync(),
            new Func1<String, Observable<ServiceResponse<Page<SourceControlInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SourceControlInner>>> call(String nextPageLink) {
                    return getSourceControlsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @return the observable to the PagedList&lt;SourceControlInner&gt; object
     */
    public Observable<Page<SourceControlInner>> getSourceControlsAsync() {
        return getSourceControlsWithServiceResponseAsync()
            .map(new Func1<ServiceResponse<Page<SourceControlInner>>, Page<SourceControlInner>>() {
                @Override
                public Page<SourceControlInner> call(ServiceResponse<Page<SourceControlInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @return the observable to the PagedList&lt;SourceControlInner&gt; object
     */
    public Observable<ServiceResponse<Page<SourceControlInner>>> getSourceControlsWithServiceResponseAsync() {
        return getSourceControlsSinglePageAsync()
            .concatMap(new Func1<ServiceResponse<Page<SourceControlInner>>, Observable<ServiceResponse<Page<SourceControlInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SourceControlInner>>> call(ServiceResponse<Page<SourceControlInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(getSourceControlsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @return the PagedList&lt;SourceControlInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<SourceControlInner>>> getSourceControlsSinglePageAsync() {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.getSourceControls(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<SourceControlInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SourceControlInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<SourceControlInner>> result = getSourceControlsDelegate(response);
                        return Observable.just(new ServiceResponse<Page<SourceControlInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<SourceControlInner>> getSourceControlsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<SourceControlInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<SourceControlInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets source control token.
     *
     * @param sourceControlType Type of source control
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the SourceControlInner object if successful.
     */
    public SourceControlInner getSourceControl(String sourceControlType) throws CloudException, IOException, IllegalArgumentException {
        return getSourceControlWithServiceResponseAsync(sourceControlType).toBlocking().single().getBody();
    }

    /**
     * Gets source control token.
     *
     * @param sourceControlType Type of source control
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<SourceControlInner> getSourceControlAsync(String sourceControlType, final ServiceCallback<SourceControlInner> serviceCallback) {
        return ServiceCall.create(getSourceControlWithServiceResponseAsync(sourceControlType), serviceCallback);
    }

    /**
     * Gets source control token.
     *
     * @param sourceControlType Type of source control
     * @return the observable to the SourceControlInner object
     */
    public Observable<SourceControlInner> getSourceControlAsync(String sourceControlType) {
        return getSourceControlWithServiceResponseAsync(sourceControlType).map(new Func1<ServiceResponse<SourceControlInner>, SourceControlInner>() {
            @Override
            public SourceControlInner call(ServiceResponse<SourceControlInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Gets source control token.
     *
     * @param sourceControlType Type of source control
     * @return the observable to the SourceControlInner object
     */
    public Observable<ServiceResponse<SourceControlInner>> getSourceControlWithServiceResponseAsync(String sourceControlType) {
        if (sourceControlType == null) {
            throw new IllegalArgumentException("Parameter sourceControlType is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.getSourceControl(sourceControlType, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<SourceControlInner>>>() {
                @Override
                public Observable<ServiceResponse<SourceControlInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<SourceControlInner> clientResponse = getSourceControlDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<SourceControlInner> getSourceControlDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<SourceControlInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<SourceControlInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Updates source control token.
     *
     * @param sourceControlType Type of source control
     * @param requestMessage Source control token information
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the SourceControlInner object if successful.
     */
    public SourceControlInner updateSourceControl(String sourceControlType, SourceControlInner requestMessage) throws CloudException, IOException, IllegalArgumentException {
        return updateSourceControlWithServiceResponseAsync(sourceControlType, requestMessage).toBlocking().single().getBody();
    }

    /**
     * Updates source control token.
     *
     * @param sourceControlType Type of source control
     * @param requestMessage Source control token information
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<SourceControlInner> updateSourceControlAsync(String sourceControlType, SourceControlInner requestMessage, final ServiceCallback<SourceControlInner> serviceCallback) {
        return ServiceCall.create(updateSourceControlWithServiceResponseAsync(sourceControlType, requestMessage), serviceCallback);
    }

    /**
     * Updates source control token.
     *
     * @param sourceControlType Type of source control
     * @param requestMessage Source control token information
     * @return the observable to the SourceControlInner object
     */
    public Observable<SourceControlInner> updateSourceControlAsync(String sourceControlType, SourceControlInner requestMessage) {
        return updateSourceControlWithServiceResponseAsync(sourceControlType, requestMessage).map(new Func1<ServiceResponse<SourceControlInner>, SourceControlInner>() {
            @Override
            public SourceControlInner call(ServiceResponse<SourceControlInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Updates source control token.
     *
     * @param sourceControlType Type of source control
     * @param requestMessage Source control token information
     * @return the observable to the SourceControlInner object
     */
    public Observable<ServiceResponse<SourceControlInner>> updateSourceControlWithServiceResponseAsync(String sourceControlType, SourceControlInner requestMessage) {
        if (sourceControlType == null) {
            throw new IllegalArgumentException("Parameter sourceControlType is required and cannot be null.");
        }
        if (requestMessage == null) {
            throw new IllegalArgumentException("Parameter requestMessage is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(requestMessage);
        return service.updateSourceControl(sourceControlType, requestMessage, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<SourceControlInner>>>() {
                @Override
                public Observable<ServiceResponse<SourceControlInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<SourceControlInner> clientResponse = updateSourceControlDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<SourceControlInner> updateSourceControlDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<SourceControlInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<SourceControlInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets publishing user.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UserInner object if successful.
     */
    public UserInner getPublishingUser() throws CloudException, IOException, IllegalArgumentException {
        return getPublishingUserWithServiceResponseAsync().toBlocking().single().getBody();
    }

    /**
     * Gets publishing user.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<UserInner> getPublishingUserAsync(final ServiceCallback<UserInner> serviceCallback) {
        return ServiceCall.create(getPublishingUserWithServiceResponseAsync(), serviceCallback);
    }

    /**
     * Gets publishing user.
     *
     * @return the observable to the UserInner object
     */
    public Observable<UserInner> getPublishingUserAsync() {
        return getPublishingUserWithServiceResponseAsync().map(new Func1<ServiceResponse<UserInner>, UserInner>() {
            @Override
            public UserInner call(ServiceResponse<UserInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Gets publishing user.
     *
     * @return the observable to the UserInner object
     */
    public Observable<ServiceResponse<UserInner>> getPublishingUserWithServiceResponseAsync() {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.getPublishingUser(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<UserInner>>>() {
                @Override
                public Observable<ServiceResponse<UserInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<UserInner> clientResponse = getPublishingUserDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<UserInner> getPublishingUserDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<UserInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<UserInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Updates publishing user.
     *
     * @param requestMessage Details of publishing user
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UserInner object if successful.
     */
    public UserInner updatePublishingUser(UserInner requestMessage) throws CloudException, IOException, IllegalArgumentException {
        return updatePublishingUserWithServiceResponseAsync(requestMessage).toBlocking().single().getBody();
    }

    /**
     * Updates publishing user.
     *
     * @param requestMessage Details of publishing user
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<UserInner> updatePublishingUserAsync(UserInner requestMessage, final ServiceCallback<UserInner> serviceCallback) {
        return ServiceCall.create(updatePublishingUserWithServiceResponseAsync(requestMessage), serviceCallback);
    }

    /**
     * Updates publishing user.
     *
     * @param requestMessage Details of publishing user
     * @return the observable to the UserInner object
     */
    public Observable<UserInner> updatePublishingUserAsync(UserInner requestMessage) {
        return updatePublishingUserWithServiceResponseAsync(requestMessage).map(new Func1<ServiceResponse<UserInner>, UserInner>() {
            @Override
            public UserInner call(ServiceResponse<UserInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Updates publishing user.
     *
     * @param requestMessage Details of publishing user
     * @return the observable to the UserInner object
     */
    public Observable<ServiceResponse<UserInner>> updatePublishingUserWithServiceResponseAsync(UserInner requestMessage) {
        if (requestMessage == null) {
            throw new IllegalArgumentException("Parameter requestMessage is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(requestMessage);
        return service.updatePublishingUser(requestMessage, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<UserInner>>>() {
                @Override
                public Observable<ServiceResponse<UserInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<UserInner> clientResponse = updatePublishingUserDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<UserInner> updatePublishingUserDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<UserInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<UserInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PagedList&lt;SourceControlInner&gt; object if successful.
     */
    public PagedList<SourceControlInner> getSourceControlsNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException {
        ServiceResponse<Page<SourceControlInner>> response = getSourceControlsNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<SourceControlInner>(response.getBody()) {
            @Override
            public Page<SourceControlInner> nextPage(String nextPageLink) throws RestException, IOException {
                return getSourceControlsNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<SourceControlInner>> getSourceControlsNextAsync(final String nextPageLink, final ServiceCall<List<SourceControlInner>> serviceCall, final ListOperationCallback<SourceControlInner> serviceCallback) {
        return AzureServiceCall.create(
            getSourceControlsNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<SourceControlInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SourceControlInner>>> call(String nextPageLink) {
                    return getSourceControlsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;SourceControlInner&gt; object
     */
    public Observable<Page<SourceControlInner>> getSourceControlsNextAsync(final String nextPageLink) {
        return getSourceControlsNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<SourceControlInner>>, Page<SourceControlInner>>() {
                @Override
                public Page<SourceControlInner> call(ServiceResponse<Page<SourceControlInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;SourceControlInner&gt; object
     */
    public Observable<ServiceResponse<Page<SourceControlInner>>> getSourceControlsNextWithServiceResponseAsync(final String nextPageLink) {
        return getSourceControlsNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<SourceControlInner>>, Observable<ServiceResponse<Page<SourceControlInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SourceControlInner>>> call(ServiceResponse<Page<SourceControlInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(getSourceControlsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets the source controls available for Azure websites.
     *
    ServiceResponse<PageImpl<SourceControlInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the PagedList&lt;SourceControlInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<SourceControlInner>>> getSourceControlsNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        return service.getSourceControlsNext(nextPageLink, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<SourceControlInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SourceControlInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<SourceControlInner>> result = getSourceControlsNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<SourceControlInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<SourceControlInner>> getSourceControlsNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<SourceControlInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<SourceControlInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
