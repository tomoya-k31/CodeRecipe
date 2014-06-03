//
//  TMGlobal.m
//  AFNetworking
//
//  Created by 角田 智哉 on 2014/06/01.
//  Copyright (c) 2014年 Tomoya. All rights reserved.
//

#import "TMGlobal.h"

@implementation TMGlobal


+ (BOOL)isIOS7
{
    return floor(NSFoundationVersionNumber) > NSFoundationVersionNumber_iOS_6_1;
}

@end
