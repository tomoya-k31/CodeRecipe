//
//  TMAbstractHTTPManager.h
//  AFNetworking
//
//  Created by 角田 智哉 on 2014/06/02.
//  Copyright (c) 2014年 Tomoya. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef void (^TMHTTPRequestSuccess)(NSURLResponse *response, id responseObject);
typedef void (^TMHTTPRequestFailure)(NSURLResponse *response, NSError *error);

@protocol TMAbstractHTTPManagerProxy
@required
- (void)GET:(NSString *)URLString
 parameters:(NSDictionary *)parameters
    success:(TMHTTPRequestSuccess)success
    failure:(TMHTTPRequestFailure)failure;

- (void)POST:(NSString *)URLString parameters:(NSDictionary *)parameters
     success:(TMHTTPRequestSuccess)success
     failure:(TMHTTPRequestFailure)failure;

@optional


@end

@interface TMAbstractHTTPManager : NSObject<TMAbstractHTTPManagerProxy>

@end
