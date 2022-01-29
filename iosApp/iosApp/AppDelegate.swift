//
//  AppDelegate.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 28/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import UIKit
import shared

class AppDelegate: NSObject, UIApplicationDelegate {
    
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        PictureModulesKt.doInitModule(databaseDriverFactory: DatabaseDriverFactory())
        return true
    }
}

