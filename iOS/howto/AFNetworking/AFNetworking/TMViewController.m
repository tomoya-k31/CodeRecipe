//
//  TMViewController.m
//  AFNetworking
//
//  Created by Tomoya on 2014/05/25.
//  Copyright (c) 2014年 Tomoya. All rights reserved.
//

#import "TMViewController.h"

#import <CoreTelephony/CTTelephonyNetworkInfo.h>
#import <CoreTelephony/CTCarrier.h>

@interface TMViewController ()

@end

@implementation TMViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    CTTelephonyNetworkInfo *netinfo = [[CTTelephonyNetworkInfo alloc] init];
    CTCarrier *carrier = [netinfo subscriberCellularProvider];
    NSLog(@"carrierName:%@",carrier.carrierName);
    NSLog(@"carrierName: %@", carrier.carrierName);
    NSLog(@"mobileCountryCode: %@", carrier.mobileCountryCode);
    NSLog(@"mobileNetworkCode: %@", carrier.mobileNetworkCode);
    NSLog(@"isoCountryCode: %@", carrier.isoCountryCode);
    NSLog(@"allowsVOIP: %hhd", carrier.allowsVOIP);
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
