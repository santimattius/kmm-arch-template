//
//  PicturesViewModel.swift
//  ios-arch-template
//
//  Created by Santiago Mattiauda on 21/11/21.
//

import Foundation
import Combine
import shared
import SwiftUI

final class PictureViewModel:ObservableObject{
    
    @Published public var state: PictureViewState = .loading
    
    private var loaded = false
    
    private let sdk: PicturesSDK
    
    init(sdk: PicturesSDK){
        self.sdk = sdk
    }
    
    func loadPictures(){
        sdk.getPictures{ result, error in
           if let pictures = result {
               let data =  pictures.map{ item in
                    PictureUiModel(author: item.author, imageUrl: item.downloadUrl, link: item.url)
               }
               self.state = .result(data)
           } else {
               self.state = .error(error?.localizedDescription ?? "error")
           }
        }
    }
}
