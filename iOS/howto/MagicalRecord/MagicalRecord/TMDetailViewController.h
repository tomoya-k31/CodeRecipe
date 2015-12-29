//
//  TMDetailViewController.h
//  MagicalRecord
//
//  Created by 角田 智哉 on 2014/06/13.
//
//

#import <UIKit/UIKit.h>

@interface TMDetailViewController : UIViewController

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;
@end
