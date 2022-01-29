//
//  DependencyProvider.swift
//  ios-arch-template
//
//  Created by Santiago Mattiauda on 21/11/21.
//

import Foundation
import shared

final class DependencyProvider {
    
    static let shared = DependencyProvider()
    
    private init(){}
    
    func providePictureViewModel() -> PictureViewModel {
        return PictureViewModel(sdk: provideSdk())
    }
    
    private func provideSdk() -> PicturesSDK {
        return PicturesSDK()
    }
    
}
