//
//  TMLogUtils.m
//  AFNetworking
//
//  Created by Tomoya on 2014/05/26.
//  Copyright (c) 2014年 Tomoya. All rights reserved.
//

#import "TMLogUtils.h"
#import "DDASLLogger.h"
#import "DDTTYLogger.h"
#import "DDFileLogger.h"
#import "TMLogFormatter.h"
#import "AFNetworkActivityLogger.h"


@implementation TMLogUtils

+ (void)setup
{
    [self setupDDLog];
    [self startAFNActivityLog];
}



+ (void)setupDDLog
{
    // 1: sends log statements to Apple System Logger, so they show up on Console.app
    [DDLog addLogger:DDASLLogger.sharedInstance];
    
    // 2: sends log statements to Xcode console - if available
    [DDLog addLogger:DDTTYLogger.sharedInstance];
    DDTTYLogger.sharedInstance.logFormatter = TMLogFormatter.new;
#ifdef DEBUG
    DDTTYLogger.sharedInstance.colorsEnabled = YES;
#endif
    
    // 3: sends log statements to a file
    DDFileLogger *fileLogger = DDFileLogger.new;
    fileLogger.rollingFrequency = 60 * 60 * 24; // 24 hour rolling
    fileLogger.logFileManager.maximumNumberOfLogFiles = 5;
    [DDLog addLogger:fileLogger];
}


+ (void)startAFNActivityLog
{
    AFNetworkActivityLogger *logger = AFNetworkActivityLogger.sharedLogger;
#if defined(DEBUG) || defined(BETA)
    [logger setLevel:AFLoggerLevelDebug];
#else
    [logger setLevel:AFLoggerLevelOff];
#endif
    [logger startLogging];
}


@end
