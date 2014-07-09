//
//  TMHttpClient.m
//  AFNetworking
//
//  Created by 角田 智哉 on 2014/06/02.
//  Copyright (c) 2014年 Tomoya. All rights reserved.
//

#import "TMHttpClient.h"
#import "TMGlobal.h"
#import "TMAbstractHTTPManager.h"

@interface TMHttpClient()
@property (nonatomic, strong) TMAbstractHTTPManager *proxy;
@end

@implementation TMHttpClient

+ (instancetype)sharedManager {
    static id _client = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        _client = self.new;
    });
    return _client;
}

- (id)init {
    if (self = [super init]) {
        if(TMGlobal.isIOS7){
            //7.x
//            self.proxy = TMHTTPSessionManager.new;
        }else{
            //6.x
//            self.proxy = TMHTTPRequestOperationManager.new;
        }
    }
    return self;
}

+ (TMAbstractHTTPManager *)sharedAgent {
    return [self.sharedManager proxy];
}

@end
