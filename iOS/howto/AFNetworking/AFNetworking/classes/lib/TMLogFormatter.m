//
//  TMLogFormatter.m
//  AFNetworking
//
//  Created by Tomoya on 2014/05/26.
//  Copyright (c) 2014年 Tomoya. All rights reserved.
//

#import "TMLogFormatter.h"

@implementation TMLogFormatter

- (NSString *)formatLogMessage:(DDLogMessage *)logMessage
{
    
    NSString *logLevel;
    switch (logMessage->logFlag)
    {
        case LOG_FLAG_ERROR : logLevel = @"E"; break;
        case LOG_FLAG_WARN  : logLevel = @"W"; break;
        case LOG_FLAG_INFO  : logLevel = @"I"; break;
        case LOG_FLAG_DEBUG : logLevel = @"D"; break;
        default             : logLevel = @"V"; break;
    }
    
    NSString *longFileName = [NSString stringWithFormat:@"%s",logMessage->file];
    NSString *fileName = [[longFileName componentsSeparatedByString:@"/"] lastObject];
    
    return [NSString stringWithFormat:@"%@:[%i]:[%@:%i]:[%s]:%@",
            logLevel,
            logMessage->machThreadID,
            fileName,
            logMessage->lineNumber,
            logMessage->function,
            logMessage->logMsg];
}

@end
