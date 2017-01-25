//
//  ViewController.m
//  OutBuilding-iOS
//
//  Created by Engineering on 18/01/2017.
//  Copyright © 2017 OutSystems. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

@synthesize imageView;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    // This could be in the storyboard!
    UIImage *image = [UIImage imageNamed:@"vr_troopers.jpg"];
    imageView = [[UIImageView alloc] initWithImage:image];
    [self.view addSubview:imageView];
    
    // We need this to say to the view the size of the image we want to display
    [(UIScrollView *)self.view setContentSize: [image size]];
    
    // Set the zoom scale
    [(UIScrollView *)self.view setMaximumZoomScale:3.0];
    [(UIScrollView *)self.view setMinimumZoomScale:1.0];
    
    // Set the marker in front of the background
    UIImage *marker = [UIImage imageNamed:@"marker"];
    markerView = [[UIImageView alloc] initWithImage:marker];
    markerView.frame = CGRectMake(300, 300, 50, 50);
    [imageView addSubview:markerView];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

// This method tells the view what image we are trying to zoom
- (UIView *)viewForZoomingInScrollView:(UIScrollView *)scrollView{
    return imageView;
}

@end
