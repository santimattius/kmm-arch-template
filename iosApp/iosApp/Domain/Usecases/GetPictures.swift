//
//  GetPictures.swift
//  ios-arch-template
//
//  Created by Santiago Mattiauda on 2/12/21.
//

import Foundation
import shared

final class GetPictures {
    
    private let sdk: PicturesSDK
    
    init(sdk:PicturesSDK){
        self.sdk = sdk
    }
    
    func invoke() async -> [Picture] {
        return await repository.getPictures()
    }
}
