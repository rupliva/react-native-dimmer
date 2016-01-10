#import "RNDimmer.h"

@implementation RNDimmer

RCT_EXPORT_MODULE();

RCT_REMAP_METHOD(set, setIdleTimerDisabled:(BOOL)disabled resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject) {
    @try {
        NSArray *result = @[];
        [UIApplication sharedApplication].idleTimerDisabled = disabled;
        resolve(result);
    }
    @catch (NSException *exception) {
        reject(exception);
    }
}

@end
