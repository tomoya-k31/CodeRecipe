//
//  TMMasterViewController.h
//  MagicalRecord
//
//  Created by 角田 智哉 on 2014/06/13.
//
//

#import <UIKit/UIKit.h>

#import <CoreData/CoreData.h>

@interface TMMasterViewController : UITableViewController <NSFetchedResultsControllerDelegate>

@property (strong, nonatomic) NSFetchedResultsController *fetchedResultsController;
@property (strong, nonatomic) NSManagedObjectContext *managedObjectContext;

@end
